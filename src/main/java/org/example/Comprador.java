package org.example;

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda moneda, InfoProducto opcionProducto, Expendedor expendedor)
            throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        Producto p = expendedor.comprarProducto(moneda, opcionProducto);
        sonido = p.consumir();
        Moneda aux;
        aux = expendedor.getVuelto();
        while (aux != null) {
            vuelto += aux.getValor();
            aux = expendedor.getVuelto();
        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queConsumiste() {
        return sonido;
    }
}
