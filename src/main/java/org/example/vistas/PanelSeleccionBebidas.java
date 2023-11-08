package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelSeleccionBebidas extends JPanel {

    ArrayList<JRadioButton> botonesProductos;

    ButtonGroup grupoBotonesProductos;

    ArrayList<PanelProducto> panelesProductos;
    public PanelSeleccionBebidas(int x, int y, int ancho, int alto) {
        this.setBounds(x, y, ancho, alto);
        setLayout(new GridLayout(5, 2));

        ArrayList<Producto> productosModelo = new ArrayList<>(Arrays.asList(
                new CocaCola(1),
                new Sprite(1),
                new Fanta(1),
                new Super8(1),
                new Snickers(1)
        ));
        botonesProductos = new ArrayList<>();
        panelesProductos = new ArrayList<>();
        grupoBotonesProductos = new ButtonGroup();

        for (int i = 0; i < productosModelo.size(); i++){
            JRadioButton boton = new JRadioButton();
            botonesProductos.add(boton);
            grupoBotonesProductos.add(boton);
            this.add(boton);

            PanelProducto panel = new PanelProducto(productosModelo.get(i));
            panelesProductos.add(panel);
            this.add(panel);

        }

        botonesProductos.get(0).setSelected(true);
    }


}
