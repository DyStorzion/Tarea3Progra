package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {
    private Expendedor expendedor;
    private Producto producto;
    private Moneda moneda;
    @BeforeEach
    void getUp(){
        expendedor = new Expendedor(1);
    }
    @Test
    void shouldReturnCocaCola()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        producto = expendedor.comprarProducto(moneda, InfoProducto.COCA);
        assertInstanceOf(CocaCola.class, producto);
    }
    @Test
    void shouldReturnSprite()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        producto = expendedor.comprarProducto(moneda, InfoProducto.SPRITE);
        assertInstanceOf(Sprite.class, producto);
    }
    @Test
    void shouldReturnFanta()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        producto = expendedor.comprarProducto(moneda, InfoProducto.FANTA);
        assertInstanceOf(Fanta.class, producto);
    }
    @Test
    void shouldReturnSnickers()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        producto = expendedor.comprarProducto(moneda, InfoProducto.SNICKERS);
        assertInstanceOf(Snickers.class, producto);
    }
    @Test
    void shouldReturnSuper8()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        producto = expendedor.comprarProducto(moneda, InfoProducto.SUPER8);
        assertInstanceOf(Super8.class, producto);
    }
    @Test
    void expendedorShouldThrowNoHayProductoException()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        producto = expendedor.comprarProducto(moneda,InfoProducto.COCA);
        moneda = new Moneda1000();
        assertThrows(NoHayProductoException.class, () ->{
            producto = expendedor.comprarProducto(moneda,InfoProducto.COCA);
        });
    }
    @Test
    void expendedorShouldThrowPagoInsuficienteException()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException{
        moneda = new Moneda500();
        assertThrows(PagoInsuficienteException.class, () ->{
            producto = expendedor.comprarProducto(moneda,InfoProducto.COCA);
        });
    }
    @Test
    void expendedorShouldThrowPagoIncorrectoException()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException{
        moneda = null;
        assertThrows(PagoIncorrectoException.class, () ->{
            producto = expendedor.comprarProducto(moneda,InfoProducto.COCA);
        });
    }
}