package cs2340.spacetraders.Model

import java.io.Serializable

/**
 * CargoItem.kt
 * Represents a cargo item in the cargo
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
class CargoItem
/**
 * CargoItem constructor - Creates a cargo item object.
 *
 * @param quantity the number of cargo items to create and store
 * @param good the type of good to create.
 */
(
        /**
         * getQuantity method - returns the quantity of the cargo good.
         *
         * @return the quantity of cargo good in the cargo
         */
        /**
         * setQuantity method - sets the new quantity of a type of cargo good, used
         * predominantly after selling and buying items.
         *
         * @param n the new quantity of a cargo item
         */
        var quantity: Int,

        /**
         * getGood method - returns the actual good
         *
         * @return the good itself in the cargo
         */
        val good: Goods) : Serializable {

    /**
     * getGoodCode method - returns the name of the good
     *
     * @return name of the good
     */
    val goodCode: String
        get() = good.code

    /**
     * getGoodPrice method - returns the price of the good
     *
     * @return price of the good
     */
    val goodPrice: Int
        get() {
            val game = Game.instance
            return good.getPrice(game.tech)
        }


}
