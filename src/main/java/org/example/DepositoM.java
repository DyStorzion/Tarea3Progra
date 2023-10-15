import java.util.ArrayList;

class DepositoM {
    private ArrayList<Moneda> arrm;

    public DepositoM() {
        arrm = new ArrayList<Moneda>();
    }

    public void addMoneda(Moneda m) {
        arrm.add(m);
    }

    public Moneda getMoneda() {
        if (arrm.size() == 0) return null;
        else {
            return arrm.remove(0);
        }
    }
}
