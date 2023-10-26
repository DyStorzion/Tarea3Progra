package org.example.modelos;

/**
 * Clase para poder crear fantas que hereda de la clase Bebida.
 * @author Carlos Alvarez
 */
public class Fanta extends Bebida{
    public Fanta(int serie) {
        super(serie);
    }

    /**
     * Cuando se consume devuelve fanta.
     * @return Retorna string con "fanta"
     */
    public String consumir() {
        return "fanta";
    }

    /**
     * Al toString de Bebida se le concatena informacion especifica de fanta.
     * @return String con informacion de fanta.
     */
    @Override
    public String toString() {
        String answer = new String();
        answer += super.toString();
        answer += "Tipo de Bebida: Fanta";
        return answer;
    }
}
