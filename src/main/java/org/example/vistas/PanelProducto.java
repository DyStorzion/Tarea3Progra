package org.example.vistas;

import org.example.modelos.Producto;

import javax.swing.*;
import java.awt.*;

/**
 * Clase para mostrar un panel con un producto.
 * @author Carlos Tomas Alvarez Norambuena
 */
public class PanelProducto extends JPanel {
    private Producto producto;
    private Image logoCocaCola;
    private Image logoSprite;
    private Image logoFanta;
    private Image logoSnickers;
    private Image logoSuper8;
    private int anchoImagen;
    private int altoImagen;


    /**
     * Se entrega un producto y se inicializan las posibles imagenes que puede contener este panel.
     * Se realiza esto a modo de evitar un bug que evitaba que se cargata la imagen.
     * Se establece un valor por defecto de 80*80 para el tamaño del mismo.
     * @param producto se entrega el producto del que se quiere hacer la imagen.
     */
    public PanelProducto(Producto producto) {
        this.setBackground(Color.WHITE);
        this.producto = producto;
        this.setLayout(null);
        anchoImagen = 80;
        altoImagen = 80;
        this.setPreferredSize(new Dimension(80, 80));
        logoCocaCola = new ImageIcon("assets/ImagenCocaCola.png").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);
        logoSprite = new ImageIcon("assets/ImagenSprite.png").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);
        logoFanta = new ImageIcon("assets/ImagenFanta.png").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);
        logoSnickers = new ImageIcon("assets/ImagenSnickers.png").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);
        logoSuper8 = new ImageIcon("assets/ImagenSuper8.png").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);
    }

    /**
     * Se entrega un producto y se inicializan las posibles imagenes que puede contener este panel.
     * Se realiza esto a modo de evitar un bug que evitaba que se cargata la imagen.
     * Se establece un valor de anchoImagen y altoImagen para el tamaño del mismo.
     * @param producto se entrega el producto del que se quiere hacer la imagen.
     * @param anchoImagen
     * @param altoImagen
     */
    public PanelProducto(Producto producto, int anchoImagen, int altoImagen) {
        this.setBackground(Color.WHITE);
        this.producto = producto;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(anchoImagen, altoImagen));
        logoCocaCola = new ImageIcon("assets/ImagenCocaCola.png").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        logoSprite = new ImageIcon("assets/ImagenSprite.png").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        logoFanta = new ImageIcon("assets/ImagenFanta.png").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        logoSnickers = new ImageIcon("assets/ImagenSnickers.png").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        logoSuper8 = new ImageIcon("assets/ImagenSuper8.png").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
    }

    /**
     * Se dibuja la imagen dependiendo del producto
     * @param g  the <code>Graphics</code> context in which to paint
     */
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
