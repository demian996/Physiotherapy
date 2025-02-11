/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Servicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pc3
 */
@Local
public interface ServicioFacadeLocal {

    void create(Servicio servicio);

    void edit(Servicio servicio);

    void remove(Servicio servicio);

    Servicio find(Object id);

    List<Servicio> findAll();

    List<Servicio> findRange(int[] range);

    int count();
    
}
