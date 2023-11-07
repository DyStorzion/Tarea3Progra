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
    PanelSeleccionBebidas menuBebidas;
    PanelSeleccionMoneda menuMonedas;

    public PanelComprador(){
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        enviarDatos();
        menuBebidas = new PanelSeleccionBebidas(50, 50, 160, 400);
        this.add(menuBebidas);

        menuMonedas = new PanelSeleccionMoneda(600, 50, 160,340);
        this.add(menuMonedas);
    }

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




}
