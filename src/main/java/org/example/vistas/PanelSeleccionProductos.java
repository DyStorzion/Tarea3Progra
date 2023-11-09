package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase para administrar el panel de la izquierda de panel comprador donde se seleccionan los Productos.
 * @author Carlos Tomas Alvarez Norambuena
 */
public class PanelSeleccionProductos extends JPanel {

    private ArrayList<JRadioButton> botonesProductos;

    private ButtonGroup grupoBotonesProductos;

    private ArrayList<PanelProducto> panelesProductos;

    /**
     * Constructor de la clase
     * Se añade los detalles esteticos del tipo de layout y se inicializan los botones junto a los paneles de imagenes
     * de las bebidas y dulces.
     */
    public PanelSeleccionProductos() {
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

    /**
     * Se obtiene el producto que se va a comprar.
     * @return producto a comprar.
     */
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
