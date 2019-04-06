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
import cs2340.spacetraders.Model.Universe;


public class PlayerViewModel extends AndroidViewModel {

    Game game;
    Player player;


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

    public static boolean onOK(CharSequence name, int pilotPoints, int engineeringPoints, int traderPoints,
                               int fighterPoints) {
        int totalpoints = pilotPoints + engineeringPoints + traderPoints + fighterPoints;
        return name != null && name.length() > 0 && totalpoints == 16;
    }



}
