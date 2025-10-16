import org.example.Excepcion;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExcepcionTest {
    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        System.out.println("Empieza " + testInfo.getDisplayName());
    }
    @AfterEach
    public void afterEach(TestInfo testInfo){
        System.out.println("Termina " + testInfo.getDisplayName());
    }
    @Test
    @Order(1)
    public void TextoNulo(){
        Excepcion ext = new Excepcion();
        NullPointerException ex = assertThrows(NullPointerException.class,()-> ext.validarTexto(null));
        assertEquals("El texto no puede ser nulo", ex.getMessage());
    }
    @Test
    @Order(2)
    public void TextoValido(){
        Excepcion ext = new Excepcion();
        assertEquals(4,ext.validarTexto("Chau"));
    }
}
