/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controlador.jpa;

import clinica.controlador.jpa.exceptions.NonexistentEntityException;
import clinica.controlador.jpa.exceptions.PreexistingEntityException;
import clinica.modelo.jpa.Especialidades;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author miltonlab
 */
public class EspecialidadesJpaController implements Serializable {

    public EspecialidadesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Especialidades especialidades) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(especialidades);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEspecialidades(especialidades.getId()) != null) {
                throw new PreexistingEntityException("Especialidades " + especialidades + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Especialidades especialidades) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            especialidades = em.merge(especialidades);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = especialidades.getId();
                if (findEspecialidades(id) == null) {
                    throw new NonexistentEntityException("The especialidades with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidades especialidades;
            try {
                especialidades = em.getReference(Especialidades.class, id);
                especialidades.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especialidades with id " + id + " no longer exists.", enfe);
            }
            em.remove(especialidades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Especialidades> findEspecialidadesEntities() {
        return findEspecialidadesEntities(true, -1, -1);
    }

    public List<Especialidades> findEspecialidadesEntities(int maxResults, int firstResult) {
        return findEspecialidadesEntities(false, maxResults, firstResult);
    }

    private List<Especialidades> findEspecialidadesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especialidades.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Especialidades findEspecialidades(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especialidades.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspecialidadesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especialidades> rt = cq.from(Especialidades.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
