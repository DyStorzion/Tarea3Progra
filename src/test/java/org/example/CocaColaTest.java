package org.example;

import org.example.modelos.CocaCola;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para testear la clase CocaCola
 * @author Carlos Alvarez
 */
class CocaColaTest {
    private CocaCola cocacola;

    /**
     * Se crea la bebida con la que se va a hacer los test
     */
    @BeforeEach
    void setUp() {
        cocacola = new CocaCola(15);
    }

    /**
     * test para comprobar que la clase retorne cocacola.
     */
   @Test
   @DisplayName("Test para consumir cocacola")
    public void saborBebidaEsCocacola(){
        assertEquals("cocacola", cocacola.consumir());
    }
}