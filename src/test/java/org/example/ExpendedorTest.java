package org.example;

import org.example.modelos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para testear expendedor.
 * @author Benjamin Espinoza
 */
class ExpendedorTest {
    private Expendedor expendedor;
    private Producto producto;
    private Moneda moneda;

    /**
     * Creacion de expendedor para los test.
     */
    @BeforeEach
    void getUp(){
        expendedor = new Expendedor(1);
    }

    /**
     * Verifica que compre Cocacola.
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void deberiaRetornarCocaCola()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        expendedor.comprarProducto(moneda, InfoProducto.COCA);
        producto = expendedor.getProducto();
        assertInstanceOf(CocaCola.class, producto);
    }

    /**
     * Verifica que compre sprite.
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void deberiaRetornarSprite()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        expendedor.comprarProducto(moneda, InfoProducto.SPRITE);
        producto = expendedor.getProducto();
        assertInstanceOf(Sprite.class, producto);
    }

    /**
     * Verifica que compre fanta.
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void deberiaRetornarFanta()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        expendedor.comprarProducto(moneda, InfoProducto.FANTA);
        producto = expendedor.getProducto();
        assertInstanceOf(Fanta.class, producto);
    }

    /**
     * Verifica que compre snickers.
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void deberiaRetornarSnickers()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        expendedor.comprarProducto(moneda, InfoProducto.SNICKERS);
        producto = expendedor.getProducto();
        assertInstanceOf(Snickers.class, producto);
    }

    /**
     * Verifica que compre super 8.
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void deberiaRetornarSuper8()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        expendedor.comprarProducto(moneda, InfoProducto.SUPER8);
        producto = expendedor.getProducto();
        assertInstanceOf(Super8.class, producto);
    }

    /**
     * Se verifica que se lance la excepcion NoHayProductoException
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void expendedorThrowNoHayProductoException()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda = new Moneda1000();
        expendedor.comprarProducto(moneda,InfoProducto.COCA);
        producto = expendedor.getProducto();;
        moneda = new Moneda1000();
        assertThrows(NoHayProductoException.class, () ->{
            expendedor.comprarProducto(moneda,InfoProducto.COCA);
            producto = expendedor.getProducto();
        });
    }

    /**
     * Se verifica que se lance la excepcion PagoInsuficienteException
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void expendedorThrowPagoInsuficienteException()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException{
        moneda = new Moneda500();
        assertThrows(PagoInsuficienteException.class, () ->{
            expendedor.comprarProducto(moneda,InfoProducto.COCA);
            producto = expendedor.getProducto();
        });
    }

    /**
     * Se verifica que se lance la excepcion PagoIncorrectoException
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    @Test
    void expendedorThrowPagoIncorrectoException()
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException{
        moneda = null;
        assertThrows(PagoIncorrectoException.class, () ->{
            expendedor.comprarProducto(moneda,InfoProducto.COCA);
            producto = expendedor.getProducto();
        });
    }
}