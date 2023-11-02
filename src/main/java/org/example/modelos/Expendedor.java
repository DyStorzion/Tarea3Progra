package org.example.modelos;

/**
 * Clase para crear un expendedor con los distintos depositos y metodos para comprar y conseguir el vuelto
 *
 * @author Benjamin Espinoza
 */
public class Expendedor {
    private Deposito<CocaCola> coca;
    private Deposito<Sprite> sprite;
    private Deposito<Fanta> fanta;
    private Deposito<Super8> super8;
    private Deposito<Snickers> snickers;
    private Deposito<Moneda> monedas;
    private Deposito<Moneda> monedasIngresadas;
    private Producto productoComprado;

    /**
     * Constructor que inicializa los depositos con la cantidad de bebidas indicada
     * @param n numero de bebidas que se ingresan en los depositos
     */
    public Expendedor(int n) {
        coca = new Deposito<CocaCola>();
        sprite = new Deposito<Sprite>();
        fanta = new Deposito<Fanta>();
        super8 = new Deposito<Super8>();
        snickers = new Deposito<Snickers>();
        monedas = new Deposito<Moneda>();
        monedasIngresadas = new Deposito<Moneda>();
        for (int i = 0; i < n; i++) {
            coca.addElemento(new CocaCola(100 + i));
            sprite.addElemento(new Sprite(200 + i));
            fanta.addElemento(new Fanta(300 + i));
            super8.addElemento(new Super8(400 + i));
            snickers.addElemento(new Snickers(500 + i));
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
            monedas.addElemento(moneda);
            throw new PagoInsuficienteException();
        }
        monedasIngresadas.addElemento(moneda);

        int cantidadMonedas100 = (moneda.getValor() - opcionProducto.getPrecio()) / 100;
        Producto aux = null;
        switch (opcionProducto) {
            case COCA:
                aux = coca.getElemento();
                break;
            case SPRITE:
                aux = sprite.getElemento();
                break;
            case FANTA:
                aux = fanta.getElemento();
                break;
            case SUPER8:
                aux = super8.getElemento();
                break;
            case SNICKERS:
                aux = snickers.getElemento();
                break;
            default:
                monedas.addElemento(moneda);
                throw new NoHayProductoException();
        }

        if (aux == null) {
            monedas.addElemento(moneda);
            throw new NoHayProductoException();
        }

        for (int i = 0; i < cantidadMonedas100; i++)
            monedas.addElemento(new Moneda100());

        this.productoComprado = aux;
    }

    /**
     *
     * @return primera moneda en el deposito monedas
     */
    public Moneda getVuelto() {
        return monedas.getElemento();
    }

    public Producto getProducto() {
        return productoComprado;
    }
}
