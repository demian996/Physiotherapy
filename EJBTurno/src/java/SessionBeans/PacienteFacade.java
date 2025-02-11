package SessionBeans;

import EntityBeans.Paciente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> implements PacienteFacadeLocal {
    @PersistenceContext(unitName = "EJBTurnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacienteFacade() {
        super(Paciente.class);
    }
    
    @Override
    public Paciente validarPaciente(String email, String password) {
        Paciente paci = null;
        try {
            Query sql = em.createNamedQuery("Paciente.findByUsuario")
                          .setParameter("correoe", email)
                          .setParameter("clave", password);
            List<Paciente> listaPacientes = sql.getResultList();

            if (!listaPacientes.isEmpty()) {
                paci = listaPacientes.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Mejor manejo de excepciones
            throw new RuntimeException("Error al validar paciente", e);
        }
        return paci;
    }

    
    @Override
    public Paciente existePaciente(String email) {
        Paciente paci = null;
        try {
            Query sql = em.createNamedQuery("Paciente.findByCorreoe")
                          .setParameter("correoe", email);
            List<Paciente> listaPaciente = sql.getResultList();
            if (!listaPaciente.isEmpty()) {
                paci = listaPaciente.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Mejor manejo de excepciones
            throw new RuntimeException("Error al verificar existencia de paciente", e);
        }
        return paci;
    }

}
