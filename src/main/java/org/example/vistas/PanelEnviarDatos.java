package org.example.vistas;

import javax.swing.*;
import java.awt.*;

public class PanelEnviarDatos extends JPanel {
    JButton crearCompradorBoton;
    JLabel descripcionCrearComprador;
    public PanelEnviarDatos() {
        setLayout(new GridLayout(1, 2));

        crearCompradorBoton = new JButton();
        crearCompradorBoton.setPreferredSize(new Dimension(100, 100));

        descripcionCrearComprador = new JLabel("Presione el boton para realizar una compra.");
        descripcionCrearComprador.setBounds(450, 650, 275, 50);
        descripcionCrearComprador.setOpaque(true);
        descripcionCrearComprador.setBackground(Color.GRAY);


        this.add(crearCompradorBoton, BorderLayout.PAGE_END);
        this.add(descripcionCrearComprador);

    }

}
