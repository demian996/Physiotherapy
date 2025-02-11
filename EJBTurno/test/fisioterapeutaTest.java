import static org.junit.Assert.*;
import org.junit.Test;
import EntityBeans.Fisioterapeuta;

public class fisioterapeutaTest {

    // Prueba para verificar que se establezcan y obtengan correctamente los nombres y apellidos
    @Test
    public void testNombresApellidos() {
        Fisioterapeuta fisioterapeuta = new Fisioterapeuta();
        String nombres = "Juan";
        String apellidos = "Pérez";
        
        fisioterapeuta.setNombres(nombres);
        fisioterapeuta.setApellidos(apellidos);
        
        assertEquals("Los nombres deben ser iguales", nombres, fisioterapeuta.getNombres());
        assertEquals("Los apellidos deben ser iguales", apellidos, fisioterapeuta.getApellidos());
    }
}