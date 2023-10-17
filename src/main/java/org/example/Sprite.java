package org.example;

class Sprite extends Bebida {
    public Sprite(int serie) {
        super(serie);
    }

    public String consumir() {
        return "sprite";
    }

    @Override
    public String toString() {
        String answer = new String();
        answer += super.toString();
        answer += "Tipo de Bebida: CocaCola";
        return answer;
    }
}
