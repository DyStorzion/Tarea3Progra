package org.example.vistas;

import org.example.modelos.Moneda;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que gestiona el mostrar una unica moneda de 100, 500, 1000 o 1500.
 * Ambos realizamos cambios en esta clase a pesar de que solo uno hizo el push
 * @author Carlos Alvarez
 * @author Benjamin Espinoza
 */
public class PanelMoneda extends JPanel {
    private Moneda moneda;

    /**
     * Constructor que solamente quita el layout e inicializa la variable.
     * @param moneda
     */
    public PanelMoneda(Moneda moneda) {
        this.moneda = moneda;
        this.setLayout(null);
    }

    /**
     * Se crea circlo que imprime el codigo de serie (la referencia) y el valor de la moneda
     * @param g  the <code>Graphics</code> context in which to paint
     */
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
            g.drawRect(0, 0, getWidth(), getHeight());
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString(String.valueOf(this.moneda.getSerie()), x-50, y);
            g.drawString(String.valueOf("$" + this.moneda.getValor()), x - 25 , y + 20);
        }

    }
}
