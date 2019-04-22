package cs2340.spacetraders.Model

/**
 * ShipType.kt
 * Enum of various ship types player can purchase in the game.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
enum class ShipType private constructor(

        val shipName: String,
        val cargoSize: Int,
        val parsecs: Int) {

    FLEA("Flea", 10, 20),
    GNAT("Gnat", 15, 14),
    FIREFLY("Firefly", 20, 17),
    MOSQUITO("Mosquito", 15, 13),
    BUMBLEBEE("Bumblebee", 25, 15),
    BEETLE("Beetle", 50, 14),
    HORNET("Hornet", 20, 16),
    GRASSHOPPER("Grasshopper", 30, 15),
    TERMITE("Termite", 60, 13),
    WASP("Wasp", 35, 14)

}
