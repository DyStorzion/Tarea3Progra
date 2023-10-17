package org.example;

abstract class Moneda implements Comparable<Moneda> {
    public Moneda() {
    }

    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();

    @Override
    public int compareTo(Moneda moneda) {
        if(this.getValor() > moneda.getValor()){
            return 1;
        }
        else if (this.getValor() == moneda.getValor()){
            return 0;
        }
        else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Esta moneda vale " + this.getValor() + "pesos";
    }
}
