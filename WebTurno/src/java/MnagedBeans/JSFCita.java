package MnagedBeans;

import EntityBeans.Cita;
import EntityBeans.Clinica;
import EntityBeans.Fisioterapeuta;
import EntityBeans.Paciente;
import EntityBeans.Pago;
import EntityBeans.Servicio;
import SessionBeans.CitaFacadeLocal;
import SessionBeans.ClinicaFacadeLocal;
import SessionBeans.FisioterapeutaFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import SessionBeans.PacienteFacadeLocal;
import SessionBeans.PagoFacadeLocal;
import SessionBeans.ServicioFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean(name = "jSFCita")
@SessionScoped
public class JSFCita implements Serializable {

    @EJB
    private PacienteFacadeLocal manejadorPaciente;
    @EJB
    private FisioterapeutaFacadeLocal manejadorFisioterapeuta;
    @EJB
    private ClinicaFacadeLocal manejadorClinica;
    @EJB
    private ServicioFacadeLocal manejadorServicio;
    @EJB
    private CitaFacadeLocal manejadorCita;
    @EJB
    private PagoFacadeLocal manejadorPago;

    private Clinica clinica;
    private Paciente paciente;
    private Servicio servicio;
    private Cita cita;
    private Pago pago;
    private List<Clinica> listaClinica;
    private List<Fisioterapeuta> listaFisioterapeuta;
    private List<Servicio> listaServicio;
    private List<Pago> listaPago;
    private String idFisioterapeuta;
    private Integer idServicio;
    private Integer idPago;
    private Date horaReservacion;

    public JSFCita() {
    }

    @PostConstruct
    public void inicio() {
        paciente= new Paciente();
        clinica= new Clinica();
        servicio= new Servicio();
        cita =new Cita();
        pago= new Pago();
        reporteClinica();
        reporteServicio();
        reporteFisioterapeutas();
        reportePagos();
    }
    
    

    public void crearCita(String estado) {
        try {
            Random random = new Random();
            verificarSesionPaciente();
            this.getCita().setIdServicio(getManejadorServicio().find(getIdServicio()));
            this.getCita().setIdPacientes(getManejadorPaciente().find(getPaciente().getNumCedula()));
            this.getCita().setIdPago(getManejadorPago().find(getIdPago()));
            this.getCita().setIdFisioterapeuta(getManejadorFisioterapeuta().find(getIdFisioterapeuta()));
            this.getCita().setHorario(getHoraReservacion().toString());
            this.getCita().setEstado(estado);
            this.getCita().setIdCita(random.nextInt(101));
            getManejadorCita().create(this.getCita());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "", "Cita registrada"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Aviso", "Cita no registrada"));
        }
    }

    public void verificarSesionPaciente() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Paciente us = (Paciente) context.getExternalContext().getSessionMap().get("paciente");
            setPaciente(us);
            if (us == null) {
                context.getExternalContext().redirect("inicioPaciente.xhtml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearCitaVirtual() {
        crearCita("Virtual");
    }

    public void crearCitaPresencial() {
        crearCita("Presencial");
    }

    public void crearCitaEmergencia() {
        crearCita("Emergencia");
    }

    public void reporteClinica() {
        setListaClinica(getManejadorClinica().findAll());
    }

    public void reporteServicio() {
        setListaServicio(getManejadorServicio().findAll());
    }

    public void reporteFisioterapeutas() {
        setListaFisioterapeuta(getManejadorFisioterapeuta().findAll());
    }

    public void reportePagos() {
        setListaPago(getManejadorPago().findAll());
    }

    public PacienteFacadeLocal getManejadorPaciente() {
        return manejadorPaciente;
    }

    public void setManejadorPaciente(PacienteFacadeLocal manejadorPaciente) {
        this.manejadorPaciente = manejadorPaciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public FisioterapeutaFacadeLocal getManejadorFisioterapeuta() {
        return manejadorFisioterapeuta;
    }

    public void setManejadorFisioterapeuta(FisioterapeutaFacadeLocal manejadorFisioterapeuta) {
        this.manejadorFisioterapeuta = manejadorFisioterapeuta;
    }

    public ClinicaFacadeLocal getManejadorClinica() {
        return manejadorClinica;
    }

    public void setManejadorClinica(ClinicaFacadeLocal manejadorClinica) {
        this.manejadorClinica = manejadorClinica;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public List<Clinica> getListaClinica() {
        return listaClinica;
    }

    public void setListaClinica(List<Clinica> listaClinica) {
        this.listaClinica = listaClinica;
    }

    public List<Fisioterapeuta> getListaFisioterapeuta() {
        return listaFisioterapeuta;
    }

    public void setListaFisioterapeuta(List<Fisioterapeuta> listaFisioterapeuta) {
        this.listaFisioterapeuta = listaFisioterapeuta;
    }

    public ServicioFacadeLocal getManejadorServicio() {
        return manejadorServicio;
    }

    public void setManejadorServicio(ServicioFacadeLocal manejadorServicio) {
        this.manejadorServicio = manejadorServicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public List<Servicio> getListaServicio() {
        return listaServicio;
    }

    public void setListaServicio(List<Servicio> listaServicio) {
        this.listaServicio = listaServicio;
    }

    public CitaFacadeLocal getManejadorCita() {
        return manejadorCita;
    }

    public void setManejadorCita(CitaFacadeLocal manejadorCita) {
        this.manejadorCita = manejadorCita;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public String getIdFisioterapeuta() {
        return idFisioterapeuta;
    }

    public void setIdFisioterapeuta(String idFisioterapeuta) {
        this.idFisioterapeuta = idFisioterapeuta;
    }

    public PagoFacadeLocal getManejadorPago() {
        return manejadorPago;
    }

    public void setManejadorPago(PagoFacadeLocal manejadorPago) {
        this.manejadorPago = manejadorPago;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public List<Pago> getListaPago() {
        return listaPago;
    }

    public void setListaPago(List<Pago> listaPago) {
        this.listaPago = listaPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Date getHoraReservacion() {
        return horaReservacion;
    }

    public void setHoraReservacion(Date horaReservacion) {
        this.horaReservacion = horaReservacion;
    }
}
