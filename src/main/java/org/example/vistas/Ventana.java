package org.example.vistas;

import javax.swing.*;

/**
 * Clase para inicializar la ventana en la que se va a ejecutar el expendedor.
 * Inicializa panelPrincipal en que esta toda la implementacion de la GUI
 * @author Benjamin Espinoza
 */
public class Ventana extends JFrame {
    PanelPrincipal panelPrincipal;

    /**
     * Clase que establece las configuracion por defecto de la ventana.
     */
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

}
