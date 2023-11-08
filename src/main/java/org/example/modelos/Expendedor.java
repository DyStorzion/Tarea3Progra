package org.example.modelos;

/**
 * Clase para crear un expendedor con los distintos depositos y metodos para comprar y conseguir el vuelto
 *
 * @author Benjamin Espinoza
 */
public class Expendedor {
    private Deposito<CocaCola> DepositoCoca;
    private Deposito<Sprite> DepositoSprite;
    private Deposito<Fanta> DepositoFanta;
    private Deposito<Super8> DepositoSuper8;
    private Deposito<Snickers> DepositoSnickers;
    private Deposito<Moneda> DepositoMonedas;
    private Deposito<Moneda> DepositoMonedasIngresadas;
    private Producto productoComprado;

    /**
     * Constructor que inicializa los depositos con la cantidad de bebidas indicada
     * @param n numero de bebidas que se ingresan en los depositos
     */
    public Expendedor(int n) {
        DepositoCoca = new Deposito<CocaCola>();
        DepositoSprite = new Deposito<Sprite>();
        DepositoFanta = new Deposito<Fanta>();
        DepositoSuper8 = new Deposito<Super8>();
        DepositoSnickers = new Deposito<Snickers>();
        DepositoMonedas = new Deposito<Moneda>();
        DepositoMonedasIngresadas = new Deposito<Moneda>();
        for (int i = 0; i < n; i++) {
            DepositoCoca.addElemento(new CocaCola());
            DepositoSprite.addElemento(new Sprite());
            DepositoFanta.addElemento(new Fanta());
            DepositoSuper8.addElemento(new Super8());
            DepositoSnickers.addElemento(new Snickers());
        }
    }

    /**
     *Se encarga de realizar la compra del producto
     * Si se realiza la compra se usa un for para ingresar las monedas de 100 que sobraron al deposito de monedas
     * OJO: Segun las instrucciones de la tarea expendedor acepta monedas de 100 a 1000 pesos por lo tanto no de 1500
     * Ante este caso se tira PagoIncorrectoException.
     * @param moneda moneda ingresada para comprar
     * @param opcionProducto opcion elegida del prodcuto por el comprador
     * @return producto comprado
     * @throws PagoIncorrectoException si la moneda no existe
     * @throws NoHayProductoException si no queda del producto elegido o ingreso una opcion no valida
     * @throws PagoInsuficienteException si la moneda tiene un valor menor al precio del producto
     */
    public void comprarProducto(Moneda moneda, InfoProducto opcionProducto)
            throws PagoIncorrectoException,NoHayProductoException,PagoInsuficienteException {

        if (moneda == null || moneda.getValor() == 1500)
            throw new PagoIncorrectoException();

        if (moneda.getValor() < opcionProducto.getPrecio()) {
            DepositoMonedas.addElemento(moneda);
            throw new PagoInsuficienteException();
        }

        DepositoMonedasIngresadas.addElemento(moneda);

        int cantidadMonedas100 = (moneda.getValor() - opcionProducto.getPrecio()) / 100;
        Producto aux = null;
        switch (opcionProducto) {
            case COCA:
                aux = DepositoCoca.getElemento();
                break;
            case SPRITE:
                aux = DepositoSprite.getElemento();
                break;
            case FANTA:
                aux = DepositoFanta.getElemento();
                break;
            case SUPER8:
                aux = DepositoSuper8.getElemento();
                break;
            case SNICKERS:
                aux = DepositoSnickers.getElemento();
                break;
            default:
                DepositoMonedas.addElemento(moneda);
                throw new NoHayProductoException();
        }

        if (aux == null) {
            DepositoMonedas.addElemento(moneda);
            throw new NoHayProductoException();
        }

        for (int i = 0; i < cantidadMonedas100; i++)
            DepositoMonedas.addElemento(new Moneda100());

        this.productoComprado = aux;
    }

    /**
     *
     * @return primera moneda en el deposito monedas
     */
    public Moneda getVuelto() {
        return DepositoMonedas.getElemento();
    }

    public Producto getProducto() {
        return productoComprado;
    }

    public Deposito<CocaCola> getDepositoCoca() {
        return DepositoCoca;
    }

    public Deposito<Sprite> getDepositoSprite() {
        return DepositoSprite;
    }

    public Deposito<Fanta> getDepositoFanta() {
        return DepositoFanta;
    }

    public Deposito<Super8> getDepositoSuper8() {
        return DepositoSuper8;
    }

    public Deposito<Snickers> getDepositoSnickers() {
        return DepositoSnickers;
    }

    public Deposito<Moneda> getDepositoMonedas() {
        return DepositoMonedas;
    }

    public Deposito<Moneda> getDepositoMonedasIngresadas() {
        return DepositoMonedasIngresadas;
    }
}
