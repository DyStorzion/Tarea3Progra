package org.example.modelos;

/**
 * Se crea como tipo de producto los Dulces.
 * @author Carlos Alvarez
 */
public abstract class Dulces extends Producto{

    /**
     *
     *
     */
    public Dulces() {
        super();
    }

    /**
     * Se crea un toString base con la idea de que cada tipo de dulce llame a esta funcion en su implementacion
     * de toString y que la concantenen a sus casos especificos.
     * @return String generico para los dulces.
     */
    @Override
    public String toString() {
        return super.toString() + "Producto: Dulce\n";
    }
}
