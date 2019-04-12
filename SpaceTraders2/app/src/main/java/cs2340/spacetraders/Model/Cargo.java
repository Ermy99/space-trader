package cs2340.spacetraders.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Cargo.java
 * Represents the player's cargo.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class Cargo implements Serializable {

    private final List<CargoItem> shipCargo;
    private final int cargoCapacity;
    
    /**
     * Cargo constructor - Constructs an empty cargo with:
     * - Water
     * - Furs
     * - Food
     * - Ore
     * - Games
     * - Firearms
     * - Medicine
     * - Machines
     * - Narcotics
     * - Robots
     *
     * @param cargoCapacity The capacity of the cargo, given by the ship type
     */
    public Cargo(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
        shipCargo = new ArrayList<>();
        shipCargo.add(new CargoItem(0, Goods.Water));
        shipCargo.add(new CargoItem(0, Goods.Furs));
        shipCargo.add(new CargoItem(0, Goods.Food));
        shipCargo.add(new CargoItem(0, Goods.Ore));
        shipCargo.add(new CargoItem(0, Goods.Games));
        shipCargo.add(new CargoItem(0, Goods.Firearms));
        shipCargo.add(new CargoItem(0, Goods.Medicine));
        shipCargo.add(new CargoItem(0, Goods.Machines));
        shipCargo.add(new CargoItem(0, Goods.Narcotics));
        shipCargo.add(new CargoItem(0, Goods.Robots));
    }
    
    /**
     * getCargoSize method - returns the number of items in the cargo.
     *
     * @return the number of items in the cargo
     */
    public int getCargoSize() {
        int returnVal = 0;
        for (CargoItem c: shipCargo) {
            returnVal +=  c.getQuantity();
        }
        return returnVal;
    }
    
    /**
     * getCargoCapacity method - returns the total capacity of the cargo.
     *
     * @return the capacity of the cargo
     */
    public int getCargoCapacity() {
        return cargoCapacity;
    }
    
    /**
     * getShipCargo method - returns the actual cargo object.
     *
     * @return the cargo object
     */
    public List<CargoItem> getShipCargo() {
        return Collections.unmodifiableList(shipCargo);
    }

}
