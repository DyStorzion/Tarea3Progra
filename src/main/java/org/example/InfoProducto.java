package org.example;

public enum InfoProducto {
    COCA("cocacola", 1),FANTA("fanta", 2),
    SPRITE("sprite", 3),SNICKERS("snickers", 4),
    SUPER8("super8", 5);

    private String sabor;
    private int cualProducto;

    private InfoProducto(String sabor, int cualProducto) {
        this.sabor = sabor;
        this.cualProducto = cualProducto;
    }

    public String getSabor() {
        return sabor;
    }

    public int getCualProducto() {
        return cualProducto;
    }
}
