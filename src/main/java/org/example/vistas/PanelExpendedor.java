package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel {
    private Expendedor expendedor;
    private PanelDepositoProducto<CocaCola> depositoCocaCola;
    private PanelDepositoProducto<Fanta> depositoFanta;
    private PanelDepositoProducto<Sprite> depositoSprite;
    private PanelDepositoProducto<Snickers> depositoSnickers;
    private PanelDepositoProducto<Super8> depositoSuper8;
    private PanelDepositoMoneda depositoMonedasIngresadas;
    private PanelDepositoMoneda depositoMonedasVuelto;
    private ArrayList<JPanel> panelesDepositoProducto;
    private int cantidadBebidas;
    public PanelExpendedor(Expendedor expendedor){
        this.expendedor = expendedor;
        this.panelesDepositoProducto = new ArrayList<>();
        this.cantidadBebidas = expendedor.getDepositoSnickers().size();
        this.depositoCocaCola = new PanelDepositoProducto<>(expendedor.getDepositoCoca());
        this.depositoFanta = new PanelDepositoProducto<>(expendedor.getDepositoFanta());
        this.depositoSprite = new PanelDepositoProducto<>(expendedor.getDepositoSprite());
        this.depositoSnickers = new PanelDepositoProducto<>(expendedor.getDepositoSnickers());
        this.depositoSuper8 = new PanelDepositoProducto<>(expendedor.getDepositoSuper8());
        this.depositoMonedasIngresadas = new PanelDepositoMoneda(expendedor.getDepositoMonedasIngresadas());
        this.depositoMonedasVuelto = new PanelDepositoMoneda(expendedor.getDepositoMonedas());

        JButton botonRellenar = new JButton();
        botonRellenar.setOpaque(false);
        botonRellenar.setContentAreaFilled(false);
        botonRellenar.setBorderPainted(false);

        this.setBackground(Color.darkGray);
        this.setLayout(new GridLayout(2,1));

        panelesDepositoProducto.add(depositoCocaCola);
        panelesDepositoProducto.add(depositoFanta);
        panelesDepositoProducto.add(depositoSprite);
        panelesDepositoProducto.add(depositoSnickers);
        panelesDepositoProducto.add(depositoSuper8);

        JPanel panelZonaSuperior = new JPanel();
        panelZonaSuperior.setLayout(new OverlayLayout(panelZonaSuperior));

        JPanel panelBoton = new JPanel(new GridLayout(1,1));
        panelBoton.add(botonRellenar);
        panelBoton.setOpaque(false);

        JPanel panelDepositosProductos = new JPanel();
        panelDepositosProductos.setLayout(new GridLayout(5,1));
        panelDepositosProductos.setBackground(Color.darkGray);

        for (JPanel panelDepositoProducto : panelesDepositoProducto) {
            panelDepositosProductos.add(panelDepositoProducto);
        }

        panelZonaSuperior.add(panelBoton);
        panelZonaSuperior.add(panelDepositosProductos);

        JPanel panelZonaInferior = new JPanel(new GridLayout(2,1));
        panelZonaInferior.setBackground(Color.lightGray);
        JPanel panelMitadSuperior = new JPanel(new GridLayout(1,2));
        JPanel panelMitadInferior = new JPanel(new GridLayout(1,1));

        panelMitadSuperior.add(depositoMonedasIngresadas);
        panelMitadSuperior.add(new JLabel("NO HAY NINGUN PRODUCTO COMPRADO"));
        panelMitadInferior.add(depositoMonedasVuelto);

        panelZonaInferior.add(panelMitadSuperior);
        panelZonaInferior.add(panelMitadInferior);

        this.add(panelZonaSuperior);
        this.add(panelZonaInferior);
        botonRellenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("flag");
                if(expendedor.getDepositoCoca().size() == 0){
                    for(int i = 0; i < cantidadBebidas; i++){
                        expendedor.getDepositoCoca().addElemento(new CocaCola(i + 100));
                    }
                }
                if(expendedor.getDepositoFanta().size() == 0){
                    for(int i = 0; i < cantidadBebidas; i++){
                        expendedor.getDepositoFanta().addElemento(new Fanta(i + 200));
                    }
                }
                if(expendedor.getDepositoSprite().size() == 0){
                    for(int i = 0; i < cantidadBebidas; i++){
                        expendedor.getDepositoSprite().addElemento(new Sprite(i + 300));
                    }
                }
                if(expendedor.getDepositoSnickers().size() == 0){
                    for(int i = 0; i < cantidadBebidas; i++){
                        expendedor.getDepositoSnickers().addElemento(new Snickers(i + 400));
                    }
                }
                if(expendedor.getDepositoSuper8().size() == 0){
                    for(int i = 0; i < cantidadBebidas; i++){
                        expendedor.getDepositoSuper8().addElemento(new Super8(i + 500));
                    }
                }
                actualizarDepositosProductos();
            }
        });
        try {
            expendedor.comprarProducto(new Moneda1000(), InfoProducto.SPRITE);
            expendedor.comprarProducto(new Moneda1000(), InfoProducto.SPRITE);
            expendedor.comprarProducto(new Moneda1000(), InfoProducto.SPRITE);
        }catch (Exception e){
            System.out.println("A ocurrido un error" + e);
        }
        actualizarDepositosProductos();
    }

    public void actualizarDepositosProductos() {
        depositoCocaCola.actualizarUltimosElementos(expendedor.getDepositoCoca().size());
        depositoFanta.actualizarUltimosElementos(expendedor.getDepositoFanta().size());
        depositoSprite.actualizarUltimosElementos(expendedor.getDepositoSprite().size());
        depositoSnickers.actualizarUltimosElementos(expendedor.getDepositoSnickers().size());
        depositoSuper8.actualizarUltimosElementos(expendedor.getDepositoSuper8().size());
    }

    /*public void quitarProductos(){
        depositoCocaCola.quitarElementos();
        depositoFanta.quitarElementos();
        depositoSprite.quitarElementos();
        depositoSnickers.quitarElementos();
        depositoSuper8.quitarElementos();
    }*/

    public void actualizarDepositosMonedas() {
        depositoMonedasVuelto.actualizarUltimosElementos(expendedor.getDepositoMonedas().size());
        depositoMonedasIngresadas.actualizarUltimosElementos(expendedor.getDepositoMonedasIngresadas().size());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (JPanel panelDepositoProducto: panelesDepositoProducto) {
            panelDepositoProducto.paint(g);
        }
        depositoMonedasVuelto.paint(g);
        depositoMonedasIngresadas.paint(g);
    }
}
