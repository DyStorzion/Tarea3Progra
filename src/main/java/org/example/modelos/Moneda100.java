package org.example.modelos;

/**
 * Implementa las monedas de 100
 * @author Benjamin Espinoza
 */
public class Moneda100 extends Moneda {
    public Moneda100() {
        super();
    }

    /**
     * retorna valor de la moneda
     * @return retorna el precio de 100
     */
    @Override
    public int getValor() {
        return 100;
    }
}
