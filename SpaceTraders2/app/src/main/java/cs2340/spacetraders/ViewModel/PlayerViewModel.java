package cs2340.spacetraders.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.GameDifficulty;
import cs2340.spacetraders.Model.Player;
import cs2340.spacetraders.Model.SolarSystems;

/**
 * PlayerViewModel.java
 * Conveys Player view data to the model.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class PlayerViewModel extends AndroidViewModel {
    private Game game;
    private Player player;

    /**
     * PlayerViewModel Constructor - creates a new PlayerViewModel
     *
     * @param application the application passed in
     */
    public PlayerViewModel(@NonNull Application application) {
        super(application);

    }

    /**
     * createPlayer method - creates a new player from the configuration data.
     *
     * @param name the player's name
     * @param pilotPoints the player's pilot points
     * @param engineeringPoints the player's engineering points
     * @param traderPoints the player's trader points
     * @param fighterPoints the player's fighter points
     */
    public void createPlayer(String name,
                             int pilotPoints,
                             int engineeringPoints,
                             int traderPoints,
                             int fighterPoints) {

        player = new Player(name, pilotPoints, engineeringPoints,
                traderPoints, fighterPoints, SolarSystems.SOMEBI);
    }

    /**
     * getPlayer method - returns the player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * createGame method - creates a game from the player info and
     *                     game difficulty.
     *
     * @param player the player
     * @param gameDifficulty the game difficulty entered
     */
    public void createGame(Player player, GameDifficulty gameDifficulty) {
        game = Game.getInstance();
        game.setPlayer(player);
        //game.setGameDifficulty(gameDifficulty);
        //game.universe = new Universe();
    }

    /**
     * saveGame method - saves the game.
     *
     * @return whether the game is saved
     */
    public boolean saveGame() {
        boolean success = true;
        try {
            Log.d("APP" , "saving game");
            FileOutputStream outputStreamFile = getApplication().openFileOutput("spacetradersgame.ser", Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStreamFile);
            objectOutputStream.writeObject(Game.getInstance());
            objectOutputStream.close();
            outputStreamFile.close();
        } catch (Exception e) {
            success = false;
        }

        return success;
    }

    /**
     * loadSavedGame method - loads the saved game.
     *
     * @return whether the game loaded correctly.
     */
    public boolean loadSavedGame() {
        boolean success = true;
        try {
            FileInputStream file = getApplication().openFileInput("spacetradersgame.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(file);
            Game game = (Game) objectInputStream.readObject();
            objectInputStream.close();
            Game.getInstance().setGame(game);
        } catch (Exception e){
            success = false;
            Log.d("APP", "No game was loaded");

        }
        return success;
    }

    /**
     * onOK method - saves configuration data to Player object.
     *
     * @param name the player's name
     * @param pilotPoints the player's pilot points
     * @param engineeringPoints the player's engineering points
     * @param traderPoints the player's trader points
     * @param fighterPoints the player's fighter points
     * @return whether the inputted data is valid
     */
    public static boolean onOK(CharSequence name,
                               int pilotPoints,
                               int engineeringPoints,
                               int traderPoints,
                               int fighterPoints) {

        int totalpoints = pilotPoints + engineeringPoints + traderPoints + fighterPoints;
        return (name != null) && (name.length() > 0) && (totalpoints == 16);


    }



}
