import Ejemplo.Prueba;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Diego Pro
 */
public class pruebaTest {

    private Prueba prueba = new Prueba();
    
    public pruebaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        prueba.setRut("1152457991");
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void Nulo() {
        assertNotNull("Valor Nulo", prueba.getRut());
    }
    @Test
    public void ComparacionBoolean(){
        boolean retorno = prueba.ValidaRUT();
        assertEquals(true, retorno);
    }
    @Test
    public void otroMetodo(){
        assertTrue("es verdaderro", prueba.ValidaRUT());
      
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
