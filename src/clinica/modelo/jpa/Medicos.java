/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.modelo.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miltonlab
 */
@Entity
@Table(name = "MEDICOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicos.findAll", query = "SELECT m FROM Medicos m")
    , @NamedQuery(name = "Medicos.findById", query = "SELECT m FROM Medicos m WHERE m.id = :id")
    , @NamedQuery(name = "Medicos.findByCedula", query = "SELECT m FROM Medicos m WHERE m.cedula = :cedula")
    , @NamedQuery(name = "Medicos.findByNombres", query = "SELECT m FROM Medicos m WHERE m.nombres = :nombres")
    , @NamedQuery(name = "Medicos.findByApellidos", query = "SELECT m FROM Medicos m WHERE m.apellidos = :apellidos")
    , @NamedQuery(name = "Medicos.findByEspecialidad", query = "SELECT m FROM Medicos m WHERE m.especialidad = :especialidad")})
public class Medicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "ESPECIALIDAD")
    private String especialidad;

    public Medicos() {
    }

    public Medicos(Integer id) {
        this.id = id;
    }

    public Medicos(Integer id, String cedula, String apellidos) {
        this.id = id;
        this.cedula = cedula;
        this.apellidos = apellidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicos)) {
            return false;
        }
        Medicos other = (Medicos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clinica.modelo.jpa.Medicos[ id=" + id + " ]";
    }
    
}
