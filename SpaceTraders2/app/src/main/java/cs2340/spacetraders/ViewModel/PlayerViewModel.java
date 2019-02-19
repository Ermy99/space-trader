package cs2340.spacetraders.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.widget.Toast;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.GameDifficulty;
import cs2340.spacetraders.Model.Model;
import cs2340.spacetraders.Model.Player;
import cs2340.spacetraders.View.ConfigurationActivity;
import android.widget.Toast;


public class PlayerViewModel extends AndroidViewModel {

    Game game;
    Player player;


    public PlayerViewModel(@NonNull Application application) {
        super(application);

    }

    public void createPlayer(String name, int pilotPoints, int engineeringPoints, int traderPoints,
                             int fighterPoints) {
        player = new Player(name, pilotPoints, engineeringPoints, traderPoints, fighterPoints);
    }

    public Player getPlayer() {
        return player;
    }

    public void createGame(Player player, GameDifficulty gameDifficulty) {
        game = new Game(player, gameDifficulty);
    }

    public static boolean onOK(String name, int pilotPoints, int engineeringPoints, int traderPoints,
                               int fighterPoints) {
        int totalpoints = pilotPoints + engineeringPoints + traderPoints + fighterPoints;
        if (name != null && name.length() > 0 && totalpoints == 16) {
            return true;
        } else {
            return false;
        }
    }



}
