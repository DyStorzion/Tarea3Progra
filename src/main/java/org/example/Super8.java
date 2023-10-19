package org.example;

/**
 *Tipo de dulce
 * @author Carlos Álvarez
 */

public class Super8 extends Dulces{
    /**
     * Se pasa el numero de serie de snickers.
     * @param serie numero de serie.
     */
    public Super8(int serie) {
        super(serie);
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
