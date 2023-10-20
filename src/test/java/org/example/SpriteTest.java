package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para testear la clase CocaCola
 * @author Carlos Alvarez
 */

class SpriteTest {
    private Sprite sprite;


    /**
     * Se crea la bebida con la que se va a hacer los test
     */
    @BeforeEach
    void setUp() {
        sprite = new Sprite(0);
    }

    /**
     * test para comprobar que la clase retorne sprite.
     */
    @Test
    @DisplayName("Test para consumir sprite")
    public void saborBebidaEsSprite(){
        assertEquals("sprite", sprite.consumir());
    }
}