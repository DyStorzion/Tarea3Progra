package org.example.modelos;

/**
 * Se crea como tipo de producto los Dulces.
 * @author Carlos Alvarez
 */
public abstract class Dulces extends Producto{

    /**
     * Se entrega numero de serie del dulce.
     * @param serie numero de serie.
     */
    public Dulces(int serie) {
        super(serie);
    }

    /**
     * Se crea un toString base con la idea de que cada tipo de dulce llame a esta funcion en su implementacion
     * de toString y que la concantenen a sus casos especificos.
     * @return String generico para los dulces.
     */
    @Override
    public String toString() {
        return "Producto: Dulces\n";
    }
}
