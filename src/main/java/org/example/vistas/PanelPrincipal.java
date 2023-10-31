package org.example.vistas;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    PanelComprador panelComprador;
    PanelExpendedor panelExpendedor;
    public PanelPrincipal(){
        this.panelComprador = new PanelComprador();
        this.panelExpendedor = new PanelExpendedor();
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