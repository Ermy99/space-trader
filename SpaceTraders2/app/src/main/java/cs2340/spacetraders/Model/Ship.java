package cs2340.spacetraders.Model;

import java.io.Serializable;

/**
 * Ship.java
 * Represents the player's ship.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class Ship implements Serializable {
    public final Cargo cargo;
    public shipType shipType;
    public int Fuel;
    //int cargoSize;
    //int cargoCapacity;
    
    /**
     * Ship constructor - creates a default ship when the game starts up.
     *
     */
    Ship() {
        this.shipType = shipType.GNAT;
        this.cargo = new Cargo(15);
    }
    
    /**
     * getshipType method - returns the ship type that the player has.
     *
     * @return the player's ship type
     */
    public shipType getshipType() {
        return shipType;
    }
    
    /**
     * setshipType method - sets a new ship as the player's ship.
     *
     * @param shipType the new shipType to provide the player.
     */
    public void setshipType(shipType shipType) {
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



    //create instance variable for each type of good that counts how many of each
    //type there are --> create getters

}
