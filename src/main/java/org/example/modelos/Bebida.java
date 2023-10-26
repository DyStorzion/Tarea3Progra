package org.example.modelos;

/**
 *Clase Abstract con la que se espera que se implementen los distintos tipos de bebida.
 * @author Carlos Alvarez
 */
public abstract class Bebida extends Producto{
    /**
     * Se pasa el numero de serie dado por el expendedor de manera arbitraria.
     * @param serie numero de serie de cada bebida.
     */
    public Bebida(int serie) {
        super(serie);
    }

    /**
     * Se crea el to string que se va a concatenar en cada clase que se le herede.
     * @return String base para cada toString de una bebida.
     */
    @Override
    public String toString() {
        return "Producto: Bebida\n";
    }
}
