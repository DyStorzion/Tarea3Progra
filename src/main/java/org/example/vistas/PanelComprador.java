package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelComprador extends JPanel {
    private Comprador comprador;
    JButton crearCompradorBoton;
    JLabel descripcionCrearComprador;
    ArrayList<JRadioButton> botonesProductos;
    ArrayList<JRadioButton> botonesMonedas;
    ButtonGroup grupoBotonesProductos;
    ButtonGroup grupoBotonesMonedas;
    ArrayList<PanelProducto> panelesProductos;
    ArrayList<PanelMoneda> panelesMonedas;

    private void enviarDatos(){
        crearCompradorBoton = new JButton();
        crearCompradorBoton.setBounds(700, 650, 50, 50);

        descripcionCrearComprador = new JLabel("Presione el boton para realizar una compra.");
        descripcionCrearComprador.setBounds(450, 650, 275, 50);
        descripcionCrearComprador.setOpaque(true);
        descripcionCrearComprador.setBackground(Color.GRAY);


        this.add(crearCompradorBoton);
        this.add(descripcionCrearComprador);
    }

    private void crearOpcionesMonedas(){
        ArrayList<Moneda> monedasModelo = new ArrayList<>(Arrays.asList(
                new Moneda100(),
                new Moneda500(),
                new Moneda1000(),
                new Moneda1500()
        ));
        botonesMonedas = new ArrayList<>();
        panelesMonedas = new ArrayList<>();
        grupoBotonesMonedas = new ButtonGroup();

        for (int i = 0; i < monedasModelo.size(); i++){
            JRadioButton boton = new JRadioButton();
            boton.setBounds(740, 100 * i, 20, 20);
            botonesMonedas.add(boton);
            grupoBotonesMonedas.add(boton);
            this.add(boton);

            PanelMoneda panel = new PanelMoneda(monedasModelo.get(i));
            panel.setBounds(650, 100 * i, 80, 80);
            panelesMonedas.add(panel);
            this.add(panel);

        }
    }
    private void crearOpcionesProductos(){
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
            boton.setBounds(50, 100 * i, 20, 20);
            botonesProductos.add(boton);
            grupoBotonesProductos.add(boton);
            this.add(boton);

            PanelProducto panel = new PanelProducto(productosModelo.get(i));
            panel.setBounds(80, 100 * i, 80, 80);
            panelesProductos.add(panel);
            this.add(panel);

        }
    }
    public PanelComprador(){
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        enviarDatos();
        crearOpcionesProductos();
        crearOpcionesMonedas();


    }



}
