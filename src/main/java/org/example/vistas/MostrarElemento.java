package org.example.vistas;

import javax.swing.*;

public class MostrarElemento extends JPanel {
    private int x;
    private int y;

    public MostrarElemento(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}
