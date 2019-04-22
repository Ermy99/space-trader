package cs2340.spacetraders.Model

import java.io.Serializable

/**
 * Player.kt
 * Represents Player configuration data.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
class Player
/**
 * Player Constructor - creates a new player from configuration data.
 *
 * @param name the inputted name of the player
 * @param pilotPoints inputted pilot points
 * @param engineeringPoints inputted engineering points
 * @param traderPoints inputted trader points
 * @param fighterPoints inputted fighter points
 * @param solarSystems randomly generated solar systems
 */
(
        /**
         * getName method - returns player's name.
         *
         * @return player's name
         */
        val name: String,
        // --Commented out by Inspection START (4/5/2019 8:25 PM):
        //    public void setName(String name) {
        //        this.name = name;
        //    }
        // --Commented out by Inspection STOP (4/5/2019 8:25 PM)

        /**
         * getPilotPoints method - returns player's pilot points.
         *
         * @return player's pilot points
         */
        val pilotPoints: Int,
        // --Commented out by Inspection START (4/5/2019 8:25 PM):
        //    public void setPilotPoints(int pilotPoints) {
        //        this.pilotPoints = pilotPoints;
        //    }
        // --Commented out by Inspection STOP (4/5/2019 8:25 PM)

        /**
         * getEngineeringPoints method - returns player's engineering points.
         *
         * @return player's engineering points
         */
        val engineeringPoints: Int,
        // --Commented out by Inspection START (4/5/2019 8:25 PM):
        //    public void setEngineeringPoints(int engineeringPoints) {
        //        this.engineeringPoints = engineeringPoints;
        //    }
        // --Commented out by Inspection STOP (4/5/2019 8:25 PM)

        /**
         * getTraderPoints method - returns player's trader points.
         *
         * @return player's trader points
         */
        val traderPoints: Int,
        // --Commented out by Inspection START (4/5/2019 8:25 PM):
        //    public void setTraderPoints(int traderPoints) {
        //        this.traderPoints = traderPoints;
        //    }
        // --Commented out by Inspection STOP (4/5/2019 8:25 PM)

        /**
         * getFighterPoints method - returns player's fighter points.
         *
         * @return player's fighter points
         */
        val fighterPoints: Int,
        /**
         * getSolarSystems method - returns the solar systems and their coordinates.
         *
         * @return the game's solar systems and their coordinates
         */
        /**
         * setSolarSystems method - sets a new solar system to replace the existing
         * one.
         *
         * @param solarSystems the new solar systems to replace the existing one
         */
        var solarSystems: SolarSystems) : Serializable {
    // --Commented out by Inspection START (4/5/2019 8:25 PM):
    //    public void setFighterPoints(int fighterPoints) {
    //        this.fighterPoints = fighterPoints;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:25 PM)

    /**
     * getCredits method - returns the player's number of credits.
     *
     * @return number of credits the player has
     */
    /**
     * setCredits method - sets the player's credits to a new amount.
     *
     * @param credits the new number of credits to replace the old number
     */
    var credits: Int = 0
    /**
     * getShip method - returns the player's ship.
     *
     * @return the player's ship
     */
    val ship: Ship
    internal val shipType = ShipType.GNAT
    /**
     * getFuel method - returns the amount of fuel in the player's ship.
     *
     * @return the amount of fuel in the player's ship.
     */
    /**
     * setFuel method - sets a new value to the fuel in the player's ship.
     *
     * @param fuel the new amount of fuel in the player's ship.
     */
    var fuel = 1000

    /**
     * getSolarSystemName method - returns the name of the solar system
     *
     * @return name of the solar system
     */
    val solarSystemName: String
        get() = solarSystems.name

    /**
     * getShipCargo method - returns the entire ship cargo object
     *
     * @return the player's cargo object
     */
    val shipCargo: List<CargoItem>
        get() = ship.shipCargo

    /**
     * getCargo method - returns the cargo of the player.
     *
     * @return the player's cargo
     */
    val cargo: Cargo
        get() = ship.cargo

    /**
     * getCargoCapacity method - returns the player's cargo capacity.
     *
     * @return the player's cargo capacity
     */
    val cargoCapacity: Int
        get() = ship.cargoCapacity

    /**
     * getCargoSize method - returns the number of items
     * inside the ship's cargo.
     *
     * @return the size of the cargo
     */
    val cargoSize: Int
        get() = ship.cargoSize

    init {
        this.credits = 1000
        this.ship = Ship()
    }

}
