import org.example.CuentaBancaria;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CuentaBancariaTest {
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
    public void aumentarSaldo(){
        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.depositar(500.0);
        assertEquals(500.0, cuenta.getSaldo(),0.0001);
    }
    @Test
    @Order(2)
    public void reducirSaldo(){
        CuentaBancaria cuenta = new CuentaBancaria(400.0);
        cuenta.retirar(100.0);
        assertEquals(300.0, cuenta.getSaldo(),0.0001);
    }
    @Test
    @Order(3)
    public void saldoInsuficiente(){
        CuentaBancaria cuenta = new CuentaBancaria(300.0);
        IllegalStateException exc = assertThrows(IllegalStateException.class,()->cuenta.retirar(400.0));
        assertEquals("Fondos Insuficientes", exc.getMessage());
    }
    @Test
    @Order(4)
    public void vaciarCuenta(){
        CuentaBancaria cuenta = new CuentaBancaria(500.0);
        cuenta.retirar(400.0);
        assertEquals(500.0, cuenta.getSaldo(),0.0001);
        System.out.println("Cuenta vaciada");
    }
    @Test
    @Order(5)
    public void depositoVacio(){
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        IllegalStateException exc = assertThrows(IllegalStateException.class, ()->cuenta.depositar(0.0));
        assertEquals("El deposito debe ser mayor a cero", exc.getMessage());
    }
}
