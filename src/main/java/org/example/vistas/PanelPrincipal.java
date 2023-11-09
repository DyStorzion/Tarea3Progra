package org.example.vistas;

import javax.swing.*;
import java.awt.*;

/**
 * Clase para el panel principal del expendedor.
 * Esta dividido en 2 paneles principales, 1 para el expendedor y otro para el comprador
 */
public class PanelPrincipal extends JPanel {
    PanelComprador panelComprador;
    PanelExpendedor panelExpendedor;

    /**
     * Se inicialia el panel principal y se divide en 2 para los 2 paneles.
     */
    public PanelPrincipal(){
        this.panelExpendedor = new PanelExpendedor();
        this.panelComprador = new PanelComprador(panelExpendedor);
        panelExpendedor.setPanelComprador(panelComprador);
        this.setLayout(new GridLayout(1,2));
        this.add(panelComprador);
        this.add(panelExpendedor);


        this.setBackground(Color.GRAY);
    }
    public void paint (Graphics g) {
        super.paint(g);
        panelExpendedor.paint(g);
        panelComprador.paint(g);
    }
}
