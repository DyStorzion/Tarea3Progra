package org.example;

/**
 * Clase abstract para crear las distintas monedas con los respectivos precios que representan.
 * @author Benjamin Espinoza
 */
abstract class Moneda implements Comparable<Moneda> {
    public Moneda() {
    }

    /**
     * Se obtiene el numero de serie de la moneda que seria la referencia al objeto
     * @return La referencia al objeto.
     */
    public Moneda getSerie() {
        return this;
    }

    /**
     * Metodo abstract en que se espera que las clases que le hereden devuelvan el precio de la moneda.
     * @return devuelve el valor de la moneda.
     */
    public abstract int getValor();

    /**
     * Metodo para poder comparar 2 monedas de distinto valor.
     * Compara la moneda con otra retornando 1 si es mayor, 0 si tienen el mismo valor y -1 si es menor que.
     * @param moneda La moneda con la que se va a comparar.
     * @return resultado de la comparacion.
     */
    @Override
    public int compareTo(Moneda moneda) {
        if(this.getValor() > moneda.getValor()){
            return 1;
        }
        else if (this.getValor() == moneda.getValor()){
            return 0;
        }
        else {
            return -1;
        }
    }

    /**
     * Entrega informacion sobre la moneda en cuestion.
     * @return retorna string en que se dice el precio de la moneda.
     */
    @Override
    public String toString() {
        return "Esta moneda vale " + this.getValor() + " pesos y tiene como numero de referencia: " + this.getSerie();
    }
}
