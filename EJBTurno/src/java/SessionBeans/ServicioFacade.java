/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Servicio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc3
 */
@Stateless
public class ServicioFacade extends AbstractFacade<Servicio> implements ServicioFacadeLocal {
    @PersistenceContext(unitName = "EJBTurnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioFacade() {
        super(Servicio.class);
    }
    
}
