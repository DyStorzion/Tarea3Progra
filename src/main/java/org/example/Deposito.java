package org.example;

import java.util.ArrayList;

class Deposito <T>{
    private ArrayList<T> almacen;

    public Deposito() {
        almacen = new ArrayList<T>();
    }

    public void addElemento(T elemento) {
        almacen.add(elemento);
    }

    public T getElemento() {
        if (almacen.size() == 0)
            return null;
        else {
            return almacen.remove(0);
        }
    }
}
