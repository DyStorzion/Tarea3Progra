package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelComprador extends JPanel {
    private Comprador comprador;

    private PanelSeleccionBebidas menuBebidas;
    private PanelSeleccionMoneda menuMonedas;
    private PanelEnviarDatos menuDatos;
    private PanelPersona panelPersona;
    private Expendedor expendedor;
    private JLabel advertenciaMalUso;
    private JPanel panelAdvertancia;
    private Boolean hayBebidaAConsumir;
    private PanelExpendedor panelExpendedor;

    public PanelComprador(PanelExpendedor panelExpendedor){
        this.panelExpendedor = panelExpendedor;
        this.expendedor = panelExpendedor.getExpendedor();
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
            panelExpendedor.actualizarDepositosMonedas();
            panelExpendedor.actualizarProductoComprado();
            panelExpendedor.actualizarDepositosProductos();
            panelExpendedor.seComproProducto();
            Moneda aux;
            int vuelto = 0;
            aux = expendedor.getVuelto();
            while (aux != null) {
                vuelto += aux.getValor();
                aux = expendedor.getVuelto();
            }
            comprador.setVuelto(vuelto);
            panelPersona.setVuelto(comprador.cuantoVuelto());
            panelPersona.setQueConsumio(comprador.queConsumiste());
            menuDatos.desactivarBoton();
            advertenciaMalUso.setText("Haga click en el producto para retirarlo");
        }
        catch (NoHayProductoException e) {
            panelExpendedor.actualizarDepositosMonedas();
            expendedor.getDepositoMonedasIngresadas().getElemento();
            expendedor.getVuelto();
            advertenciaMalUso.setText("No hay producto.");
        }
        catch (PagoIncorrectoException e) {
            panelExpendedor.actualizarDepositosMonedas();
            expendedor.getVuelto();
            advertenciaMalUso.setText("Pago incorrecto.");
        }
        catch (PagoInsuficienteException e) {
            panelExpendedor.actualizarDepositosMonedas();
            expendedor.getVuelto();
            advertenciaMalUso.setText("Pago insuficiente.");
        }
    }

    public PanelPersona getPanelPersona() {
        return panelPersona;
    }

    public JLabel getAdvertenciaMalUso() {
        return advertenciaMalUso;
    }

    public void activarBebida(){
        hayBebidaAConsumir = true;
        menuDatos.activarBoton();
    }

    public PanelExpendedor getPanelExpendedor() {
        return panelExpendedor;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
}
