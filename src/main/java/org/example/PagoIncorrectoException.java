package org.example;

/**
 * Esta excepcion se lanza al ingresar una moneda null al expendedor
 *
 * @author Carlos Alvarez
 */
public class PagoIncorrectoException extends Exception {

    /**
     * Constructor que define un mensaje personalizado
     * @param message mensaje personalizado que se muestra al lanzar la excepcion
     */
    public PagoIncorrectoException(String message){
        super(message);
    }

    /**
     * Constructor sin ningun parametro
     */
    public PagoIncorrectoException(){
    }
}
