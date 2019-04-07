package cs2340.spacetraders.Model;

import android.annotation.SuppressLint;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Game.java
 * Represents the actual game.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class Game implements Serializable {

    private static Game instance = new Game();
    public Player player;
    // --Commented out by Inspection (4/5/2019 8:23 PM):public GameDifficulty gameDifficulty;
    // --Commented out by Inspection (4/5/2019 8:22 PM):public Universe universe;

    private SolarSystems solarSystems;
    public int solarSystemLevel;
    private Ship ship;
    private Cargo cargo;
    public List<CargoItem> shipCargo;


    public static final List<GameDifficulty> gameDifficulties = Arrays.asList(GameDifficulty.BEGINNER,
            GameDifficulty.EASY, GameDifficulty.NORMAL, GameDifficulty.HARD,
            GameDifficulty.IMPOSSIBLE);

    /**
     * Game constructor - creates a new game from the inputted user config.
     *
     */
    public Game() {
        //Log.d("Edit",this.toString());
        this.player = new Player(null,0,0,0,0,null);
        //this.gameDifficulty = GameDifficulty.BEGINNER;
        //this.universe = new Universe();
        this.solarSystemLevel = 1;
        this.ship = player.getShip();
        this.cargo = player.getCargo();
        //this.location = player.getSolarSystems();
        this.shipCargo = cargo.getShipCargo();
    }

    /**
     * getInstance method - Game is a singleton, so game will call on an
     *                      already existing instance of the Game class.
     *
     * @return the already-existing instance of Game
     */
    public static Game getInstance() {
        return instance;
    }

    /**
     * getPlayer method - returns the player object associated with the game.
     *
     * @return the player object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * setPlayer method - sets a new player to be associated with
     *                    the game object, and associates new statistics with
     *                    the player object
     *
     * @param player the new player object to be associated with the game class
     */
    public void setPlayer(Player player) {
        this.player = player;
        this.solarSystems = player.solarSystems;
        this.solarSystemLevel = solarSystems.ordinal();
        this.ship = player.getShip();
        this.cargo = ship.getCargo();
        this.shipCargo = cargo.getShipCargo();
    }

    public int getCredits() {
        return player.getCredits();
    }

    public String getSolarSystemName() {
        return player.solarSystems.getName();
    }

    public String getShipName() {
        return player.shiptype.getName();
    }

    public int getCargoCapacity() {
        return player.getCargoCapacity();
    }

    public int getCargoSize() {
        return player.getCargoSize();
    }

    public int getTech() {
        TechLevel techLevel = player.solarSystems.getTech();
        return techLevel.ordinal();
    }

    public String getSolarSystemsName() {
        return player.getSolarSystemName();
    }


    /**
     * setGame method - sets the instance of a game to the original instance
     *                  of the game.
     *
     * @param g the new game object to replace the existing instance of game
     */
>>>>>>>>> Temporary merge branch 2
    public void setGame(Game g) {
        this.instance = g;
    }


    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return String.format("In this game, the player is %s with %d pilot points," +
                " %d engineer points, %d fighter points, %d trader points, and %d credits.",
                player.getName(), player.getPilotPoints(), player.getEngineeringPoints(),
                player.getFighterPoints(), player.getTraderPoints(), player.getCredits());
    }
}
