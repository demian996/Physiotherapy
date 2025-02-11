import EntityBeans.Fisioterapeuta;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
import java.util.ArrayList;

public class fisioterapeutaTestUnit {
    
    private Fisioterapeuta fisioterapeuta;
    
    @Before
    public void setUp() {
        fisioterapeuta = new Fisioterapeuta("123456789"); // Crea un objeto de prueba
        fisioterapeuta.setNombres("Juan");
        fisioterapeuta.setApellidos("Perez");
        fisioterapeuta.setClave("password");
        fisioterapeuta.setTelefono("123456789");
        fisioterapeuta.setCorreoe("juan@example.com");
        fisioterapeuta.setFechaNacimiento("1990-01-01");
        // Aquí puedes inicializar otros campos si es necesario para tus pruebas
    }
    
    @After
    public void tearDown() {
        fisioterapeuta = null; // Limpia el objeto después de cada prueba
    }

    @Test
    public void testGetNumCedula() {
        assertEquals("123456789", fisioterapeuta.getNumCedula());
    }

    @Test
    public void testGetNombres() {
        assertEquals("Juan", fisioterapeuta.getNombres());
    }
    
    // Agrega más pruebas para los otros métodos de la clase
    // Puedes probar los métodos de acceso, equals, hashCode, etc.
}
