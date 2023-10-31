package org.example.vistas;

import org.example.modelos.InfoProducto;

import javax.swing.*;

public class MostrarProducto extends MostrarElemento{
    InfoProducto productoMostrar;
    public MostrarProducto(InfoProducto productoMostrar, int x, int y) {
        super(x, y);
        this.productoMostrar = productoMostrar;
    }
}
