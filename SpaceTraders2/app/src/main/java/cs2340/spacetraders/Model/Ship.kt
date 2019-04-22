package cs2340.spacetraders.Model

import java.io.Serializable

/**
 * Ship.kt
 * Represents the player's ship.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
class Ship
//int cargoSize;
//int cargoCapacity;

/**
 * Ship constructor - creates a default ship when the game starts up.
 *
 */
internal constructor() : Serializable {
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
    val cargo: Cargo
    private var shipType: ShipType? = null
    private var Fuel: Int = 0

    /**
     * getCargoCapacity method - returns the cargo's capacity.
     *
     * @return the capacity of the cargo
     */
    val cargoCapacity: Int
        get() = cargo.cargoCapacity

    /**
     * getCargoSize method - returns the size of the cargo.
     *
     * @return the number of items inside the ship's cargo
     */
    val cargoSize: Int
        get() = cargo.cargoSize

    /**
     * getShipCargo method - returns the cargo in the form of
     * a List<CargoItem>().
     *
     * @return a list of the items in the cargo
    </CargoItem> */
    val shipCargo: List<CargoItem>
        get() = cargo.getShipCargo()

    init {
        this.shipType = ShipType.GNAT
        this.cargo = Cargo(15)
    }

    /**
     * getshipType method - returns the ship type that the player has.
     *
     * @return the player's ship type
     */
    fun getshipType(): ShipType? {
        return shipType
    }

    /**
     * setshipType method - sets a new ship as the player's ship.
     *
     * @param shipType the new shipType to provide the player.
     */
    fun setshipType(shipType: ShipType) {
        this.shipType = shipType
    }

    /**
     * setFuel method - sets a new value for the fuel in the ship
     *
     * @param fuelChange fuel to be added to the ship
     */
    fun setFuel(fuelChange: Int) {
        this.Fuel += fuelChange
    }


    //create instance variable for each type of good that counts how many of each
    //type there are --> create getters

}
