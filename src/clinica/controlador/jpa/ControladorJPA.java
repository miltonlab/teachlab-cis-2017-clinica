/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controlador.jpa;

import clinica.modelo.jpa.Medicos;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author miltonlab
 */
public class ControladorJPA {
    
    public static void main(String[] args) { 
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("ClinicaUP");
        EntityManager em = emf.createEntityManager();
        Medicos m = new Medicos();
        m.setId(2);
        m.setCedula("1111111111");
        m.setApellidos("Guaman");
        m.setNombres("Miguel");
        m.setEspecialidad("Odontología");
        try{
            /*em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            System.out.println("Objeto Medicos guardado !!!");*/
            String jpaql  = "SELECT m FROM Medicos m";
            Query query = em.createQuery(jpaql);
            List<Medicos> lista =  query.getResultList();
            for (Medicos m1 : lista) {
                System.out.printf("%d | %s |%s |%s |%s%n", m1.getId(), m1.getCedula(), 
                        m1.getNombres(), m1.getApellidos(), m1.getEspecialidad());
            }
            
            
        }catch(Exception ex){
            System.out.println("error: " + ex);
        }finally{
            em.close();
        }
        
        
    }
    
}
