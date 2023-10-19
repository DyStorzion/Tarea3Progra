package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FantaTest {
    private Fanta fanta;

    @BeforeEach
    void setUp() {
        fanta = new Fanta(4);
    }

    @Test
    @DisplayName("Test para consumir sprite")
    public void saborBebidaEsFanta(){
        assertEquals("fanta", fanta.consumir());
    }
}