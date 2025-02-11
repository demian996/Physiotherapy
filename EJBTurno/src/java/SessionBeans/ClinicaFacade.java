/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Clinica;
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
public class ClinicaFacade extends AbstractFacade<Clinica> implements ClinicaFacadeLocal {
    @PersistenceContext(unitName = "EJBTurnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClinicaFacade() {
        super(Clinica.class);
    }
    
    @Override
        public Clinica validarClinicaVeterinaria(String email, String password) {
        Clinica clinica = null;
        try {
            Query sql = em.createNamedQuery("Clinicaveterinaria.validarUsuario").setParameter("email", email).setParameter("password", password);
            List<Clinica> listaClinicas = sql.getResultList();
            if(!listaClinicas.isEmpty()){
                clinica=listaClinicas.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return clinica;

    }
    
    //buscar clinica
    @Override
    public Clinica buscarClinicaVeterinaria(int idClinica) {
        Clinica clinica = null;
        try {
            Query sql = em.createNamedQuery("Clinicaveterinaria.findByIdclinicaveterinaria").setParameter("idclinicaveterinaria", idClinica);
            List<Clinica> listaClinica = sql.getResultList();
            if(!listaClinica.isEmpty()){
                clinica=listaClinica.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return clinica;

    }
    
}
