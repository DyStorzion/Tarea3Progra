package org.example;

class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }

    public String consumir() {
        return "cocacola";
    }

    @Override
    public String toString() {
        String answer = new String();
        answer += super.toString();
        answer += "Tipo de Bebida: Sprite";
        return answer;
    }
}
