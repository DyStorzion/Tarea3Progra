package org.example.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEnviarDatos extends JPanel {
    JButton crearCompradorBoton;
    JLabel descripcionCrearComprador;
    ActionListener botonPresionado;
    PanelComprador panelComprador;

    public PanelEnviarDatos(PanelComprador panelComprador) {
        this.panelComprador = panelComprador;

        setLayout(new GridLayout(1, 2));

        crearCompradorBoton = new JButton();
        crearCompradorBoton.setPreferredSize(new Dimension(100, 100));

        descripcionCrearComprador = new JLabel("Presione el boton para realizar una compra.");
        descripcionCrearComprador.setBounds(450, 650, 275, 50);
        descripcionCrearComprador.setOpaque(true);
        descripcionCrearComprador.setBackground(Color.GRAY);


        this.add(crearCompradorBoton, BorderLayout.PAGE_END);
        this.add(descripcionCrearComprador);
        seEnviaLosDatos();
    }

    private void seEnviaLosDatos(){
        botonPresionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelComprador.crearComprador();
            }
        };
        crearCompradorBoton.addActionListener(botonPresionado);
    }

}
