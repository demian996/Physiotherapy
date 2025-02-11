/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Clinica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pc3
 */
@Local
public interface ClinicaFacadeLocal {

    void create(Clinica clinica);

    void edit(Clinica clinica);

    void remove(Clinica clinica);

    Clinica find(Object id);

    List<Clinica> findAll();

    List<Clinica> findRange(int[] range);

    int count();
    
     public Clinica validarClinicaVeterinaria(String email, String password);

    public Clinica buscarClinicaVeterinaria(int idClinica);
    
}
