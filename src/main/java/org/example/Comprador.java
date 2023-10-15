class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        Bebida b = exp.comprarBebida(m, cualBebida);
        if (b == null) {
            sonido = null;
        } else {
            sonido = b.beber();
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

    public String queBebiste() {
        return sonido;
    }
}
