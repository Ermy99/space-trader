package cs2340.spacetraders.Model;

public class CargoItem {
    public int quantity;
    public Goods good;

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
}
