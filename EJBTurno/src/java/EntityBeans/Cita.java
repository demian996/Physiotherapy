/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc3
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByIdCita", query = "SELECT c FROM Cita c WHERE c.idCita = :idCita"),
    @NamedQuery(name = "Cita.findByHorario", query = "SELECT c FROM Cita c WHERE c.horario = :horario"),
    @NamedQuery(name = "Cita.findByEstado", query = "SELECT c FROM Cita c WHERE c.estado = :estado")})
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cita")
    private Integer idCita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "horario")
    private String horario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago")
    @ManyToOne(optional = false)
    private Pago idPago;
    @JoinColumn(name = "id_pacientes", referencedColumnName = "num_cedula")
    @ManyToOne(optional = false)
    private Paciente idPacientes;
    @JoinColumn(name = "id_fisioterapeuta", referencedColumnName = "num_cedula")
    @ManyToOne(optional = false)
    private Fisioterapeuta idFisioterapeuta;

    public Cita() {
    }

    public Cita(Integer idCita) {
        this.idCita = idCita;
    }

    public Cita(Integer idCita, String horario, String estado) {
        this.idCita = idCita;
        this.horario = horario;
        this.estado = estado;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Pago getIdPago() {
        return idPago;
    }

    public void setIdPago(Pago idPago) {
        this.idPago = idPago;
    }

    public Paciente getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(Paciente idPacientes) {
        this.idPacientes = idPacientes;
    }

    public Fisioterapeuta getIdFisioterapeuta() {
        return idFisioterapeuta;
    }

    public void setIdFisioterapeuta(Fisioterapeuta idFisioterapeuta) {
        this.idFisioterapeuta = idFisioterapeuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (""+idCita);
    }
    
}
