package org.example.vistas;

import org.example.modelos.Comprador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase para manejar el panel central del panel de comprador donde se dibuja una persona y ademas se consume el producto
 *
 * @author Carlos Tomas Alvarez Norambuena
 */
public class PanelPersona extends JPanel {
    private Image personaEsperando;
    private Image personaConBebida;
    private Image personaMensaje;
    private String estados;
    private JLabel labelArriba;
    private String queConsumio;
    private int vuelto;
    private PanelComprador panelComprador;

    /**
     * Constructor de la clase PanelPersona.
     * @param labelArriba se entrega la label de arriba del panel para que esta clase pueda modificarla directamente
     * @param panelComprador panelComprador del cual este panel pertenece.
     */
    public PanelPersona(JLabel labelArriba, PanelComprador panelComprador) {
        this.labelArriba = labelArriba;
        this.panelComprador = panelComprador;

        setLayout(null);
        setBackground(Color.WHITE);
        int anchoImagen = 300;
        int altoImagen = 600;
        estados = new String("Esperando");

        personaEsperando = new ImageIcon("assets/PersonaEsperando.png").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);
        personaConBebida = new ImageIcon("assets/PersonaConBebida.png").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);
        personaMensaje = new ImageIcon("assets/PersonaMensaje.png").getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);

        oyenteDeMouse();
    }

    /**
     * Funcion donde se inicializa el evento de mouse para tomar la bebida.
     */
    private void oyenteDeMouse(){

        MouseListener eventoPanel = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (estados.equals("Producto")){
                    labelArriba.setText("Consumi " + queConsumio + " y mi vuelto " + vuelto);
                    estados = "Esperando";
                    panelComprador.activarBebida();
                    repaint();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        this.addMouseListener(eventoPanel);
    }

    /**
     * Se actualiza el estado del producto para posteriormente cambiar a la imagen correspondiente.
     */
    public void setEstadoProducto(){
        estados = "Producto";
        repaint();
    }


    public void setQueConsumio(String queConsumio) {
        this.queConsumio = queConsumio;
    }

    public void setVuelto(int vuelto) {
        this.vuelto = vuelto;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        switch (estados){
            case "Esperando":
                g.drawImage(personaEsperando, 100, 0, this);
                break;
            case "Producto":
                g.drawImage(personaConBebida, 100, 0, this);
                break;

        }
    }


}
