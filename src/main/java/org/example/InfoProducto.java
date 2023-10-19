package org.example;

/**
 * Enumeracion para representar las opciones de las maquinas como sus precios.
 * @author Carlos Álvarez
 */
public enum InfoProducto {
    /**
     * Opciones de la máquina.
     */
    COCA(1000),
    FANTA(900),
    SPRITE(800),
    SNICKERS(400),
    SUPER8(200);

    private int precio;

    /**
     * Constructor de la clase.
     * @param precio precio para un determinado producto.
     */
    private InfoProducto(int precio) {
        this.precio = precio;
    }

    /**
     * Se obtiene el precio del producto en particular.
     * @return Devuelve el precio.
     */
    public int getPrecio() {
        return precio;
    }
    
}
