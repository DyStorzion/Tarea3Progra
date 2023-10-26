package org.example.modelos;

/**
 * Implementa las monedas de 500
 * @author Benjamin Espinoza
 */
public class Moneda500 extends Moneda {
    public Moneda500() {
        super();
    }

    /**
     * retorna valor de la moneda
     * @return retorna el precio de 500
     */
    @Override
    public int getValor() {
        return 500;
    }
}
