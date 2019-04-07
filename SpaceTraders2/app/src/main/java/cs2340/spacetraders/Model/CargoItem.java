package cs2340.spacetraders.Model;

import java.io.Serializable;

public class CargoItem implements Serializable {
    public int quantity;
    private final Goods good;

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

    public String getGoodCode() {
        return good.getCode();
    }

    public int getGoodPrice() {
        Game game = Game.getInstance();
        return good.getPrice(game.getTech());
    }

    public void setQuantity(int n) {
        this.quantity = n;
    }
}
