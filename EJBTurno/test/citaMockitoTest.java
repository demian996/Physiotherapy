import EntityBeans.Cita;
import EntityBeans.Fisioterapeuta;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class citaMockitoTest {

    private Cita cita;

    @Before
    public void setUp() {
        cita = new Cita(1); // Creamos una cita de ejemplo
        cita.setHorario("2024-05-19 10:00");
        cita.setEstado("Pendiente");
        // Aquí puedes inicializar otros campos si es necesario para tus pruebas
    }

    @Test
    public void testGetIdCita() {
        assertEquals(Integer.valueOf(1), cita.getIdCita());
    }

    @Test
    public void testGetHorario() {
        assertEquals("2024-05-19 10:00", cita.getHorario());
    }

    @Test
    public void testGetEstado() {
        assertEquals("Pendiente", cita.getEstado());
    }

    @Test
    public void testSetIdCita() {
        cita.setIdCita(2);
        assertEquals(Integer.valueOf(2), cita.getIdCita());
    }

    // Puedes continuar con más pruebas para los otros métodos de la clase

    @Test
    public void testToString() {
        assertEquals("1", cita.toString());
    }

    // También podemos simular objetos utilizando Mockito para probar la interacción entre objetos

    @Test
    public void testIdFisioterapeuta() {
        // Creamos un objeto Fisioterapeuta simulado
        Fisioterapeuta fisioterapeutaMock = mock(Fisioterapeuta.class);
        // Establecemos este objeto simulado como el fisioterapeuta de la cita
        cita.setIdFisioterapeuta(fisioterapeutaMock);
        // Verificamos que se haya establecido correctamente
        assertEquals(fisioterapeutaMock, cita.getIdFisioterapeuta());
    }

    // Puedes seguir añadiendo más pruebas según tus necesidades
}
