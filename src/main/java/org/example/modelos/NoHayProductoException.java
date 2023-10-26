package org.example.modelos;

/**
 * Esta excepcion se lanza si no hay producto o se elige una opcion incorrecta de producto
 *
 * @author Carlos Alvarez
 */
public class NoHayProductoException extends Exception{

    /**
     * Constructor que define un mensaje personalizado
     * @param message mensaje personalizado que se muestra al lanzar la excepcion
     */
    public NoHayProductoException(String message) {
        super(message);
    }

    /**
     * Constructor sin ningun parametro
     */
    public NoHayProductoException() {}
}
