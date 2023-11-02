package org.example.vistas;

import org.example.modelos.Deposito;
import org.example.modelos.Moneda;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelDepositoMoneda extends JPanel {
    private Deposito<Moneda> deposito;
    private ArrayList<PanelMoneda> panelesMonedas;

    public PanelDepositoMoneda(Deposito<Moneda> deposito) {
        this.deposito = deposito;
        this.panelesMonedas = new ArrayList<>();
        setLayout(new GridLayout(1, deposito.size()));
        for (int i = 0; i < deposito.size(); i++){
            Moneda moneda = deposito.getElemento();
            panelesMonedas.add(new PanelMoneda(moneda));
            this.add(panelesMonedas.get(panelesMonedas.size() - 1));
            deposito.addElemento(moneda);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
}
