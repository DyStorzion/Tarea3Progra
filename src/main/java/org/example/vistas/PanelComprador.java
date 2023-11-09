package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelComprador extends JPanel {
    public Comprador comprador;

    PanelSeleccionBebidas menuBebidas;
    PanelSeleccionMoneda menuMonedas;
    PanelEnviarDatos menuDatos;
    PanelPersona panelPersona;
    Expendedor expendedor;
    JLabel advertenciaMalUso;
    JPanel panelAdvertancia;
    Boolean hayBebidaAConsumir;

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


        hayBebidaAConsumir = false;

        mostrarEstadoDeCompra();

        panelPersona = new PanelPersona(advertenciaMalUso, this);
        this.add(panelPersona);

    }

    private void mostrarEstadoDeCompra(){
        panelAdvertancia = new JPanel();
        panelAdvertancia.setBackground(Color.BLACK);

        advertenciaMalUso = new JLabel();
        advertenciaMalUso.setPreferredSize(new Dimension(50, 50));
        advertenciaMalUso.setHorizontalAlignment(SwingConstants.CENTER);

        advertenciaMalUso.setForeground(Color.WHITE);
        advertenciaMalUso.setFont(new Font("Arial", Font.PLAIN, 24));
        advertenciaMalUso.setPreferredSize(new Dimension(500, 50));

        panelAdvertancia.add(advertenciaMalUso);

        this.add(panelAdvertancia, BorderLayout.NORTH);
    }

    public void crearComprador(){
        Moneda monedaSeleccionada = menuMonedas.getOpcion();
        InfoProducto opcionBebida = menuBebidas.getOpcion();

        try {
            comprador = new Comprador(monedaSeleccionada, opcionBebida, expendedor);
            panelPersona.setVuelto(comprador.cuantoVuelto());
            panelPersona.setQueConsumio(comprador.queConsumiste());
            panelPersona.setEstadoABebida();
            menuDatos.desactivarBoton();
            advertenciaMalUso.setText("Haga click en el comprador para consumir");
        }
        catch (NoHayProductoException e) {
            advertenciaMalUso.setText("No hay producto.");
        }
        catch (PagoIncorrectoException e) {
            advertenciaMalUso.setText("Pago incorrecto.");
        }
        catch (PagoInsuficienteException e) {
            advertenciaMalUso.setText("Pago insuficiente.");
        }
    }

    public void activarBebida(){
        hayBebidaAConsumir = true;
        menuDatos.activarBoton();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
}
