/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Cita;
import EntityBeans.Clinica;
import EntityBeans.Paciente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pc3
 */
@Stateless
public class CitaFacade extends AbstractFacade<Cita> implements CitaFacadeLocal {
    @PersistenceContext(unitName = "EJBTurnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitaFacade() {
        super(Cita.class);
    }
    
    @Override
    // metodo para encontrar las citas de un alcinica especifica
    public List<Cita> encontrarCitaPorClinica(Clinica idClinica) {
        List<Cita> listaCita = null;
        try {
            Query sql = em.createNamedQuery("Cita.encontrarPorClinica").setParameter("idclinicaveterinaria", idClinica).setParameter("estado", "Atendida");
            listaCita = sql.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return listaCita;

    }

    @Override
    //encontrar citas por la clinica y su estado
    public List<Cita> encontrarCitaPorClinicaEstado(Clinica idClinica, String estado, String tipoCita) {
        List<Cita> listaCita = null;
        try {
            Query sql = em.createNamedQuery("Cita.encontrarPorClinicaEstado").setParameter("idclinicaveterinaria", idClinica).setParameter("estado", estado).setParameter("tipocita", tipoCita);
            listaCita = sql.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return listaCita;

    }

    @Override
    // encontrar una cita por el cliente y su estado
    public boolean encontrarCitaPorCliente(Paciente idCliente, String estado, String tipoCita) {
        List<Cita> listaCita = null;
        boolean existe = true;
        try {
            Query sql = em.createNamedQuery("Cita.findByClienteEstado").setParameter("idcliente", idCliente).setParameter("estado", estado).setParameter("tipocita", tipoCita);
            listaCita = sql.getResultList();
            if (!listaCita.isEmpty()) {
                existe = false;
            }
        } catch (Exception e) {
            throw e;
        }
        return existe;

    }
    
    @Override
    public Cita encontrarCitaPorCliente1(Paciente idCliente, String estado, String tipoCita) {
        List<Cita> listaCita = null;
        Cita citaEncontrada=null;
        try {
            Query sql = em.createNamedQuery("Cita.findByClienteEstado").setParameter("idcliente", idCliente).setParameter("estado", estado).setParameter("tipocita", tipoCita);
            listaCita = sql.getResultList();
            if (!listaCita.isEmpty()) {
                citaEncontrada=listaCita.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return citaEncontrada;

    }
    
    @Override
    public List<Cita> encontrarCitaPorCliente2(Paciente idCliente) {
        List<Cita> listaCita = null;
        try {
            Query sql = em.createNamedQuery("Cita.encontrarporCliente").setParameter("idcliente", idCliente);
            listaCita = sql.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return listaCita;

    }
}
