/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Pago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc3
 */
@Stateless
public class PagoFacade extends AbstractFacade<Pago> implements PagoFacadeLocal {
    @PersistenceContext(unitName = "EJBTurnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagoFacade() {
        super(Pago.class);
    }
    
}
