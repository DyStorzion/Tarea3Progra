package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {
    private Moneda m1;
    private Moneda m2;
    private Moneda m3;
    private Moneda m4;
    private Moneda m5;
    @BeforeEach
    void setUp(){
        m1 = new Moneda100();
        m2 = new Moneda500();
        m3 = new Moneda1000();
        m4 = new Moneda1500();
        m5 = new Moneda100();
    }
    @Test
    void m1CompareTom2ShouldGiveMinusOne(){
        assertEquals(-1, m1.compareTo(m2));
    }
    @Test
    void m1CompareTom3ShouldGiveMinusOne(){
        assertEquals(-1, m1.compareTo(m3));
    }

    @Test
    void m1CompareTom4ShouldGiveMinusOne(){
        assertEquals(-1, m1.compareTo(m4));
    }
    @Test
    void m1CompareTom5ShouldGiveZero(){
        assertEquals(0, m1.compareTo(m5));
    }

    @Test
    void m2CompareTom1ShouldGiveOne(){
        assertEquals(1, m2.compareTo(m1));
    }
    @Test
    void m2CompareTom3ShouldGiveMinusOne(){
        assertEquals(-1, m2.compareTo(m3));
    }
    @Test
    void m3CompareTom1ShouldGiveOne(){
        assertEquals(1,m3.compareTo(m1));
    }
    @Test
    void m3CompareTom4ShouldGiveMinusOne(){
        assertEquals(-1,m3.compareTo(m4));
    }
}