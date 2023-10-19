package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para testear la clase Moneda
 * @author Benjamin Espinoza
 */
class MonedaTest {
    private Moneda m1;
    private Moneda m2;
    private Moneda m3;
    private Moneda m4;
    private Moneda m5;

    /**
     * Se incializan los objetos para testear la clase
     */
    @BeforeEach
    void setUp(){
        m1 = new Moneda100();
        m2 = new Moneda500();
        m3 = new Moneda1000();
        m4 = new Moneda1500();
        m5 = new Moneda100();
    }

    /**
     * Se verifica que el valor de m1 es menor que el de m2 mediante el metodo compareTo
     */

    @Test
    void m1CompareTom2ShouldGiveMinusOne(){
        assertEquals(-1, m1.compareTo(m2));
    }

    /**
     * Se verifica que el valor de m1 es menor que el de m3 mediante el metodo compareTo
     */
    @Test
    void m1CompareTom3ShouldGiveMinusOne(){
        assertEquals(-1, m1.compareTo(m3));
    }
    /**
     * Se verifica que el valor de m1 es menor que el de m4 mediante el metodo compareTo
     */

    @Test
    void m1CompareTom4ShouldGiveMinusOne(){
        assertEquals(-1, m1.compareTo(m4));
    }

    /**
     * Se verifica que el valor de m1 es igual al de m5 mediante el metodo compareTo
     */
    @Test
    void m1CompareTom5ShouldGiveZero(){
        assertEquals(0, m1.compareTo(m5));
    }

    /**
     * Se verifica que el valor de m2 es mayor que el de m1 mediante el metodo compareTo
     */
    @Test
    void m2CompareTom1ShouldGiveOne(){
        assertEquals(1, m2.compareTo(m1));
    }

    /**
     * Se verifica que el valor de m2 es menor que el de m3 mediante el metodo compareTo
     */
    @Test
    void m2CompareTom3ShouldGiveMinusOne(){
        assertEquals(-1, m2.compareTo(m3));
    }

    /**
     * Se verifica que el valor de m3 es mayor que el de m1 mediante el metodo compareTo
     */
    @Test
    void m3CompareTom1ShouldGiveOne(){
        assertEquals(1,m3.compareTo(m1));
    }

    /**
     * Se verifica que el valor de m3 es menor que el de m4 mediante el metodo compareTo
     */
    @Test
    void m3CompareTom4ShouldGiveMinusOne(){
        assertEquals(-1,m3.compareTo(m4));
    }
}