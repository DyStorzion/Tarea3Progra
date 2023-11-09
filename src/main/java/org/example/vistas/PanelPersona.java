package org.example.vistas;

import org.example.modelos.Comprador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPersona extends JPanel {
    private Image personaEsperando;
    private Image personaConBebida;
    private Image personaMensaje;
    private String estados;
    private JLabel labelArriba;
    private String queConsumio;
    private int vuelto;
    private PanelComprador panelComprador;

    public PanelPersona(JLabel panelArriba, PanelComprador panelComprador) {
        this.labelArriba = panelArriba;
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

    public void oyenteDeMouse(){

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
