package cs2340.spacetraders.Model

import android.annotation.SuppressLint

import java.io.Serializable
import java.util.Arrays

/**
 * Game.kt
 * Represents the actual game.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
class Game : Serializable {
    private var player: Player
    // --Commented out by Inspection (4/5/2019 8:23 PM):public GameDifficulty gameDifficulty;
    // --Commented out by Inspection (4/5/2019 8:22 PM):public Universe universe;

    private var solarSystems: SolarSystems? = null
    var solarSystemLevel: Int = 0
    private var ship: Ship? = null
    private var cargo: Cargo? = null
    var shipCargo: List<CargoItem>

    /**
     * getCredits method - returns the number of credits
     * belonging to the player.
     *
     * @return player's number of credits
     */
    val credits: Int
        get() = player.credits

    /**
     * getSolarSystemName method - returns the solar system name
     *
     * @return solar system name
     */
    val solarSystemName: String
        get() = player.solarSystems.name

    /**
     * getShipName method - returns the ship name
     *
     * @return ship name
     */
    val shipName: String
        get() = player.shipType.shipName

    /**
     * getCargoCapacity method - returns the cargo capacity
     *
     * @return player's cargo capacity
     */
    val cargoCapacity: Int
        get() = player.cargoCapacity

    /**
     * getCargoSize method - returns the cargo size
     *
     * @return number of items player has inside the cargo
     */
    val cargoSize: Int
        get() = player.cargoSize

    /**
     * getTech method - returns the tech level of the solar system.
     *
     * @return solar system's tech level
     */
    val tech: Int
        get() {
            val techLevel = player.solarSystems.tech
            return techLevel!!.ordinal
        }

    /**
     * getSolarSystemsName method - returns the solar system's name.
     *
     * @return player's location solar system
     */
    val solarSystemsName: String
        get() = player.solarSystemName

    /**
     * Game constructor - creates a new game from the inputted user config.
     *
     */
    init {
        //Log.d("Edit",this.toString());
        this.player = Player(
                "", 0, 0, 0, 0, SolarSystems.ADI)
        //this.gameDifficulty = GameDifficulty.BEGINNER;
        //this.universe = new Universe();
        this.solarSystemLevel = 1
        this.ship = player.ship
        this.cargo = player.cargo
        //this.location = player.getSolarSystems();
        this.shipCargo = cargo!!.getShipCargo()
    }

    /**
     * getPlayer method - returns the player object associated with the game.
     *
     * @return the player object
     */
    fun getPlayer(): Player {
        return player
    }

    /**
     * setPlayer method - sets a new player to be associated with
     * the game object, and associates new statistics with
     * the player object
     *
     * @param player the new player object to be associated with the game class
     */
    fun setPlayer(player: Player) {
        this.player = player
        this.solarSystems = player.solarSystems
        this.solarSystemLevel = solarSystems!!.ordinal
        this.ship = player.ship
        this.cargo = ship!!.cargo
        this.shipCargo = cargo!!.getShipCargo()
    }


    /**
     * setGame method - sets the instance of a game to the original instance
     * of the game.
     *
     * @param g the new game object to replace the existing instance of game
     */

    fun setGame(g: Game) {
        instance = g
    }


    @SuppressLint("DefaultLocale")
    override fun toString(): String {
        return String.format("In this game, the player is %s with %d pilot points," + " %d engineer points, %d fighter points, %d trader points, and %d credits.",
                player.name, player.pilotPoints, player.engineeringPoints,
                player.fighterPoints, player.traderPoints, player.credits)
    }

    companion object {

        /**
         * getInstance method - Game is a singleton, so game will call on an
         * already existing instance of the Game class.
         *
         * @return the already-existing instance of Game
         */
        @JvmStatic
        var instance = Game()
            private set

        val gameDifficulties = Arrays.asList(
                GameDifficulty.BEGINNER,
                GameDifficulty.EASY,
                GameDifficulty.NORMAL,
                GameDifficulty.HARD,
                GameDifficulty.IMPOSSIBLE)


    }

//        val gameDifficulties = Arrays.asList(
//                GameDifficulty.BEGINNER,
//                GameDifficulty.EASY,
//                GameDifficulty.NORMAL,
//                GameDifficulty.HARD,
//                GameDifficulty.IMPOSSIBLE)

}
