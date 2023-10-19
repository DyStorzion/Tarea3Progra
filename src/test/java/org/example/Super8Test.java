package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Super8Test {

    private Super8 super8;

    @BeforeEach
    void setUp() {
        super8 = new Super8(15);
    }

    @Test
    @DisplayName("Test para consumir super 8")
    public void seConsumioSuper8(){
        assertEquals("super 8", super8.consumir());
    }
}