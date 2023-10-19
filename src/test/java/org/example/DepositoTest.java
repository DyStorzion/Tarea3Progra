package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DepositoTest {
    Deposito<Moneda> depositoMonedas;
    Deposito<CocaCola> depositoCocaCola;
    Deposito<Sprite> depositoSprite;
    Deposito<Fanta> depositoFanta;
    Deposito<Super8> depositoSuper8;
    Deposito<Snickers> depositoSnickers;

    @BeforeEach
    void setUp() {
        depositoMonedas = new Deposito<Moneda>();
        depositoCocaCola = new Deposito<CocaCola>();
        depositoSprite = new Deposito<Sprite>();
        depositoFanta = new Deposito<Fanta>();
        depositoSuper8 = new Deposito<Super8>();
        depositoSnickers = new Deposito<Snickers>();
    }

    @Test
    @DisplayName("Caso en que no se pueda sacar más bebidas")
    void getElementoPeroDepositoVacio(){
        assertNull(depositoFanta.getElemento());
    }

    @Test
    @DisplayName("Se añade elementos en el deposito como una estructura FIFO")
    void verifcarComportamientoFIFO(){
        Moneda100 moneda1 = new Moneda100();
        Moneda1000 moneda2 = new Moneda1000();
        Moneda100 moneda3 = new Moneda100();

        depositoMonedas.addElemento(moneda1);
        depositoMonedas.addElemento(moneda2);
        depositoMonedas.addElemento(moneda3);

        ArrayList<Moneda> orden_monedas = new ArrayList<Moneda>();
        orden_monedas.add(depositoMonedas.getElemento());
        orden_monedas.add(depositoMonedas.getElemento());
        orden_monedas.add(depositoMonedas.getElemento());

        assertSame(moneda1, orden_monedas.get(0));
        assertSame(moneda2, orden_monedas.get(1));
        assertSame(moneda3, orden_monedas.get(2));
    }
}