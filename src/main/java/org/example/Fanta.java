package org.example;

public class Fanta extends Bebida{
    public Fanta(int serie) {
        super(serie);
    }

    public String consumir() {
        return "fanta";
    }

    @Override
    public String toString() {
        String answer = new String();
        answer += super.toString();
        answer += "Tipo de Bebida: Fanta";
        return answer;
    }
}
