package cs2340.spacetraders.Model

import android.util.Log

import java.io.Serializable

/**
 * Goods.kt
 * Enum for the goods present in the game.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
enum class Goods
/**
 * Goods constructor - creates a good based on tech level
 *
 * @param code the name of the good
 * @param minTechLevelToProd minimum tech level to produce the good
 * @param minTechLevelToUse minimum tech level to use the good
 * @param techLevel the current tech level
 * @param basePrice the base price of the good
 * @param priceInc price increase of the good
 */
private constructor(
        /**
         * getCode method - returns the name of the good
         *
         * @return the name of the good
         */
        val code: String, private val minTechLevelToProd: Int, private val minTechLevelToUse: Int, private val techLevel: Int,
        private val basePrice: Int, private val priceInc: Int) {

    Water("Water", 0, 0, 2, 30, 3),
    Furs("Furs", 0, 0, 0, 250, 10),
    Food("Foods", 1, 0, 1, 100, 5),
    Ore("Ore", 2, 2, 3, 350, 20),
    Games("Games", 3, 1, 6, 250, -10),
    Firearms("Firearms", 3, 1, 5, 1250, -75),
    Medicine("Medicine", 4, 1, 6, 650, -20),
    Machines("Machines", 4, 3, 5, 900, -30),
    Narcotics("Narcotics", 5, 0, 5, 3500, -125),
    Robots("Robots", 6, 4, 7, 5000, -150);


    /**
     * getPrice method - returns the price of the good.
     *
     * @param level the level of the good
     * @return the price of the good
     */
    fun getPrice(level: Int): Int {
        return Math.abs(basePrice + 3 * 2 * priceInc * (level - minTechLevelToProd))
    }

    /**
     * canSell method - determines if you can sell a number of goods given the
     * player's cargo.
     *
     * @param good the good to sell
     * @param quantityToSell the quantity of the good to sell
     * @return whether the player can or cannot sell the good(s)
     */
    fun canSell(good: Goods, quantityToSell: Int): Boolean {
        val game = Game.instance
        for (c in game.getPlayer().shipCargo) {
            val goods = c.good
            if (goods == good
                    && quantityToSell <= c.quantity
                    && c.quantity > 0
                    && quantityToSell > 0) {
                return true
            }
        }

        return false
    }

    /**
     * canBuy method - determines whether the player can buy a number of goods
     * based on the player's number of credits
     *
     * @param good the good to buy
     * @param quantityToBuy the quantity of the good to buy
     * @return whether the player can or cannot buy the good(s)
     */
    fun canBuy(good: Goods, quantityToBuy: Int): Boolean {
        val game = Game.instance
        return Game.instance.getPlayer().credits > good.getPrice(game.tech) * quantityToBuy && game.cargoSize + quantityToBuy <= game.cargoCapacity
    }

    /**
     * buy method - executes the action of buying a number of goods.
     *
     * @param good the good to buy
     * @param quantityToBuy the number of goods to buy
     */
    fun buy(good: Goods, quantityToBuy: Int) {
        //Game game = Game.getInstance();
        if (canBuy(good, quantityToBuy)) {
            for (c in Game.instance.getPlayer().shipCargo) {
                val goods = c.good
                if (goods == good) {

                    c.quantity = c.quantity + quantityToBuy

                }
            }

            val playerCredits = Game.instance.getPlayer().credits
            Game.instance.getPlayer().credits = playerCredits - good.getPrice(Game.instance.solarSystemLevel) * quantityToBuy

        }

    }

    /**
     * sell method - executes the action of selling a number of goods.
     *
     * @param good the good to sell
     * @param quantityToSell the number of goods to sell
     */
    fun sell(good: Goods, quantityToSell: Int) {
        val game = Game.instance
        if (canSell(good, quantityToSell)) {
            for (c in game.getPlayer().shipCargo) {
                val goods = c.good
                if (goods == good) {
                    c.quantity = c.quantity - quantityToSell
                    val currentCredits = game.credits
                    game.getPlayer().credits = currentCredits + good.getPrice(game.solarSystemLevel)
                }
            }
        }
    }

    companion object {

        /**
         * pirateAttack method - executes action of pirate plundering the player's
         * cargo.
         *
         */
        fun pirateAttack() {
            val game = Game.instance
            val cargo = game.getPlayer().shipCargo
            for (c in cargo) {
                c.quantity = 0
            }
        }
    }

    // --Commented out by Inspection START (4/5/2019 8:24 PM):
    //    public int getMinTechLevelToProd() {
    //        return minTechLevelToProd;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:24 PM)

    // --Commented out by Inspection START (4/5/2019 8:24 PM):
    //    public void setMinTechLevelToProd(int minTechLevelToProd) {
    //        this.minTechLevelToProd = minTechLevelToProd;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:24 PM)

    // --Commented out by Inspection START (4/5/2019 8:24 PM):
    //    public int getMinTechLevelToUse() {
    //        return minTechLevelToUse;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:24 PM)

    // --Commented out by Inspection START (4/5/2019 8:24 PM):
    //    public void setMinTechLevelToUse(int minTechLevelToUse) {
    //        this.minTechLevelToUse = minTechLevelToUse;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:24 PM)

    // --Commented out by Inspection START (4/5/2019 8:24 PM):
    //    public int getTechLevel() {
    //        return techLevel;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:24 PM)

    // --Commented out by Inspection START (4/5/2019 8:24 PM):
    //    public void setTechLevel(int techLevel) {
    //        this.techLevel = techLevel;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:24 PM)

    // --Commented out by Inspection START (4/5/2019 8:24 PM):
    //    public int getBasePrice() {
    //        return basePrice;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:24 PM)

    // --Commented out by Inspection START (4/5/2019 8:24 PM):
    //    public void setBasePrice(int basePrice) {
    //        this.basePrice = basePrice;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:24 PM)

    // --Commented out by Inspection START (4/5/2019 8:24 PM):
    //    public int getPriceInc() {
    //        return priceInc;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:24 PM)

    // --Commented out by Inspection START (4/5/2019 8:24 PM):
    //    public void setPriceInc(int priceInc) {
    //        this.priceInc = priceInc;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:24 PM)


}
