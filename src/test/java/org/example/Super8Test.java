package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para testear la clase Super8
 * @author Carlos Alvarez
 */
class Super8Test {

    private Super8 super8;

    /**
     * Se crea el dulce con el que se va a hacer los test
     */
    @BeforeEach
    void setUp() {
        super8 = new Super8(15);
    }

    /**
     * test para comprobar que la clase retorne super 8.
     */
    @Test
    @DisplayName("Test para consumir super 8")
    public void seConsumioSuper8(){
        assertEquals("super 8", super8.consumir());
    }
}