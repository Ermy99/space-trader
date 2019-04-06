package cs2340.spacetraders.Model;

import java.io.Serializable;

public class CargoItem implements Serializable {
    public int quantity;
    public final Goods good;

    public CargoItem(int quantity, Goods good) {
        this.good = good;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Goods getGood() {
        return good;
    }

    public void setQuantity(int n) {
        this.quantity = n;
    }
}
