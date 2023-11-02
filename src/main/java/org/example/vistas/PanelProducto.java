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
        switch (producto.consumir()){
            case "cocacola":
                g.drawImage(logoCocaCola, 0, 0, this);
                break;
        }
    }
}
