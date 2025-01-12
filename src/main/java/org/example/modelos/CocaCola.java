package org.example.modelos;

/**
 * Clase para poder crear cocacolas que hereda de la clase Bebida.
 * @author Carlos Alvarez
 */
public class CocaCola extends Bebida {
    public CocaCola() {
        super();
    }

    /**
     * Cuando se consume devuelve CocaCola.
     * @return Retorna string con "cocacola"
     */
    public String consumir() {
        return "cocacola";
    }

    /**
     * Al toString de Bebida se le concatena informacion especifica de CocaCola.
     * @return String con informacion de CocaCola.
     */
    @Override
    public String toString() {
        String answer = new String();
        answer += super.toString();
        answer += "Tipo de Bebida: Cocacola";
        return answer;
    }
}
