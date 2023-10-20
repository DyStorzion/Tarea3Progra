package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para testear la clase Comprador
 * @author Benjamin Espinoza, Carlos Alvarez
 */
class CompradorTest {

    Moneda moneda;
    Expendedor expendedor;
    Comprador comprador;

    /**
     * Se inicializan los objetos para testear la clase.
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @BeforeEach
    void setUp()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        expendedor = new Expendedor(1);
    }

    /**
     * Test para verificar que si se paga exactamente te duelve un vuelto de 0
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void compradorVueltoRetornaCero()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        assertEquals(0, comprador.cuantoVuelto());
    }

    @Test
    void compradorVueltoRetorna600()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(moneda, InfoProducto.SNICKERS, expendedor);
        assertEquals(600, comprador.cuantoVuelto());
    }

    /**
     *Verifica que que consumiste con CocaCola retorna cocacola
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void compradorsonidoRetornaCocacola()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        assertEquals("cocacola", comprador.queConsumiste());
    }

    /**
     * Verifica que se lanza la excepcion PagoIncorrectoException ante moneda igual a null
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void compradorThrowPagoIncorrectoExceptionConMonedaNull()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = null;
        assertThrows(PagoIncorrectoException.class, () ->{
            comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        });
    }

    /**
     * Verifica que se lanza la excepcion PagoIncorrectoException ante moneda igual a 1500
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void compradorThrowPagoIncorrectoExceptionConMoneda1500()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1500();
        assertThrows(PagoIncorrectoException.class, () ->{
            comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        });
    }

    /**
     * Verifica que se lanza la excepcion NoHayProductoException
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void compradorThrowNoHayProductoException()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Comprador aux = new Comprador(moneda, InfoProducto.COCA, expendedor);
        moneda = new Moneda1000();
        assertThrows(NoHayProductoException.class, () ->{
            comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        });
    }

    /**
     * Verifica que se lanza la excepcion NoHayProductoException
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void compradorThrowPagoInsuficienteException(){
        moneda = new Moneda500();
        assertThrows(PagoInsuficienteException.class, () ->{
            comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        });
    }
}