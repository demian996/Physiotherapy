package Sesion;

import EntityBeans.*;
import SessionBeans.CitaFacadeLocal;
import SessionBeans.ClinicaFacadeLocal;
import SessionBeans.FisioterapeutaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "SesionFisioterapeuta")
@SessionScoped
public class SesionFisioterapeuta implements Serializable {

    @EJB
    private CitaFacadeLocal manejadorCita;
    @EJB
    private FisioterapeutaFacadeLocal manejadorFisioterapeuta;
    @EJB
    private ClinicaFacadeLocal manejadorClinica;

    private List<Cita> citasVirtuales;
    private Fisioterapeuta fisioterapeutaSesion;
    private String clave;
    private Integer idClinica;

    public SesionFisioterapeuta() {
    }

    public void verificarSesionFisioterapeuta() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Fisioterapeuta us = (Fisioterapeuta) context.getExternalContext().getSessionMap().get("fisioterapeuta");
            setFisioterapeutaSesion(us);
            if (us == null) {
                context.getExternalContext().redirect("inicioFisioterapeuta.xhtml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarFisioterapeuta() {
        if (getClave().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Es necesario introducir una nueva contraseña"));
        } else {
            fisioterapeutaSesion.setClave(getClave());
            getManejadorFisioterapeuta().edit(fisioterapeutaSesion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Los cambios han sido registrados"));
        }
    }

    public void crearFisioterapeuta() {
        try {
            fisioterapeutaSesion.setIdClinica(getManejadorClinica().find(this.getIdClinica()));
            getManejadorFisioterapeuta().create(fisioterapeutaSesion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "", "Credenciales Registradas"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "", "Credenciales Duplicadas" + e.getMessage()));
        }
    }

    public void reporteCita() {

        setCitasVirtuales(getManejadorCita().findAll());

        verificarSesionFisioterapeuta();
        List<Cita> todasLasCitas = getCitasVirtuales();
        List<Cita> citasFisio = new ArrayList<Cita>();

        for (Cita cita : todasLasCitas) {
            if (fisioterapeutaSesion.getNumCedula().equals(cita.getIdFisioterapeuta().getNumCedula())) {
                citasFisio.add(cita);
            }
            setCitasVirtuales(citasFisio);
        }
    }

    @PostConstruct
    public void inicio() {
        fisioterapeutaSesion = new Fisioterapeuta();
        try {
            reporteCita();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "", "Error en el método init: " + e.getMessage()));
        }
    }

    public Fisioterapeuta getFisioterapeutaSesion() {
        return fisioterapeutaSesion;
    }

    public void setFisioterapeutaSesion(Fisioterapeuta fisioterapeutaSesion) {
        this.fisioterapeutaSesion = fisioterapeutaSesion;
    }

    public List<Cita> getCitasVirtuales() {
        return citasVirtuales;
    }

    public void setCitasVirtuales(List<Cita> citasVirtuales) {
        this.citasVirtuales = citasVirtuales;
    }

    public CitaFacadeLocal getManejadorCita() {
        return manejadorCita;
    }

    public void setManejadorCita(CitaFacadeLocal manejadorCita) {
        this.manejadorCita = manejadorCita;
    }

    public FisioterapeutaFacadeLocal getManejadorFisioterapeuta() {
        return manejadorFisioterapeuta;
    }

    public void setManejadorFisioterapeuta(FisioterapeutaFacadeLocal manejadorFisioterapeuta) {
        this.manejadorFisioterapeuta = manejadorFisioterapeuta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public ClinicaFacadeLocal getManejadorClinica() {
        return manejadorClinica;
    }

    public void setManejadorClinica(ClinicaFacadeLocal manejadorClinica) {
        this.manejadorClinica = manejadorClinica;
    }
}
