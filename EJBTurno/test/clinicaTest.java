import static org.junit.Assert.*;
import org.junit.Test;
import EntityBeans.Clinica;

public class clinicaTest {

    // Prueba para verificar que se establezca y obtenga correctamente el teléfono
    @Test
    public void testTelefono() {
        Clinica clinica = new Clinica();
        String telefono = "123456789";
        
        clinica.setTelefono(telefono);
        
        assertEquals("El teléfono debe ser igual", telefono, clinica.getTelefono());
    }
}