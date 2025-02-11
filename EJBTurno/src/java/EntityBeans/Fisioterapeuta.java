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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "fisioterapeuta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fisioterapeuta.findAll", query = "SELECT f FROM Fisioterapeuta f"),
    @NamedQuery(name = "Fisioterapeuta.findByNumCedula", query = "SELECT f FROM Fisioterapeuta f WHERE f.numCedula = :numCedula"),
    @NamedQuery(name = "Fisioterapeuta.findByNombres", query = "SELECT f FROM Fisioterapeuta f WHERE f.nombres = :nombres"),
    @NamedQuery(name = "Fisioterapeuta.findByApellidos", query = "SELECT f FROM Fisioterapeuta f WHERE f.apellidos = :apellidos"),
    @NamedQuery(name = "Fisioterapeuta.findByClave", query = "SELECT f FROM Fisioterapeuta f WHERE f.clave = :clave"),
    @NamedQuery(name = "Fisioterapeuta.findByTelefono", query = "SELECT f FROM Fisioterapeuta f WHERE f.telefono = :telefono"),
    @NamedQuery(name = "Fisioterapeuta.findByCorreoe", query = "SELECT f FROM Fisioterapeuta f WHERE f.correoe = :correoe"),
    @NamedQuery(name = "Fisioterapeuta.findByUsuario", query = "SELECT p FROM Fisioterapeuta p WHERE p.correoe = :correoe AND p.clave = :clave"),
    @NamedQuery(name = "Fisioterapeuta.findByFechaNacimiento", query = "SELECT f FROM Fisioterapeuta f WHERE f.fechaNacimiento = :fechaNacimiento")})
public class Fisioterapeuta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "num_cedula")
    private String numCedula;
    @Size(max = 255)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 255)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 255)
    @Column(name = "clave")
    private String clave;
    @Size(max = 255)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 255)
    @Column(name = "correoe")
    private String correoe;
    @Size(max = 255)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFisioterapeuta")
    private Collection<Cita> citaCollection;
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false)
    private Clinica idClinica;

    public Fisioterapeuta() {
    }

    public Fisioterapeuta(String numCedula) {
        this.numCedula = numCedula;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoe() {
        return correoe;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    public Clinica getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Clinica idClinica) {
        this.idClinica = idClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCedula != null ? numCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fisioterapeuta)) {
            return false;
        }
        Fisioterapeuta other = (Fisioterapeuta) object;
        if ((this.numCedula == null && other.numCedula != null) || (this.numCedula != null && !this.numCedula.equals(other.numCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.Fisioterapeuta[ numCedula=" + numCedula + " ]";
    }
    
}
