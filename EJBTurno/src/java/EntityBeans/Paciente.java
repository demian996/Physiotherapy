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
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByNumCedula", query = "SELECT p FROM Paciente p WHERE p.numCedula = :numCedula"),
    @NamedQuery(name = "Paciente.findByNombres", query = "SELECT p FROM Paciente p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Paciente.findByApellidos", query = "SELECT p FROM Paciente p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Paciente.findByClave", query = "SELECT p FROM Paciente p WHERE p.clave = :clave"),
    @NamedQuery(name = "Paciente.findByTelefono", query = "SELECT p FROM Paciente p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Paciente.findByCorreoe", query = "SELECT p FROM Paciente p WHERE p.correoe = :correoe"),
    @NamedQuery(name = "Paciente.findByUsuario", query = "SELECT p FROM Paciente p WHERE p.correoe = :correoe AND p.clave = :clave"),
    @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento")})
public class Paciente implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPacientes")
    private Collection<Cita> citaCollection;

    public Paciente() {
    }

    public Paciente(String numCedula) {
        this.numCedula = numCedula;
    }

    public Paciente(String numCedula, String fechaNacimiento) {
        this.numCedula = numCedula;
        this.fechaNacimiento = fechaNacimiento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCedula != null ? numCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.numCedula == null && other.numCedula != null) || (this.numCedula != null && !this.numCedula.equals(other.numCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (""+numCedula);
    }
    
}
