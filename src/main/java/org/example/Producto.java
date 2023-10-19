package org.example;

/**
 * Clase abstract para implementar cada uno de los productos que se va a vender en la maquina expendedora.
 * @author Carlos Álvarez
 */
public abstract class Producto {
    private int serie;

    /**
     * Se pasa el numero de serie dado por el expendedor de manera arbitraria.
     * @param serie numero de serie de cada producto.
     */
    public Producto(int serie) {
        this.serie = serie;
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
}
