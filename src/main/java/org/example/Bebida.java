package org.example;

abstract class Bebida extends Producto{

    public Bebida(int serie) {
        super(serie);
    }

    @Override
    public String toString() {
        return "Producto: Bebida\n";
    }
}
