package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private PanelProducto productoComprado;
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
        this.productoComprado = new PanelProducto(expendedor.getProducto());

        this.setBackground(Color.darkGray);
        this.setLayout(new GridLayout(2,1));

        panelesDepositoProducto.add(depositoCocaCola);
        panelesDepositoProducto.add(depositoFanta);
        panelesDepositoProducto.add(depositoSprite);
        panelesDepositoProducto.add(depositoSnickers);
        panelesDepositoProducto.add(depositoSuper8);

        JPanel panelZonaSuperior = new JPanel();
        panelZonaSuperior.setLayout(new GridLayout(5,1));
        panelZonaSuperior.setBackground(Color.darkGray);

        for (JPanel panelDepositoProducto : panelesDepositoProducto) {
            panelZonaSuperior.add(panelDepositoProducto);
        }

        panelZonaSuperior.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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
                for (JPanel panelDepositoProducto : panelesDepositoProducto) {
                    panelZonaSuperior.add(panelDepositoProducto);
                }
                panelZonaSuperior.revalidate();
                panelZonaSuperior.repaint();
                actualizarDepositosProductos();
            }
        });

        productoComprado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        JPanel panelZonaInferior = new JPanel(new GridLayout(2,1));
        panelZonaInferior.setBackground(Color.lightGray);
        JPanel panelMitadSuperior = new JPanel(new GridLayout(1,2));
        JPanel panelMitadInferior = new JPanel(new GridLayout(1,1));

        panelMitadSuperior.add(depositoMonedasIngresadas);
        panelMitadSuperior.add(productoComprado);
        panelMitadInferior.add(depositoMonedasVuelto);

        panelZonaInferior.add(panelMitadSuperior);
        panelZonaInferior.add(panelMitadInferior);

        try {
            expendedor.comprarProducto(new Moneda1000(), InfoProducto.COCA);
            expendedor.comprarProducto(new Moneda1000(), InfoProducto.COCA);
            expendedor.comprarProducto(new Moneda1000(), InfoProducto.COCA);
        }catch (Exception e){
            System.out.println("A ocurrido un error" + e);
        }
        actualizarDepositosProductos();
        actualizarDepositosMonedas();

        this.add(panelZonaSuperior);
        this.add(panelZonaInferior);
    }

    public void actualizarProductoComprado() {
        this.productoComprado = new PanelProducto(expendedor.getProducto());
        productoComprado.revalidate();
        productoComprado.repaint();
    }

    public Producto getProducto() {
        return expendedor.getProducto();
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
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        depositoCocaCola.paintComponents(g);
        depositoFanta.paintComponents(g);
        depositoSprite.paintComponents(g);
        depositoSnickers.paintComponents(g);
        depositoSuper8.paintComponents(g);
        depositoMonedasVuelto.paintComponents(g);
        depositoMonedasIngresadas.paintComponents(g);
    }
}