package org.example.vistas;

import org.example.modelos.Producto;

import javax.swing.*;
import java.awt.*;

public class PanelProducto extends JPanel {
    private Producto producto;
    private Image logoCocaCola;
    private Image logoSprite;
    private Image logoFanta;
    private Image logoSnickers;
    private Image logoSuper8;
    private int anchoImagen;
    private int altoImagen;

    public PanelProducto(Producto producto) {
        this.setBackground(Color.cyan);
        this.producto = producto;
        this.setLayout(null);
        anchoImagen = 80;
        altoImagen = 80;
        logoCocaCola = new ImageIcon("assets/ImagenCocaCola.png").getImage().getScaledInstance(anchoImagen,altoImagen,Image.SCALE_SMOOTH);
        logoSprite = new ImageIcon("assets/ImagenSprite.png").getImage().getScaledInstance(anchoImagen,altoImagen,Image.SCALE_SMOOTH);
        logoFanta = new ImageIcon("assets/ImagenFanta.png").getImage().getScaledInstance(anchoImagen,altoImagen,Image.SCALE_SMOOTH);
        logoSnickers = new ImageIcon("assets/ImagenSnickers.png").getImage().getScaledInstance(anchoImagen,altoImagen,Image.SCALE_SMOOTH);
        logoSuper8 = new ImageIcon("assets/ImagenSuper8.png").getImage().getScaledInstance(anchoImagen,altoImagen,Image.SCALE_SMOOTH);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());
        if (producto != null) {
            switch (producto.consumir()) {
                case "cocacola":
                    g.drawImage(logoCocaCola, 0, 0, this);
                    break;
                case "sprite":
                    g.drawImage(logoSprite, 0, 0, this);
                    break;
                case "fanta":
                    g.drawImage(logoFanta, 0, 0, this);
                    break;
                case "snickers":
                    g.drawImage(logoSnickers, 0, 0, this);
                    break;
                case "super 8":
                    g.drawImage(logoSuper8, 0, 0, this);
                    break;
            }
        }
        else {
            g.drawString("No hay producto", getWidth() / 2, getHeight() / 2);
        }
    }
}
