package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {

    Moneda moneda;
    Expendedor expendedor;
    Comprador comprador;

    @BeforeEach
    void setUp()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        expendedor = new Expendedor(1);
    }
    @Test
    void CompradorVueltoShouldBeZero()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        assertEquals(0, comprador.cuantoVuelto());
    }

    @Test
    void CompradorsonidoShouldBecocacola()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        assertEquals("cocacola", comprador.queConsumiste());
    }
    @Test
    void CompradorShouldThrowPagoIncorrectoException()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = null;
        assertThrows(PagoIncorrectoException.class, () ->{
            comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        });
    }
    @Test
    void CompradorShouldThrowNoHayProductoException()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Comprador aux = new Comprador(moneda, InfoProducto.COCA, expendedor);
        moneda = new Moneda1000();
        assertThrows(NoHayProductoException.class, () ->{
            comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        });
    }
    @Test
    void Comprador1ShouldThrowPagoInsuficienteEsception(){
        moneda = new Moneda500();
        assertThrows(PagoInsuficienteException.class, () ->{
            comprador = new Comprador(moneda,InfoProducto.COCA,expendedor);
        });
    }
}