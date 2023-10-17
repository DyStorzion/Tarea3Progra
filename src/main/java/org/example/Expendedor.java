package org.example;

class Expendedor {
    private Deposito<CocaCola> coca;
    private Deposito<Sprite> sprite;
    private Deposito<Fanta> fanta;
    private Deposito<Super8> super8;
    private Deposito<Snickers> snickers;
    private Deposito<Moneda> monedas;


    public Expendedor(int n) {
        coca = new Deposito<CocaCola>();
        sprite = new Deposito<Sprite>();
        fanta = new Deposito<Fanta>();
        super8 = new Deposito<Super8>();
        snickers = new Deposito<Snickers>();
        monedas = new Deposito<Moneda>();
        for (int i = 0; i < n; i++) {
            coca.addElemento(new CocaCola(100 + i));
            sprite.addElemento(new Sprite(200 + i));
            fanta.addElemento(new Fanta(300 + i));
            super8.addElemento(new Super8(400 + i));
            snickers.addElemento(new Snickers(500 + i));
        }
    }

    public Producto comprarProducto(Moneda moneda, InfoProducto opcionProducto)
            throws PagoIncorrectoException,NoHayProductoException,PagoInsuficienteException {
        if(opcionProducto != InfoProducto.COCA & opcionProducto != InfoProducto.SPRITE & opcionProducto != InfoProducto.FANTA
        & opcionProducto != InfoProducto.SNICKERS & opcionProducto != InfoProducto.SUPER8){
            monedas.addElemento(moneda);
            throw new NoHayProductoException();
        }
        if (moneda == null) {
            throw new PagoIncorrectoException();
        }
        else {
            if (moneda.getValor() < opcionProducto.getPrecio()) {
                monedas.addElemento(moneda);
                throw new NoHayProductoException();
            } else {
                int nb = (moneda.getValor() - opcionProducto.getPrecio()) / 100;
                Producto aux = null;
                switch (opcionProducto) {
                    case COCA:
                        aux = coca.getElemento();
                    case SPRITE:
                        aux = sprite.getElemento();
                    case FANTA:
                        aux = fanta.getElemento();
                    case SUPER8:
                        aux = super8.getElemento();
                    case SNICKERS:
                        aux = snickers.getElemento();
                }
                if (aux == null) {
                    throw new NoHayProductoException();
                }
                else {
                    for (int i = 0; i < nb; i++) {
                        monedas.addElemento(new Moneda100());
                    }
                    return aux;
                }
            }
        }
    }
    public Moneda getVuelto() {
        return monedas.getElemento();
    }
}
