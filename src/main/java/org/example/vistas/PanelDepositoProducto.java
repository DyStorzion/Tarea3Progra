package org.example.vistas;

import org.example.modelos.Deposito;
import org.example.modelos.Moneda;
import org.example.modelos.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelDepositoProducto <T> extends JPanel {
    private Deposito<T> deposito;
    private ArrayList<PanelProducto> panelesProductos;

    public PanelDepositoProducto(Deposito<T> deposito) {
        this.deposito = deposito;
        this.panelesProductos = new ArrayList<>();
        this.setBackground(Color.darkGray);
        setLayout(new GridLayout(1, deposito.size()));
        for (int i = 0; i < deposito.size(); i++){
            T producto = deposito.getElemento();
            panelesProductos.add(new PanelProducto((Producto) producto));
            this.add(panelesProductos.get(panelesProductos.size() - 1));
            deposito.addElemento(producto);
        }
    }

    public void actualizarUltimosElementos(int elementosActualizar){
        ArrayList<T> productos = new ArrayList<>();
        for (int i = 0; i < elementosActualizar; i ++)
            productos.add(deposito.getElemento());
        this.removeAll();
        for (T producto : productos){
            PanelProducto panelProducto = new PanelProducto((Producto) producto);
            this.add(panelProducto);
            panelesProductos.add(panelProducto);
            deposito.addElemento(producto);
        }
        repaint();
    }

    public void quitarElementos(){
        if (deposito.size() >= panelesProductos.size())
            return;
        PanelProducto panelProducto = panelesProductos.remove(panelesProductos.size() - 1);
        this.remove(panelProducto);
    }

    /*@Override
    public void paint(Graphics g) {
        super.paint(g);
        for (PanelProducto panelesProducto : panelesProductos) panelesProducto.paint(g);
    }*/

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        for (PanelProducto panelesProducto : panelesProductos) panelesProducto.paint(g);
    }
}


