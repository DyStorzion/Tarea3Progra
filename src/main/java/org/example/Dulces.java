package org.example;

public abstract class Dulces extends Producto{
    public Dulces(int serie) {
        super(serie);
    }

    @Override
    public String toString() {
        return "Producto: Dulces";
    }
}
