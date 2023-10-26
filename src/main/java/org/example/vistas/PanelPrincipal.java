package org.example.vistas;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    PanelComprador panelComprador;
    PanelExpendedor panelExpendedor;
    public PanelPrincipal(){
        this.panelComprador = new PanelComprador();
        this.panelExpendedor = new PanelExpendedor();
        this.setBackground(Color.white);
    }
    public void paint (Graphics g) {
        super.paint(g);
        panelExpendedor.paint(g);
        panelExpendedor.paint(g);
    }
}
