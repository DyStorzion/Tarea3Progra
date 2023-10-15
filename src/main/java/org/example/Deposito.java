import java.util.ArrayList;

class Deposito {
    private ArrayList<Bebida> arrb;

    public Deposito() {
        arrb = new ArrayList<Bebida>();
    }

    public void addBebida(Bebida b) {
        arrb.add(b);
    }

    public Bebida getBebida() {
        if (arrb.size() == 0) return null;
        else {
            return arrb.remove(0);
        }
    }
}
