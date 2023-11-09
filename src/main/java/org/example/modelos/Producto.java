package org.example.modelos;

/**
 * Clase abstract para implementar cada uno de los productos que se va a vender en la maquina expendedora.
 * @author Carlos Alvarez
 */
public abstract class Producto {
    private int serie;
    private static int SERIE = 0;

    /**
     * Se pasa el numero de serie dado por el expendedor de manera arbitraria.
     */
    public Producto() {
        Producto.SERIE++;
        this.serie = Producto.SERIE;
    }

    /**
     * Cada producto se tiene que consumir de alguna manera. Este va a retornar un string cuando se consuma.
     * Cada clase lo implementa con un string que estime conveniente.
     * @return Devuelve el string asociado al producto.
     */
    public abstract String consumir();

    /**
     * Metodo getter del numero de serie del producto.
     * @return Devuelve numero de serie.
     */
    public int getSerie() {
        return serie;
    }

    @Override
    public String toString() {
        return "Numero de serie: " + getSerie() + "\n";
    }
}
