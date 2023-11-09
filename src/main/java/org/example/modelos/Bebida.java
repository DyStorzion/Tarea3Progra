package org.example.modelos;

/**
 *Clase Abstract con la que se espera que se implementen los distintos tipos de bebida.
 * @author Carlos Alvarez
 */
public abstract class Bebida extends Producto{
    /**
     *
     *
     */
    public Bebida() {
        super();
    }

    /**
     * Se crea el to string que se va a concatenar en cada clase que se le herede.
     * @return String base para cada toString de una bebida.
     */
    @Override
    public String toString() {
        return super.toString() + "Producto: Bebida\n";
    }
}
