package org.example;

public class NoHayProductoException extends Exception{
    public NoHayProductoException() {

    }

    public NoHayProductoException(String message) {
        super(message);
    }
}
