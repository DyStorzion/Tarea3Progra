package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
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
    private JPanel panelMitadSuperiorZonaInferior;
    private PanelComprador panelComprador;
    private int cantidadBebidas;
    private boolean seRetiroProducto;
    public PanelExpendedor(){
        this.expendedor = new Expendedor(3);
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
        this.seRetiroProducto = false;

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
                boolean seRealizaronCambios = false;
                if(expendedor.getDepositoCoca().size() == 0){
                    for(int i = 0; i < cantidadBebidas; i++){
                        expendedor.getDepositoCoca().addElemento(new CocaCola());
                        seRealizaronCambios = true;
                    }
                }
                if(expendedor.getDepositoFanta().size() == 0){
                    for(int i = 0; i < cantidadBebidas; i++){
                        expendedor.getDepositoFanta().addElemento(new Fanta());
                        seRealizaronCambios = true;
                    }
                }
                if(expendedor.getDepositoSprite().size() == 0){
                    for(int i = 0; i < cantidadBebidas; i++){
                        expendedor.getDepositoSprite().addElemento(new Sprite());
                        seRealizaronCambios = true;
                    }
                }
                if(expendedor.getDepositoSnickers().size() == 0){
                    for(int i = 0; i < cantidadBebidas; i++){
                        expendedor.getDepositoSnickers().addElemento(new Snickers());
                        seRealizaronCambios = true;
                    }
                }
                if(expendedor.getDepositoSuper8().size() == 0){
                    for(int i = 0; i < cantidadBebidas; i++){
                        expendedor.getDepositoSuper8().addElemento(new Super8());
                        seRealizaronCambios = true;
                    }
                }
                if (seRealizaronCambios){
                    for (JPanel panelDepositoProducto : panelesDepositoProducto) {
                        panelZonaSuperior.add(panelDepositoProducto);
                    }
                    panelZonaSuperior.revalidate();
                    panelZonaSuperior.repaint();
                    actualizarDepositosProductos();
                }
            }
        });

        JPanel panelDepositoMonedas = new JPanel();
        panelDepositoMonedas.setLayout(new BorderLayout());

        JPanel panelZonaInferior = new JPanel(new GridLayout(2,1));
        JLabel mensajeDepositoMonedas = new JLabel("Deposito monedas ingresadas");
        mensajeDepositoMonedas.setPreferredSize(new Dimension(50, 50));
        panelDepositoMonedas.add(mensajeDepositoMonedas, BorderLayout.NORTH);
        JLabel mensajeDepositoMonedasVuelto = new JLabel("Deposito monedas de vuelto");
        mensajeDepositoMonedasVuelto.setPreferredSize(new Dimension(50, 50));
        panelDepositoMonedas.add(mensajeDepositoMonedasVuelto,BorderLayout.SOUTH);


        panelZonaInferior.setBackground(Color.lightGray);
        panelMitadSuperiorZonaInferior = new JPanel(new GridLayout(1,2));
        JPanel panelMitadInferiorZonaInferior = new JPanel(new GridLayout(1,1));

        panelMitadSuperiorZonaInferior.add(depositoMonedasIngresadas);
        panelMitadSuperiorZonaInferior.add(productoComprado);
        panelMitadInferiorZonaInferior.add(depositoMonedasVuelto);

        panelZonaInferior.add(panelMitadSuperiorZonaInferior);
        panelZonaInferior.add(panelMitadInferiorZonaInferior);
        panelDepositoMonedas.add(panelZonaInferior, BorderLayout.CENTER);

        this.add(panelZonaSuperior);
        this.add(panelDepositoMonedas);
    }

    public void actualizarProductoComprado() {
        this.productoComprado = new PanelProducto(expendedor.getProducto());
        panelMitadSuperiorZonaInferior.removeAll();
        panelMitadSuperiorZonaInferior.add(depositoMonedasIngresadas);
        panelMitadSuperiorZonaInferior.add(productoComprado);
        panelMitadSuperiorZonaInferior.revalidate();
        panelMitadSuperiorZonaInferior.repaint();
        productoComprado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(!seRetiroProducto) {
                    panelComprador.getPanelPersona().setEstadoProducto();
                    panelComprador.getMensajePanelArriba().setText("Presione el producto para consumirlo");
                    eliminarProductoComprado();
                    seRetiroProducto = true;
                }
            }
        });
    }

    public void eliminarProductoComprado() {
        this.productoComprado = new PanelProducto(null);
        panelMitadSuperiorZonaInferior.removeAll();
        panelMitadSuperiorZonaInferior.add(depositoMonedasIngresadas);
        panelMitadSuperiorZonaInferior.add(productoComprado);
        panelMitadSuperiorZonaInferior.revalidate();
        panelMitadSuperiorZonaInferior.repaint();
        productoComprado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(!seRetiroProducto) {
                    panelComprador.getPanelPersona().setEstadoProducto();
                    panelComprador.getMensajePanelArriba().setText("Presione el producto para consumirlo");
                    eliminarProductoComprado();
                    seRetiroProducto = true;
                }
            }
        });
    }

    public void actualizarDepositosProductos() {
        depositoCocaCola.actualizarUltimosElementos(expendedor.getDepositoCoca().size());
        depositoFanta.actualizarUltimosElementos(expendedor.getDepositoFanta().size());
        depositoSprite.actualizarUltimosElementos(expendedor.getDepositoSprite().size());
        depositoSnickers.actualizarUltimosElementos(expendedor.getDepositoSnickers().size());
        depositoSuper8.actualizarUltimosElementos(expendedor.getDepositoSuper8().size());
    }

    public void actualizarDepositosMonedas() {
        depositoMonedasVuelto.actualizarUltimosElementos(expendedor.getDepositoMonedas().size());
        depositoMonedasIngresadas.actualizarUltimosElementos(expendedor.getDepositoMonedasIngresadas().size());
    }

    public Expendedor getExpendedor() {
        return expendedor;
    }

    public Producto getProducto() {
        return expendedor.getProducto();
    }

    public void setPanelComprador(PanelComprador panelComprador) {
        this.panelComprador = panelComprador;
    }

    public void seComproProducto() {
        this.seRetiroProducto = false;
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
        productoComprado.paintComponents(g);
    }
}