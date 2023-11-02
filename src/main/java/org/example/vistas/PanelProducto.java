package org.example.vistas;

import org.example.modelos.Producto;

import javax.swing.*;
import java.awt.*;

public class PanelProducto extends JPanel {
    private Producto producto;

    public PanelProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        switch (producto.consumir()){
            case "cocacola":
                break;
        }
    }
}
