package org.example;

/**
 * Implementa las monedas de 1000
 * @author Benjamin Espinoza
 */
class Moneda1000 extends Moneda {
    public Moneda1000() {
        super();
    }

    /**
     * retorna valor de la moneda
     * @return retorna el precio de 1000
     */
    @Override
    public int getValor() {
        return 1000;
    }
}
