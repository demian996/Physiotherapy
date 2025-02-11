/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Clinica;
import EntityBeans.Fisioterapeuta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pc3
 */
@Local
public interface FisioterapeutaFacadeLocal {

    void create(Fisioterapeuta fisioterapeuta);

    void edit(Fisioterapeuta fisioterapeuta);

    void remove(Fisioterapeuta fisioterapeuta);

    Fisioterapeuta find(Object id);

    List<Fisioterapeuta> findAll();

    List<Fisioterapeuta> findRange(int[] range);

    int count();
    
    public Fisioterapeuta validarFisioterapeuta(String email, String password);

    public List<Fisioterapeuta> encontrarFisioterapeutaPorClinica(Clinica idClinica, String estado);
    
}
