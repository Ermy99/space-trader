package cs2340.spacetraders.Model

import java.io.Serializable
import java.util.ArrayList

import java.util.Random

/**
 * SolarSystems.kt
 * Enum of various solar systems the player can travel to.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
enum class SolarSystems private constructor(
        /**
         * getName method - returns the name of the solar system.
         *
         * @return the name of the solar system
         */
        /**
         * setName method - sets a new name for the solar system.
         *
         * @param name the new name to set for the solar system
         */
        var solarSystemName: String?) {

    ADDAM("Addam"),
    ADI("Adi"),
    DEBO("Debo"),
    ERMIL("Ermil"),
    GHAVI("Ghavi"),
    SHALKA("Shalka"),
    SHIBI("Shibi"),
    SOMEBI("Somebi"),
    TAOFI("Taofi"),
    WEZIHIR("Wezihir")
    ;



    /**
     * getX method - returns the x coordinate of the solar system.
     *
     * @return the x coordinate of the solar system
     */
    /**
     * setX method - sets a new value for the x coordinate for the solar system.
     *
     * @param x the new x coordinate
     */
    var x: Int = 0
    /**
     * getY method - returns the y coordinate of the solar system.
     *
     * @return the y coordinate of the solar system
     */
    /**
     * setY method - sets a new value for the y coordinate for the solar system.
     *
     * @param y the new y coordinate
     */
    var y: Int = 0
    /**
     * getResource method - returns the resource most abundant in the solar
     * system.
     *
     * @return solar system's resource
     */
    /**
     * setResource method - sets the solar system's abundant resource.
     *
     * @param resource a new resource to be set to the solar system
     */
    var resource: Resource? = null
    /**
     * getTech method - returns the tech level of the solar system.
     *
     * @return solar system's tech level
     */
    /**
     * setTech method - sets the tech level of the solar system.
     *
     * @param tech new tech level to assign to a solar system
     */
    var tech: TechLevel? = null
    private val government: PoliticalSystem
    private val xVals = ArrayList<Int>(150)
    private val yVals = ArrayList<Int>(100)
    internal var distance: Double? = null


    init {

        val rng = Random()
        val coordinates = Coordinates()
        this.x = coordinates.getxVals()[ordinal]
        this.y = coordinates.getyVals()[ordinal]
        this.resource = Resource.values()[rng.nextInt(13)]
        this.tech = TechLevel.values()[rng.nextInt(8)]
        this.government = PoliticalSystem.values()[rng.nextInt(17)]

    }

    /**
     * setXY method - sets new values for the x and y coordinates of the solar
     * system.
     *
     * @param x the new x coordinate
     * @param y the new y coordinate
     */
    fun setXY(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    /**
     * canTravel method - returns whether the solar system selected by the
     * player can be reached.
     *
     * @param solarSystems destination solar system
     * @return whether the player can reach the target solar system
     */
    fun canTravel(solarSystems: SolarSystems): Boolean {
        val game = Game.instance
        val Distance = Distance(solarSystems)
        //val currentLocation = game.getPlayer().solarSystems

        return Distance < game.getPlayer().fuel
    }

    /**
     * Distance method - determines the distance between the current solar
     * system and the destination solar system.
     *
     * @param solarSystems the destination solar system
     * @return the distance between the two systems
     */
    fun Distance(solarSystems: SolarSystems): Int {
        val game = Game.instance
        val currentLocation = game.getPlayer().solarSystems
        return Math.round(Math.pow(Math.pow((solarSystems.x - currentLocation.x).toDouble(), 2.0) + Math.pow((solarSystems.y - currentLocation.y).toDouble(), 2.0), 0.5)).toInt()
    }

    /**
     * changeLocation method - executes the action of travelling to the new
     * solar system.
     *
     * @param solarSystems target solar system
     */
    fun changeLocation(solarSystems: SolarSystems) {
        if (canTravel(solarSystems)) {
            val fuelToTravel = Distance(solarSystems)
            val currentFuel = Game.instance.getPlayer().fuel
            Game.instance.getPlayer().fuel = currentFuel - fuelToTravel
            Game.instance.getPlayer().solarSystems = solarSystems
        }
    }

    /**
     * getDistance method - returns the distance between the current solar
     * system and the destination solar system.
     *
     * @param solarSystems destination solar system
     * @return the distance between the two systems.
     */
    fun getDistance(solarSystems: SolarSystems): Int {
        return Distance(solarSystems)
    }


    override fun toString(): String {
        return String.format(
                "%s at (%d, %d) with %s resources and " + "%s tech level, with an %s government.",
                name, x, y, resource!!.toString(),
                tech!!.toString(), government.toString())
    }


}