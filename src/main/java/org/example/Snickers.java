package org.example;

public class Snickers extends Dulces{
    public Snickers(int serie) {
        super(serie);
    }

    @Override
    public String consumir() {
        String answer = new String();
        answer += super.toString();
        answer += "Tipo de Dulce: Snickers";
        return answer;
    }
}
