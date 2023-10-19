package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CocaColaTest {
    private CocaCola cocacola;

    @BeforeEach
    void setUp() {
        cocacola = new CocaCola(15);
    }

   @Test
   @DisplayName("Test para consumir cocacola")
    public void saborBebidaEsCocacola(){
        assertEquals("cocacola", cocacola.consumir());
    }
}