package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para testear la clase Comprador
 * @author Benjamin Espinoza
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
     * Verifica que se lanza la excepcion PagoIncorrectoException
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void compradorThrowPagoIncorrectoException()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = null;
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