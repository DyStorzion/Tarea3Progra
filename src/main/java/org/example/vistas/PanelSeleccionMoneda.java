package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelSeleccionMoneda extends JPanel{
    ArrayList<JRadioButton> botonesMoneda;

    ButtonGroup grupoBotonesMoneda;

    ArrayList<PanelMoneda> panelesMoneda;
    public PanelSeleccionMoneda(int x, int y, int ancho, int alto) {
        setLayout(new GridLayout(4,2));
        setPreferredSize(new Dimension(ancho, alto));
        ArrayList<Moneda> monedasModelo = new ArrayList<>(Arrays.asList(
                new Moneda100(),
                new Moneda500(),
                new Moneda1000(),
                new Moneda1500()
        ));
        botonesMoneda = new ArrayList<>();
        panelesMoneda = new ArrayList<>();
        grupoBotonesMoneda = new ButtonGroup();

        for (int i = 0; i < monedasModelo.size(); i++){
            JRadioButton boton = new JRadioButton();
            botonesMoneda.add(boton);
            grupoBotonesMoneda.add(boton);
            this.add(boton);

            PanelMoneda panel = new PanelMoneda(monedasModelo.get(i));
            panelesMoneda.add(panel);
            this.add(panel);
        }

        botonesMoneda.get(0).setSelected(true);
    }
}
