package org.example.vistas;

import javax.swing.*;

public class Ventana extends JFrame {
    PanelPrincipal panelPrincipal;
    public Ventana(){
        this.panelPrincipal = new PanelPrincipal();
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(panelPrincipal);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}
