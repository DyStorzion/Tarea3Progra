package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelSeleccionMoneda extends JPanel{
    private ArrayList<JRadioButton> botonesMoneda;

    private ButtonGroup grupoBotonesMoneda;

    private ArrayList<PanelMoneda> panelesMoneda;
    public PanelSeleccionMoneda(int ancho, int alto) {
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

    public Moneda getOpcion(){
        int opcion = 0;
        for (int i = 0; i < botonesMoneda.size(); i++){
            if (botonesMoneda.get(i).isSelected()){
                opcion = i;
                break;
            }
        }
        switch (opcion){
            case 0:
                return new Moneda100();

            case 1:
                return new Moneda500();

            case 2:
                return new Moneda1000();

            case 3:
                return new Moneda1500();
        }
        return null;
    }
}
