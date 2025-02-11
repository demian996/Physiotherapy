package MnagedBeans;

import EntityBeans.Fisioterapeuta;
import EntityBeans.Paciente;
import SessionBeans.FisioterapeutaFacadeLocal;
import SessionBeans.PacienteFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "JSFSession")
@SessionScoped
public class JSFSession implements Serializable {
    
    @EJB
    private PacienteFacadeLocal manejadorPaciente;
    @EJB
    private FisioterapeutaFacadeLocal manejadorFisioterapeuta;
    
    private String usuario;
    private String clave;
    private String idPaciente;
    private Paciente pa;
    private Fisioterapeuta fis;
    
    
    @PostConstruct
    public void inicio() {
        pa= new Paciente();
        fis= new Fisioterapeuta();
    }

    public String iniciarSesion() {
        String redireccion = null;
        try {
            setPa(getManejadorPaciente().validarPaciente(this.getUsuario(), this.getClave()));
            if (getPa() != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("paciente", getPa());
                redireccion = "/pacientePag.xhtml";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error Base de Datos"));
        }
        return redireccion;
    }
    
    public String iniciarSesionF() {
        String redireccion = null;
        try {
            setFis(getManejadorFisioterapeuta().validarFisioterapeuta(this.getUsuario(), this.getClave()));
            if (getFis()!= null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("fisioterapeuta", getFis());
                redireccion = "/fisioterapeutaPag.xhtml";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error Base de Datos"));
        }
        return redireccion;
    }
    
    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "inicioGeneral.xhtml";
    }
    
    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }

    public PacienteFacadeLocal getManejadorPaciente() {
        return manejadorPaciente;
    }

    public void setManejadorPaciente(PacienteFacadeLocal manejadorPaciente) {
        this.manejadorPaciente = manejadorPaciente;
    }

    public FisioterapeutaFacadeLocal getManejadorFisioterapeuta() {
        return manejadorFisioterapeuta;
    }

    public void setManejadorFisioterapeuta(FisioterapeutaFacadeLocal manejadorFisioterapeuta) {
        this.manejadorFisioterapeuta = manejadorFisioterapeuta;
    }

    public Paciente getPa() {
        return pa;
    }

    public void setPa(Paciente pa) {
        this.pa = pa;
    }

    public Fisioterapeuta getFis() {
        return fis;
    }

    public void setFis(Fisioterapeuta fis) {
        this.fis = fis;
    }
}
