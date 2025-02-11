import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import SessionBeans.PacienteFacadeLocal;
import EntityBeans.Paciente;
import SessionBeans.PacienteFacade;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class createPaienteTest {

    private EntityManager em; // Cambio de visibilidad a private

    private PacienteFacadeLocal pacienteFacade;

    private List<Paciente> pacientes; // Lista para almacenar pacientes simulados

    @Before
    public void setUp() {
        // Inicializar la lista de pacientes
        pacientes = new ArrayList<>();

        // Mock del EntityManager
        em = mock(EntityManager.class);

        // Implementar la lógica del método create utilizando la lista simulada y el mock del EntityManager
        pacienteFacade = new PacienteFacade() { // Utiliza la implementación concreta del PacienteFacade
            @Override
            protected EntityManager getEntityManager() {
                return em; // Devuelve el mock del EntityManager
            }
        };
    }

    @Test
    public void testCreate() {
        // Crear un nuevo paciente
        Paciente newPaciente = new Paciente();
        newPaciente.setNumCedula("1111111111");
        newPaciente.setCorreoe("nuevo@example.com");
        newPaciente.setClave("1234");
        newPaciente.setFechaNacimiento("07.07.2024");

        // Llamar al método create
        pacienteFacade.create(newPaciente);

        // Verificar que el paciente fue agregado correctamente a la lista simulada
        assertTrue("El paciente debe ser agregado a la lista", pacientes.contains(newPaciente));
        assertEquals("El número de pacientes debe ser 1", 1, pacientes.size());

        // Verificar que el método persist del EntityManager fue llamado con el paciente correcto
        verify(em, times(1)).persist(newPaciente);
    }
}
