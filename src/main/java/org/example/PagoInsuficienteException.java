package org.example;

/**
 * Esta excepcion se lanza cuando el precio de un producto es menor al valor de la moneda
 *
 * @author Carlos Alvarez
 */
public class PagoInsuficienteException extends Exception{

    /**
     * Constructor que define un mensaje personalizado
     * @param message mensaje personalizado que se muestra al lanzar la excepcion
     */
    public PagoInsuficienteException(String message) {
        super(message);
    }

    /**
     * Constructor sin ningun parametro
     */
    public PagoInsuficienteException() {
    }
}
