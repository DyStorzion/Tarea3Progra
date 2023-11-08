package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelComprador extends JPanel {
    private Comprador comprador;

    PanelSeleccionBebidas menuBebidas;
    PanelSeleccionMoneda menuMonedas;
    PanelEnviarDatos menuDatos;

    public PanelComprador(){
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        menuDatos = new PanelEnviarDatos();
        this.add(menuDatos, BorderLayout.SOUTH);

        menuBebidas = new PanelSeleccionBebidas(50, 50, 160, 400);
        this.add(menuBebidas, BorderLayout.LINE_START);


        menuMonedas = new PanelSeleccionMoneda(50, 50, 160,400);
        this.add(menuMonedas, BorderLayout.LINE_END);
    }






}
