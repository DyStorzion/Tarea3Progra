package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelSeleccionProductos extends JPanel {

    ArrayList<JRadioButton> botonesProductos;

    ButtonGroup grupoBotonesProductos;

    ArrayList<PanelProducto> panelesProductos;
    public PanelSeleccionProductos(int x, int y, int ancho, int alto) {
        this.setBounds(x, y, ancho, alto);
        setLayout(new GridLayout(5, 2));

        ArrayList<Producto> productosModelo = new ArrayList<>(Arrays.asList(
                new CocaCola(),
                new Sprite(),
                new Fanta(),
                new Super8(),
                new Snickers()
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

    public InfoProducto getOpcion(){
        int opcion = 0;
        for (int i = 0; i < botonesProductos.size(); i++){
            if (botonesProductos.get(i).isSelected()){
                opcion = i;
                break;
            }
        }

        switch (opcion){
            case 0:
                return InfoProducto.COCA;

            case 1:
                return InfoProducto.SPRITE;

            case 2:
                return  InfoProducto.FANTA;

            case 3:
                return  InfoProducto.SUPER8;
            case 4:
                return InfoProducto.SNICKERS;
        }
        return null;
    }


}
