package org.example;

class Expendedor {
    private Deposito coca;
    private Deposito sprite;
    private DepositoM monVu;
    private int precio;
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    public Expendedor(int n, int precio) {
        coca = new Deposito();
        sprite = new Deposito();
        monVu = new DepositoM();
        this.precio = precio;
        for (int i = 0; i < n; i++) {
            coca.addBebida(new CocaCola(100 + i));
            sprite.addBebida(new Sprite(200 + i));
        }
    }

    public Bebida comprarBebida(Moneda m, int w) {
        if (m != null) {
            if (m.getValor() >= precio) {
                int nb = (m.getValor() - precio) / 100;
                Bebida aux;
                switch (w) {
                    case COCA:
                        aux = coca.getBebida();
                        if (aux == null) {
                            monVu.addMoneda(m);
                            return null;
                        } else {
                            for (int i = 0; i < nb; i++) {
                                monVu.addMoneda(new Moneda100());
                            }
                            return aux;
                        }
                    case SPRITE:
                        aux = sprite.getBebida();
                        if (aux == null) {
                            monVu.addMoneda(m);
                            return null;
                        } else {
                            for (int i = 0; i < nb; i++) {
                                monVu.addMoneda(new Moneda100());
                            }
                            return aux;
                        }
                    default:
                        monVu.addMoneda(m);
                        return null;
                }
            } else {
                monVu.addMoneda(m);
                return null;
            }
        } else return null;
    }

    public Moneda getVuelto() {
        return monVu.getMoneda();
    }

    public int getPrecio() {
        return precio;
    }
}
