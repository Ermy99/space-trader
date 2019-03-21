package cs2340.spacetraders.Model;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class Game {

    private static final Game instance = new Game();
    public Player player;
    public GameDifficulty gameDifficulty;
    public Universe universe;
    public Market market;
    public int solarSystemLevel;
    public Ship ship;
    public Cargo cargo;
    public List<CargoItem> shipCargo;


    public static List<GameDifficulty> gameDifficulties = Arrays.asList(GameDifficulty.BEGINNER, GameDifficulty.EASY, GameDifficulty.NORMAL,
            GameDifficulty.HARD, GameDifficulty.IMPOSSIBLE);

    public Game() {
        //Log.d("Edit",this.toString());
        this.player = new Player(null,0,0,0,0,null);
        this.gameDifficulty = GameDifficulty.BEGINNER;
        this.universe = new Universe();
        this.market = new Market(null, null);
        this.solarSystemLevel = 1;
        this.ship = player.getShip();
        this.cargo = player.getShip().getCargo();
        this.shipCargo = cargo.getShipCargo();
    }


    public static Game getInstance() {
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        this.solarSystemLevel = player.getSolarSystems().ordinal();
        this.ship = player.getShip();
        this.cargo = ship.getCargo();
        this.shipCargo = cargo.getShipCargo();
    }

    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public void setGameDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    @Override
    public String toString() {
        return String.format("In this game, the player is %s with %d pilot points," +
                " %d engineer points, %d fighter points, %d trader points, and %d credits.",
                player.getName(), player.getPilotPoints(), player.getEngineeringPoints(),
                player.getFighterPoints(), player.getTraderPoints(), player.getCredits());
    }
}
