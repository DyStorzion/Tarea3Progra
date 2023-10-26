package org.example.modelos;

/**
 * Clase para poder crear sprites que hereda de la clase Bebida.
 * @author Carlos Alvarez
 */
public class Sprite extends Bebida {
    public Sprite(int serie) {
        super(serie);
    }

    /**
     * Cuando se consume devuelve sprite.
     * @return Retorna string con "sprite"
     */
    public String consumir() {
        return "sprite";
    }

    /**
     * Al toString de Bebida se le concatena informacion especifica de sprite.
     * @return String con informacion de sprite.
     */
    @Override
    public String toString() {
        String answer = new String();
        answer += super.toString();
        answer += "Tipo de Bebida: Sprite";
        return answer;
    }
}
