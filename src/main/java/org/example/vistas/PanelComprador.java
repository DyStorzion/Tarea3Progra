package org.example.vistas;

import org.example.modelos.Comprador;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private Comprador comprador;
    JButton crearCompradorBoton;
    JLabel descripcionCrearComprador;

    public PanelComprador(){
        this.setBackground(Color.RED);
        this.setLayout(null);

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
