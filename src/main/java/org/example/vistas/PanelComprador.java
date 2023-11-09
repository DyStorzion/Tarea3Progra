package org.example.vistas;

import org.example.modelos.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que se va a encargar del panel de la izquierda de nuestro expendedor, que vendria siendo el panel de comprador.
 * author Carlos Tomas Alvarez Norambuena
 */

public class PanelComprador extends JPanel {
    private Comprador comprador;

    private PanelSeleccionProductos menuBebidas;
    private PanelSeleccionMoneda menuMonedas;
    private PanelEnviarDatos menuDatos;
    private PanelPersona panelPersona;
    private Expendedor expendedor;
    private JLabel MensajePanelArriba;
    private JPanel panelMensajeArriba;
    private Boolean hayBebidaAConsumir;
    private PanelExpendedor panelExpendedor;

    /**
     * Constructor de la clase PanelComprador.
     * Se inicializan todos los subpaneles que este contiene. Tambien se pasa panelExpendedor para tener una asociacion
     * entre ambos objetos.
     * @param panelExpendedor
     */
    public PanelComprador(PanelExpendedor panelExpendedor){
        this.panelExpendedor = panelExpendedor;
        this.expendedor = panelExpendedor.getExpendedor();
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        menuDatos = new PanelEnviarDatos(this);
        this.add(menuDatos, BorderLayout.SOUTH);

        menuBebidas = new PanelSeleccionProductos();
        this.add(menuBebidas, BorderLayout.LINE_START);


        menuMonedas = new PanelSeleccionMoneda( 160,400);
        this.add(menuMonedas, BorderLayout.LINE_END);


        hayBebidaAConsumir = false;

        mostrarEstadoDeCompra();

        panelPersona = new PanelPersona(MensajePanelArriba, this);
        this.add(panelPersona);

    }

    /**
     * Funcion para hacer el panel de arriba que muestra mensajes sobre el estado de la compra.
     */
    private void mostrarEstadoDeCompra(){
        panelMensajeArriba = new JPanel();
        panelMensajeArriba.setBackground(Color.BLACK);

        MensajePanelArriba = new JLabel();
        MensajePanelArriba.setPreferredSize(new Dimension(50, 50));
        MensajePanelArriba.setHorizontalAlignment(SwingConstants.CENTER);

        MensajePanelArriba.setForeground(Color.WHITE);
        MensajePanelArriba.setFont(new Font("Arial", Font.PLAIN, 24));
        MensajePanelArriba.setPreferredSize(new Dimension(500, 50));

        panelMensajeArriba.add(MensajePanelArriba);

        this.add(panelMensajeArriba, BorderLayout.NORTH);
    }

    /**
     * Funcion para instanciar el comprador.
     * Aqui se utiliza la asociacion para poder instanciar el comprador.
     * Tambien se gestiona todas las posibles excepciones y se realizan las actualizaciones correspondientes.
     */
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
            MensajePanelArriba.setText("Haga click en el producto para retirarlo");
        }
        catch (NoHayProductoException e) {
            panelExpendedor.actualizarDepositosMonedas();
            expendedor.getDepositoMonedasIngresadas().getElemento();
            expendedor.getVuelto();
            MensajePanelArriba.setText("No hay producto.");
        }
        catch (PagoIncorrectoException e) {
            panelExpendedor.actualizarDepositosMonedas();
            expendedor.getVuelto();
            MensajePanelArriba.setText("Pago incorrecto.");
        }
        catch (PagoInsuficienteException e) {
            panelExpendedor.actualizarDepositosMonedas();
            expendedor.getVuelto();
            MensajePanelArriba.setText("Pago insuficiente.");
        }
    }

    /**
     * Funcion para activar el boton.
     */
    public void activarBebida(){
        hayBebidaAConsumir = true;
        menuDatos.activarBoton();
    }

    public PanelPersona getPanelPersona() {
        return panelPersona;
    }

    public JLabel getMensajePanelArriba() {
        return MensajePanelArriba;
    }


    public PanelExpendedor getPanelExpendedor() {
        return panelExpendedor;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
