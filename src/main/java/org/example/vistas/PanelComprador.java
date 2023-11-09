package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelComprador extends JPanel {
    public Comprador comprador;

    PanelSeleccionBebidas menuBebidas;
    PanelSeleccionMoneda menuMonedas;
    PanelEnviarDatos menuDatos;
    Expendedor expendedor;
    JLabel advertenciaMalUso;

    public PanelComprador(){
        expendedor = new Expendedor(5);
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        menuDatos = new PanelEnviarDatos(this);
        this.add(menuDatos, BorderLayout.SOUTH);

        menuBebidas = new PanelSeleccionBebidas(50, 50, 160, 400);
        this.add(menuBebidas, BorderLayout.LINE_START);


        menuMonedas = new PanelSeleccionMoneda(50, 50, 160,400);
        this.add(menuMonedas, BorderLayout.LINE_END);
    }

    public void crearComprador(){
        Moneda monedaSeleccionada = menuMonedas.getOpcion();
        InfoProducto opcionBebida = menuBebidas.getOpcion();
        System.out.println(monedaSeleccionada);
        System.out.println(opcionBebida);


        advertenciaMalUso = new JLabel();
        try {
            comprador = new Comprador(monedaSeleccionada, opcionBebida, expendedor);

        } catch (NoHayProductoException e) {
            advertenciaMalUso.setText("No hay producto.");

        } catch (PagoIncorrectoException e) {
            advertenciaMalUso.setText("Pago incorrecto.");
            System.out.println("Pago incorrecto.");


        } catch (PagoInsuficienteException e) {
            advertenciaMalUso.setText("Pago insuficiente.");
            System.out.println("dyasubghdjhsab");

        }
        finally {
            this.add(advertenciaMalUso);
        }
    }




}
