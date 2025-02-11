import EntityBeans.Fisioterapeuta;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class fisioterapeutaMockitoTest {

    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testPersistence() {
        // Creamos un objeto Fisioterapeuta para persistir
        Fisioterapeuta fisioterapeuta = new Fisioterapeuta("123456789");
        fisioterapeuta.setNombres("Juan");
        fisioterapeuta.setApellidos("Perez");

        // Iniciamos una transacción
        em.getTransaction().begin();

        // Persistimos el objeto Fisioterapeuta en la base de datos
        em.persist(fisioterapeuta);

        // Commit de la transacción
        em.getTransaction().commit();

        // Buscamos el Fisioterapeuta por su número de cédula en la base de datos
        TypedQuery<Fisioterapeuta> query = em.createQuery("SELECT f FROM Fisioterapeuta f WHERE f.numCedula = :numCedula", Fisioterapeuta.class);
        query.setParameter("numCedula", "123456789");
        List<Fisioterapeuta> resultList = query.getResultList();

        // Verificamos que se haya guardado correctamente en la base de datos y se pueda recuperar
        assertEquals(1, resultList.size());
        assertEquals("Juan", resultList.get(0).getNombres());
        assertEquals("Perez", resultList.get(0).getApellidos());
    }
}
