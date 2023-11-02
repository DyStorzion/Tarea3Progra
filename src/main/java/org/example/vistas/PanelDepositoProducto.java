package org.example.vistas;

import org.example.modelos.Deposito;
import org.example.modelos.Moneda;
import org.example.modelos.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelDepositoProducto extends JPanel {
    private Deposito<Producto> deposito;
    private ArrayList<PanelProducto> panelesProductos;

    public PanelDepositoProducto(Deposito<Producto> deposito) {
        this.deposito = deposito;
        this.panelesProductos = new ArrayList<>();
        setLayout(new GridLayout(1, deposito.size()));
        for (int i = 0; i < deposito.size(); i++){
            Producto producto = deposito.getElemento();
            panelesProductos.add(new PanelProducto(producto));
            this.add(panelesProductos.get(panelesProductos.size() - 1));
            deposito.addElemento(producto);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
}


