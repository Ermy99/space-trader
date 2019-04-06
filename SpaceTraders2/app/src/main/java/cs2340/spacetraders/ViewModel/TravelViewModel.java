package cs2340.spacetraders.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import java.util.Random;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.Model.Player;
import cs2340.spacetraders.Model.SolarSystems;

public class TravelViewModel extends AndroidViewModel {
    final Game game;

    public TravelViewModel(Application application) {
        super(application);
        this.game = Game.getInstance();
    }

    public boolean canTravel(SolarSystems solarSystems) {
        return solarSystems.canTravel(solarSystems);
    }

    public void travel(SolarSystems solarSystems) {
        if (solarSystems.canTravel(solarSystems)) {
            solarSystems.changeLocation(solarSystems);
        }
    }

    public int randomEvent() {
        Random rand = new Random();
        int randNum = rand.nextInt(3);
        if (randNum == 0) {
            Goods.pirateAttack();
        } else if (randNum == 1) {
            //this is the Magician event where you get more credits
            Player player = Game.getInstance().getPlayer();
            int credits = player.getCredits();
            player.setCredits(credits + rand.nextInt(1000));
        }
        return randNum;
    }
}
