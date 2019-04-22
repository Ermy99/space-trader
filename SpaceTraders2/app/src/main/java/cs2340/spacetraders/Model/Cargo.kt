package cs2340.spacetraders.Model

import java.io.Serializable
import java.util.ArrayList

/**
 * Cargo.kt
 * Represents the player's cargo.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
class Cargo
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
(
        /**
         * getCargoCapacity method - returns the total capacity of the cargo.
         *
         * @return the capacity of the cargo
         */
        val cargoCapacity: Int) : Serializable {

    private val shipCargo: MutableList<CargoItem>

    /**
     * getCargoSize method - returns the number of items in the cargo.
     *
     * @return the number of items in the cargo
     */
    val cargoSize: Int
        get() {
            var returnVal = 0
            for (c in shipCargo) {
                returnVal += c.quantity
            }
            return returnVal
        }

    init {
        shipCargo = ArrayList()
        shipCargo.add(CargoItem(0, Goods.Water))
        shipCargo.add(CargoItem(0, Goods.Furs))
        shipCargo.add(CargoItem(0, Goods.Food))
        shipCargo.add(CargoItem(0, Goods.Ore))
        shipCargo.add(CargoItem(0, Goods.Games))
        shipCargo.add(CargoItem(0, Goods.Firearms))
        shipCargo.add(CargoItem(0, Goods.Medicine))
        shipCargo.add(CargoItem(0, Goods.Machines))
        shipCargo.add(CargoItem(0, Goods.Narcotics))
        shipCargo.add(CargoItem(0, Goods.Robots))
    }

    /**
     * getShipCargo method - returns the actual cargo object.
     *
     * @return the cargo object
     */
    fun getShipCargo(): List<CargoItem> {
        return shipCargo
    }

}
