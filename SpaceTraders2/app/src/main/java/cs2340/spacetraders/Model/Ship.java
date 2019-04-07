package cs2340.spacetraders.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Ship.java
 * Represents the player's ship.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class Ship implements Serializable {
    private final Cargo cargo;
    private ShipType shipType;
    private int Fuel;
    //int cargoSize;
    //int cargoCapacity;

    /**
     * Ship constructor - creates a default ship when the game starts up.
     *
     */
    Ship() {
        this.shipType = ShipType.GNAT;
        this.cargo = new Cargo(15);
    }

    /**
     * getshipType method - returns the ship type that the player has.
     *
     * @return the player's ship type
     */
    public ShipType getshipType() {
        return shipType;
    }

    /**
     * setshipType method - sets a new ship as the player's ship.
     *
     * @param shipType the new shipType to provide the player.
     */
    public void setshipType(ShipType shipType) {
        this.shipType = shipType;
    }

// --Commented out by Inspection START (4/5/2019 8:26 PM):
//    public void setCargo() {
//        cargo = new Cargo(15);
//    }
// --Commented out by Inspection STOP (4/5/2019 8:26 PM)

//    public void setCargoSize() {
//        this.cargoSize = cargo.getCargoSize();
//    }

//    public int getCargoCapacity() {
//        return cargo.cargoCapacity;
//    }

//    public int getCargoSize() {
//        return cargo.getCargoSize();
//    }

    /**
     * getCargo method - returns the cargo object of the ship.
     *
     * @return the ship's cargo
     */
    public Cargo getCargo() {
        return cargo;
    }
    
    /**
     * getCargoCapacity method - returns the cargo's capacity.
     *
     * @return the capacity of the cargo
     */
    public int getCargoCapacity() {
        return cargo.getCargoCapacity();
    }
    
    /**
     * getCargoSize method - returns the size of the cargo.
     *
     * @return the number of items inside the ship's cargo
     */
    public int getCargoSize() {
        return cargo.getCargoSize();
    }
    
    /**
     * getShipCargo method - returns the cargo in the form of
     *                       a List<CargoItem>().
     *
     * @return a list of the items in the cargo
     */
    public List<CargoItem> getShipCargo() {
        return cargo.getShipCargo();
    }
    
    /**
     * setFuel method - sets a new value for the fuel in the ship
     *
     * @param fuelChange fuel to be added to the ship
     */
    public void setFuel(int fuelChange) {
        this.Fuel += fuelChange;
    }



    //create instance variable for each type of good that counts how many of each
    //type there are --> create getters

}
