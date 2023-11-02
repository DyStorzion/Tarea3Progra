package org.example.modelos;

import java.util.ArrayList;

/**
 * Objeto creado para almacenar distintos tipos de productos independiente de que sean.
 * Un deposito tiene solo un tipo de objeto.
 * @param <T> El objeto a almacenar.
 * @author Carlos Alvarez
 */
public class Deposito <T>{
    private ArrayList<T> almacen;

    /**
     * Se inicializa el array con lo que hay en el deposito.
     */
    public Deposito() {
        almacen = new ArrayList<T>();
    }

    /**
     * Funcion para añadir objetos al deposito.
     * @param elemento elemento a añadir.
     */

    public void addElemento(T elemento) {
        almacen.add(elemento);
    }

    /**
     * Se obtiene el elemento a sacar en un orden LIFO
     * Si no hay nada en el deposito retorna null
     * @return el elemento que corresponde a sacar.
     */
    public T getElemento() {
        if (almacen.size() == 0)
            return null;
        else {
            return almacen.remove(almacen.size() - 1);
        }
    }

    public int size(){
        return almacen.size();
    }
}
