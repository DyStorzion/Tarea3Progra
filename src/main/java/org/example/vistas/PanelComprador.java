package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelComprador extends JPanel {
    public Comprador comprador;

    PanelSeleccionBebidas menuBebidas;
    PanelSeleccionMoneda menuMonedas;
    PanelEnviarDatos menuDatos;
    Expendedor expendedor;

    public PanelComprador(){
        expendedor = new Expendedor(5);
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        menuDatos = new PanelEnviarDatos(this);
        this.add(menuDatos, BorderLayout.SOUTH);

        menuBebidas = new PanelSeleccionBebidas(50, 50, 160, 400);
        this.add(menuBebidas, BorderLayout.LINE_START);


        menuMonedas = new PanelSeleccionMoneda(50, 50, 160,400);
        this.add(menuMonedas, BorderLayout.LINE_END);
    }

    public void crearComprador(){
        Moneda monedaSeleccionada = menuMonedas.getOpcion();

    }




}
