package org.example.modelos;

/**
 *Tipo de dulce
 * @author Carlos Alvarez
 */
public class Snickers extends Dulces{

    /**
     * Se pasa el numero de serie de snickers.
     * @param serie numero de serie.
     */
    public Snickers() {
        super();
    }

    /**
     * Implementacion de metodo consumir que entrega snickers.
     * @return devuelve string snickers.
     */
    @Override
    public String consumir() {
        return "snickers";
    }

    /**
     * toString que entrega informaciones especificas de los snickers
     * @return entrega informacion de snickers.
     */
    @Override
    public String toString() {
        String answer = new String();
        answer += super.toString();
        answer += "Tipo de Dulce: Snickers";
        return answer;
    }
}
