package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpriteTest {
    private Sprite sprite;

    @BeforeEach
    void setUp() {
        sprite = new Sprite(0);
    }

    @Test
    @DisplayName("Test para consumir sprite")
    public void saborBebidaEsSprite(){
        assertEquals("sprite", sprite.consumir());
    }
}