package org.example.modelos;

/**
 *Tipo de dulce
 * @author Carlos Alvarez
 */

public class Super8 extends Dulces{
    /**
     *
     *
     */
    public Super8() {
        super();
    }

    /**
     * Implementacion de metodo consumir que entrega super 8.
     * @return devuelve string super 8.
     */
    public String consumir(){
        return "super 8";
    }

    /**
     * toString que entrega informaciones especificas de los super 8.
     * @return entrega informacion de super 8.
     */
    @Override
    public String toString() {
        String answer = new String();
        answer += super.toString();
        answer += "Tipo de Dulce: Super 8";
        return answer;
    }
}
