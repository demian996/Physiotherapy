/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc3
 */
@Entity
@Table(name = "clinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinica.findAll", query = "SELECT c FROM Clinica c"),
    @NamedQuery(name = "Clinica.findByIdClinica", query = "SELECT c FROM Clinica c WHERE c.idClinica = :idClinica"),
    @NamedQuery(name = "Clinica.findByNombre", query = "SELECT c FROM Clinica c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Clinica.findByRuc", query = "SELECT c FROM Clinica c WHERE c.ruc = :ruc"),
    @NamedQuery(name = "Clinica.findByDireccion", query = "SELECT c FROM Clinica c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Clinica.findByHorarioatencion", query = "SELECT c FROM Clinica c WHERE c.horarioatencion = :horarioatencion"),
    @NamedQuery(name = "Clinica.findByTelefono", query = "SELECT c FROM Clinica c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Clinica.findByClave", query = "SELECT c FROM Clinica c WHERE c.clave = :clave"),
    @NamedQuery(name = "Clinica.findByCorreoe", query = "SELECT c FROM Clinica c WHERE c.correoe = :correoe")})
public class Clinica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_clinica")
    private Integer idClinica;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 255)
    @Column(name = "horarioatencion")
    private String horarioatencion;
    @Size(max = 255)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 255)
    @Column(name = "clave")
    private String clave;
    @Size(max = 255)
    @Column(name = "correoe")
    private String correoe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica")
    private Collection<Fisioterapeuta> fisioterapeutaCollection;

    public Clinica() {
    }

    public Clinica(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public Integer getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorarioatencion() {
        return horarioatencion;
    }

    public void setHorarioatencion(String horarioatencion) {
        this.horarioatencion = horarioatencion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreoe() {
        return correoe;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    @XmlTransient
    public Collection<Fisioterapeuta> getFisioterapeutaCollection() {
        return fisioterapeutaCollection;
    }

    public void setFisioterapeutaCollection(Collection<Fisioterapeuta> fisioterapeutaCollection) {
        this.fisioterapeutaCollection = fisioterapeutaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClinica != null ? idClinica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinica)) {
            return false;
        }
        Clinica other = (Clinica) object;
        if ((this.idClinica == null && other.idClinica != null) || (this.idClinica != null && !this.idClinica.equals(other.idClinica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (""+idClinica);
    }
    
}
