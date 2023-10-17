package org.example;

public class Super8 extends Dulces{
    public Super8(int serie) {
        super(serie);
    }

    public String consumir(){
        return "snickers";
    }

    @Override
    public String toString() {
        String answer = new String();
        answer += super.toString();
        answer += "Tipo de Dulce: Super 8";
        return answer;
    }
}
