package cs2340.spacetraders.Model;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class Game {

    public Player player;
    public GameDifficulty gameDifficulty;
    public Universe universe;
    public Market market;

    private static Game instance = new Game();


    public static List<GameDifficulty> gameDifficulties = Arrays.asList(GameDifficulty.BEGINNER, GameDifficulty.EASY, GameDifficulty.NORMAL,
            GameDifficulty.HARD, GameDifficulty.IMPOSSIBLE);

    public Game() {
        //Log.d("Edit",this.toString());
    }


    public static Game getInstance() {
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
