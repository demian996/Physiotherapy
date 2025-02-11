import EntityBeans.Clinica;
import EntityBeans.Fisioterapeuta;
import SessionBeans.ClinicaFacade;
import SessionBeans.ClinicaFacadeLocal;
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

public class createClinicaTest {

    private EntityManager em; // Cambio de visibilidad a private

    private ClinicaFacadeLocal clinicaFacade;

    private List<Clinica> clinica; // Lista para almacenar clinica simulados

    @Before
    public void setUp() {
        // Inicializar la lista de clinica
        clinica = new ArrayList<>();

        // Mock del EntityManager
        em = mock(EntityManager.class);

        // Implementar la lógica del método create utilizando la lista simulada y el mock del EntityManager
        clinicaFacade = new ClinicaFacade() { // Utiliza la implementación concreta del PacienteFacade
            @Override
            protected EntityManager getEntityManager() {
                return em; // Devuelve el mock del EntityManager
            }
        };
    }

    @Test
    public void testCreate() {
        // Crear un nuevo paciente
        Clinica newCli = new Clinica();
        newCli.setNombre("1");
        newCli.setCorreoe("nuevo@example.com");
        newCli.setClave("1234");
        newCli.setTelefono("07222222");

        // Llamar al método create
        clinicaFacade.create(newCli);

        // Verificar que el paciente fue agregado correctamente a la lista simulada
        assertTrue("LA clinica debe ser agregado a la lista", clinica.contains(newCli));
        assertEquals("El número de clinica debe ser 1", 1, clinica.size());

        // Verificar que el método persist del EntityManager fue llamado con el paciente correcto
        verify(em, times(1)).persist(newCli);
    }
}
