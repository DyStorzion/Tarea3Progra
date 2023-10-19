package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para testear la clase Fanta
 * @author Carlos Álvarez
 */
class FantaTest {
    private Fanta fanta;

    /**
     * Se crea la bebida con la que se va a hacer los test
     */
    @BeforeEach
    void setUp() {
        fanta = new Fanta(4);
    }

    /**
     * test para comprobar que la clase retorne fanta.
     */
    @Test
    @DisplayName("Test para consumir fanta")
    public void saborBebidaEsFanta(){
        assertEquals("fanta", fanta.consumir());
    }
}