package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnickersTest {

    private Snickers snicker;

    @BeforeEach
    void setUp() {
        snicker = new Snickers(1);
    }

    @Test
    @DisplayName("Test para consumir snickers")
    public void seConsumioSnickers(){
        assertEquals("snickers", snicker.consumir());
    }
}