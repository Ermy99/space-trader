package cs2340.spacetraders.Model;

import java.io.Serializable;

/**
 * CargoItem.java
 * Represents a cargo item in the cargo
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class CargoItem implements Serializable {

    private int quantity;
    private final Goods good;

    /**
     * CargoItem constructor - Creates a cargo item object.
     *
     * @param quantity the number of cargo items to create and store
     * @param good the type of good to create.
     */

    public CargoItem(int quantity, Goods good) {
        this.good = good;
        this.quantity = quantity;
    }

    /**
     * getQuantity method - returns the quantity of the cargo good.
     *
     * @return the quantity of cargo good in the cargo
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * getGood method - returns the actual good
     *
     * @return the good itself in the cargo
     */
    public Goods getGood() {
        return good;
    }

    /**
     * setQuantity method - sets the new quantity of a type of cargo good, used
     * predominantly after selling and buying items.
     *
     * @param n the new quantity of a cargo item
     */
    public void setQuantity(int n) {
        this.quantity = n;
    }
    
    /**
     * getGoodCode method - returns the name of the good
     *
     * @return name of the good
     */
    public String getGoodCode() {
        return good.getCode();
    }
    
    /**
     * getGoodPrice method - returns the price of the good
     *
     * @return price of the good
     */
    public int getGoodPrice() {
        Game game = Game.getInstance();
        return good.getPrice(game.getTech());
    }


}
