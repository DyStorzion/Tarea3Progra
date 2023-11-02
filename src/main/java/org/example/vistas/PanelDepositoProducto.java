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

        for (T producto : productos){
            PanelProducto panelProducto = new PanelProducto((Producto) producto);
            this.add(panelProducto);
            panelesProductos.add(panelProducto);
            deposito.addElemento(producto);
        }
    }

    public void quitarElementos(){
        if (deposito.size() >= panelesProductos.size())
            return;
        PanelProducto panelProducto = panelesProductos.remove(panelesProductos.size() - 1);
        this.remove(panelProducto);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for  (int i = 0; i < panelesProductos.size(); i++){
            panelesProductos.get(i).paint(g);
        }
    }
}


