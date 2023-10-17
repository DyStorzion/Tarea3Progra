package org.example;

public enum InfoProducto {
    COCA(1000, 1),
    FANTA(900, 2),
    SPRITE(800, 3),
    SNICKERS(400, 4),
    SUPER8(200, 5);

    private int precio;
    private int cualProducto;

    private InfoProducto(int precio, int cualProducto) {
        this.precio = precio;
        this.cualProducto = cualProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCualProducto() {
        return cualProducto;
    }
}
