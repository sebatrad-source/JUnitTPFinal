import org.example.ConversorTemperatura;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConversorTemperaturaTest {
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
    public void converitirPositivoCelsius(){
        ConversorTemperatura convert = new ConversorTemperatura();
        assertEquals(122.0, convert.ConversorFahrenheit(50),0.0001);
    }
    @Test
    @Order(2)
    public void convertirNegativoCelsius(){
        ConversorTemperatura convert = new ConversorTemperatura();
        assertEquals(14.0, convert.ConversorFahrenheit(-10),0.0001);
    }
    @Test
    @Order(3)
    public void convertirCero(){
        ConversorTemperatura convert = new ConversorTemperatura();
        assertEquals(32.0, convert.ConversorFahrenheit(0.0),0.001);
    }
    @Test
    @Order(4)
    public void convertirMil(){
        ConversorTemperatura convert = new ConversorTemperatura();
        assertEquals(932.0, convert.ConversorFahrenheit(1000.0), 0.0001);
    }
}
