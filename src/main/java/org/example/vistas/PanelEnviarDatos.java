package org.example.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Clase para que controlor el panel que va a estar encargado de enviar los datos y crear comprador
 * Esta compuesto de una label y un boton para enviar.
 * @author Carlos Tomas Álvarez Norambuena
 */
public class PanelEnviarDatos extends JPanel {
    private JButton crearCompradorBoton;
    private JLabel descripcionCrearComprador;
    private ActionListener botonPresionado;
    private PanelComprador panelComprador;

    /**
     * Realiza una asociacion con el panel principal.
     * Se inicializa distintas componentes del panel asi como se establece el tipo de layout entre otras cosas.
     * @param panelComprador panel en el que se va a instaciar PanelEnviarDatos
     */
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

    /**
     * Se añade la logica de cuando el boton del panel es presionado.
     * Funcion que se encarga de llamar a una funcion a panel comprador para que este se encargue de crear el comprador
     */
    private void seEnviaLosDatos(){
        botonPresionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelComprador.crearComprador();
            }
        };
        crearCompradorBoton.addActionListener(botonPresionado);
    }

    /**
     * Funcion para evitar que se presione boton cuando no es deseado y asi evitar posibles bugs.
     */
    public void desactivarBoton(){
        crearCompradorBoton.setEnabled(false);
    }

    /**
     * Funcion para volver a activar el boton.
     */
    public void activarBoton(){
        crearCompradorBoton.setEnabled(true);
    }

}
