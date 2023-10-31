package org.example.vistas;

import javax.swing.*;

public class MostrarMoneda extends MostrarElemento {
    private int precio;
    public MostrarMoneda(int precio, int x, int y) {
        super(x, y);
        this.precio = precio;

    }
}
