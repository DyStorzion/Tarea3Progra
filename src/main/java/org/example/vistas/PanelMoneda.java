package org.example.vistas;

import org.example.modelos.Moneda;

import javax.swing.*;
import java.awt.*;

/**
 *
 * Ambos realizamos cambios en esta calse a pesar de que solo uno hizo el push
 * @author Carlos Alvarez
 * @author Benjamin Espinoza
 */
public class PanelMoneda extends JPanel {
    private Moneda moneda;
    public PanelMoneda(Moneda moneda) {
        this.moneda = moneda;
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (moneda != null) {
            int valor = moneda.getValor();
            int x = this.getWidth() / 2;
            int y = this.getHeight() / 2;
            int radio = Math.min(x,y);
            switch (valor) {
                case 100:
                    g.setColor(Color.YELLOW);
                    break;
                case 500:
                    g.setColor(Color.ORANGE);
                    break;
                case 1000:
                    g.setColor(Color.RED);
                    break;
                case 1500:
                    g.setColor(Color.MAGENTA);
                    break;
            }
            g.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString(String.valueOf(this.moneda.getSerie()), x-50, y);
        }

    }
}
