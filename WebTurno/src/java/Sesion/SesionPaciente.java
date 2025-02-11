package Sesion;

import EntityBeans.*;
import SessionBeans.CitaFacadeLocal;
import SessionBeans.PacienteFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "SesionPaciente")
@SessionScoped
public class SesionPaciente implements Serializable {

    @EJB
    private PacienteFacadeLocal manejadorPaciente;
    @EJB
    private CitaFacadeLocal manejadorCita;

    private Paciente pacienteSesion;
    private String clave;
    private List<Cita> citasAceptadas;

    public SesionPaciente() {
    }

    @PostConstruct
    public void init() {
        try {
            pacienteSesion = new Paciente();
            reporteCita();
            verificarSesionPaciente();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "", "Error en el método init: " + e.getMessage()));
        }
    }

    public void verificarSesionPaciente() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Paciente us = (Paciente) context.getExternalContext().getSessionMap().get("paciente");
            setPacienteSesion(us);
            if (us == null) {
                context.getExternalContext().redirect("inicioPaciente.xhtml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearPaciente() {
        try {
            getManejadorPaciente().create(getPacienteSesion());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "", "Credenciales Registradas"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "", "Credenciales Duplicadas" + e.getMessage()));
        }
    }

    public void editarPaciente() {
        if (getClave().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Es necesario introducir una nueva contraseña"));
        } else {
            pacienteSesion.setClave(getClave());
            getManejadorPaciente().edit(pacienteSesion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Los cambios han sido registrados"));
        }
    }

    public void reporteCita() {

        setCitasAceptadas(manejadorCita.findAll());

        verificarSesionPaciente();
        List<Cita> todasLasCitas = getCitasAceptadas();
        List<Cita> citasPaci = new ArrayList<Cita>();

        for (Cita cita : todasLasCitas) {
            if (pacienteSesion.getNumCedula().equals(cita.getIdPacientes().getNumCedula())) {
                citasPaci.add(cita);
            }
            setCitasAceptadas(citasPaci);
        }
    }

    public Paciente getPacienteSesion() {
        return pacienteSesion;
    }

    public void setPacienteSesion(Paciente clienteSesion) {
        this.pacienteSesion = pacienteSesion;
    }

    public List<Cita> getCitasAceptadas() {
        return citasAceptadas;
    }

    public void setCitasAceptadas(List<Cita> citasAceptadas) {
        this.citasAceptadas = citasAceptadas;
    }

    public PacienteFacadeLocal getManejadorPaciente() {
        return manejadorPaciente;
    }

    public void setManejadorPaciente(PacienteFacadeLocal manejadorPaciente) {
        this.manejadorPaciente = manejadorPaciente;
    }

    public CitaFacadeLocal getManejadorCita() {
        return manejadorCita;
    }

    public void setManejadorCita(CitaFacadeLocal manejadorCita) {
        this.manejadorCita = manejadorCita;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
