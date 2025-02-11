package SessionBeans;

import EntityBeans.Clinica;
import EntityBeans.Fisioterapeuta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class FisioterapeutaFacade extends AbstractFacade<Fisioterapeuta> implements FisioterapeutaFacadeLocal {
    @PersistenceContext(unitName = "EJBTurnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FisioterapeutaFacade() {
        super(Fisioterapeuta.class);
    }
    
    @Override
    public Fisioterapeuta validarFisioterapeuta(String email, String password) {
        Fisioterapeuta fisioterapeuta = null;
        try {
            Query sql = em.createNamedQuery("Fisioterapeuta.findByUsuario")
                    .setParameter("correoe", email)
                    .setParameter("clave", password);
            List<Fisioterapeuta> listaFisioterapeuta = sql.getResultList();
            if(!listaFisioterapeuta.isEmpty()){
                fisioterapeuta=listaFisioterapeuta.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return fisioterapeuta;

    }
    
    // encontrar un fisioterapeuta de uba clinica especifica
    @Override
    public List<Fisioterapeuta> encontrarFisioterapeutaPorClinica(Clinica idClinica, String estado) {
        List<Fisioterapeuta> listaFisioterapeuta=null;
        try {
            Query sql = em.createNamedQuery("Fisioterapeuta.encontrarPorClinicaEstado").setParameter("idclinica", idClinica).setParameter("estado", estado);
            listaFisioterapeuta = sql.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return listaFisioterapeuta;

    }
    
}
