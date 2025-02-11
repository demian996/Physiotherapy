/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Cita;
import EntityBeans.Clinica;
import EntityBeans.Paciente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pc3
 */
@Local
public interface CitaFacadeLocal {

    void create(Cita cita);

    void edit(Cita cita);

    void remove(Cita cita);

    Cita find(Object id);

    List<Cita> findAll();

    List<Cita> findRange(int[] range);

    int count();
    
    public List<Cita> encontrarCitaPorClinica(Clinica idClinica);

    public List<Cita> encontrarCitaPorClinicaEstado(Clinica idClinica, String estado, String tipoCita);

    public boolean encontrarCitaPorCliente(Paciente idPaciente, String estado, String tipoCita);

    public Cita encontrarCitaPorCliente1(Paciente idPaciente, String estado, String tipoCita);

    public List<Cita> encontrarCitaPorCliente2(Paciente idPaciente);
    
}
