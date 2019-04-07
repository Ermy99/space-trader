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


public class PlayerViewModel extends AndroidViewModel {

    private Game game;
    private Player player;


    public PlayerViewModel(@NonNull Application application) {
        super(application);

    }

    public void createPlayer(String name, int pilotPoints, int engineeringPoints, int traderPoints,
                             int fighterPoints) {
        player = new Player(name, pilotPoints, engineeringPoints, traderPoints, fighterPoints, SolarSystems.SOMEBI);
    }

    public Player getPlayer() {
        return player;
    }

    public void createGame(Player player, GameDifficulty gameDifficulty) {
        game = Game.getInstance();
        game.setPlayer(player);
        //game.setGameDifficulty(gameDifficulty);
        //game.universe = new Universe();
    }

    public void saveGame() {
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

    }

    public void loadSavedGame() {
        boolean success = true;
        try {
            FileInputStream file = getApplication().openFileInput("spacetradersgame.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(file);
            objectInputStream.close();
            Game game = Game.getInstance();
            game.setGame((Game) objectInputStream.readObject());
        } catch (Exception e){
            success = false;
            Log.d("APP", "No game was loaded");

        }
    }

    public static boolean onOK(CharSequence name, int pilotPoints, int engineeringPoints, int traderPoints,
                               int fighterPoints) {
        int totalpoints = pilotPoints + engineeringPoints + traderPoints + fighterPoints;
        return (name != null) && (name.length() > 0) && (totalpoints == 16);
    }



}
