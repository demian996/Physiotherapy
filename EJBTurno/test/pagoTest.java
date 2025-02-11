import static org.junit.Assert.*;
import org.junit.Test;
import EntityBeans.Pago;

public class pagoTest {

    // Prueba para verificar que dos pagos con el mismo ID son iguales
    @Test
    public void testEqualsSameId() {
        Pago pago1 = new Pago(1, "Efectivo");
        Pago pago2 = new Pago(1, "Tarjeta");
        
        assertTrue("Dos pagos con el mismo ID deben ser iguales", pago1.equals(pago2));
    }

    // Prueba para verificar que dos pagos con IDs diferentes son diferentes
    @Test
    public void testNotEqualsDifferentId() {
        Pago pago1 = new Pago(1, "Efectivo");
        Pago pago2 = new Pago(2, "Efectivo");
        
        assertFalse("Dos pagos con IDs diferentes deben ser diferentes", pago1.equals(pago2));
    }
}