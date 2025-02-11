import EntityBeans.Cita;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class citaIntegrationTest {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @Before
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("EJBTurnoPU"); // Nombre de tu unidad de persistencia
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Test
    public void testCitaPersistence() {
        // Creamos una nueva cita
        Cita cita = new Cita(1);
        cita.setHorario("2024-05-19 10:00");
        cita.setEstado("Pendiente");

        // Iniciamos una transacción
        transaction.begin();

        // Persistimos la cita en la base de datos
        entityManager.persist(cita);

        // Commit de la transacción
        transaction.commit();

        // Buscamos la cita por su id en la base de datos
        Cita savedCita = entityManager.find(Cita.class, 1);

        // Verificamos que la cita se haya guardado correctamente
        assertNotNull(savedCita);
        assertEquals(Integer.valueOf(1), savedCita.getIdCita());
        assertEquals("2024-05-19 10:00", savedCita.getHorario());
        assertEquals("Pendiente", savedCita.getEstado());

        // Eliminamos la cita
        transaction.begin();
        entityManager.remove(savedCita);
        transaction.commit();
    }

    // Puedes agregar más pruebas de integración según la lógica de tu aplicación
}
