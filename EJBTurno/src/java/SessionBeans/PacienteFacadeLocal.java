/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Paciente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pc3
 */
@Local
public interface PacienteFacadeLocal {

    void create(Paciente paciente);

    void edit(Paciente paciente);

    void remove(Paciente paciente);

    Paciente find(Object id);

    List<Paciente> findAll();

    List<Paciente> findRange(int[] range);

    int count();
    
    public Paciente validarPaciente(String email, String password);

    public Paciente existePaciente(String email);

    
}
