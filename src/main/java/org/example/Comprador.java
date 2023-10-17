package org.example;

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        Producto p = exp.comprarProducto(m, cualBebida);
        if (p == null) {
            sonido = null;
        } else {
            sonido = p.consumir();
        }
        Moneda aux;
        aux = exp.getVuelto();
        while (aux != null) {
            vuelto += aux.getValor();
            aux = exp.getVuelto();
        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queConsumiste() {
        return sonido;
    }
}
