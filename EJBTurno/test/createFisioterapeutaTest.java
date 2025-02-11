import EntityBeans.Fisioterapeuta;
import SessionBeans.FisioterapeutaFacade;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import SessionBeans.FisioterapeutaFacadeLocal;
import SessionBeans.PacienteFacade;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class createFisioterapeutaTest {

    private EntityManager em; // Cambio de visibilidad a private

    private FisioterapeutaFacadeLocal fisioFacade;

    private List<Fisioterapeuta> pacientes; // Lista para almacenar pacientes simulados

    @Before
    public void setUp() {
        // Inicializar la lista de pacientes
        pacientes = new ArrayList<>();

        // Mock del EntityManager
        em = mock(EntityManager.class);

        // Implementar la lógica del método create utilizando la lista simulada y el mock del EntityManager
        fisioFacade = new FisioterapeutaFacade() { // Utiliza la implementación concreta del PacienteFacade
            @Override
            protected EntityManager getEntityManager() {
                return em; // Devuelve el mock del EntityManager
            }
        };
    }

    @Test
    public void testCreate() {
        // Crear un nuevo paciente
        Fisioterapeuta newFisio = new Fisioterapeuta();
        newFisio.setNumCedula("1111111111");
        newFisio.setCorreoe("nuevo@example.com");
        newFisio.setClave("1234");
        newFisio.setFechaNacimiento("07.07.2024");

        // Llamar al método create
        fisioFacade.create(newFisio);

        // Verificar que el paciente fue agregado correctamente a la lista simulada
        assertTrue("El paciente debe ser agregado a la lista", pacientes.contains(newFisio));
        assertEquals("El número de pacientes debe ser 1", 1, pacientes.size());

        // Verificar que el método persist del EntityManager fue llamado con el paciente correcto
        verify(em, times(1)).persist(newFisio);
    }
}
