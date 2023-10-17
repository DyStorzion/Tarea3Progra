package org.example;

public enum InfoProducto {
    COCA(1000),
    FANTA(900),
    SPRITE(800),
    SNICKERS(400),
    SUPER8(200);

    private int precio;

    private InfoProducto(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
    
}
