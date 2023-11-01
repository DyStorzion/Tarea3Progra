package org.example.vistas;

import javax.swing.*;

public class Ventana extends JFrame {
    PanelPrincipal panelPrincipal;
    public Ventana(){
        this.panelPrincipal = new PanelPrincipal();
        this.setSize(1600, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(panelPrincipal);
        this.setTitle("Maquina expendedora");

        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}
