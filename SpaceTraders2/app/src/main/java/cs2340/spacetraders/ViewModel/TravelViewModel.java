package cs2340.spacetraders.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import java.util.Random;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.Model.Player;
import cs2340.spacetraders.Model.SolarSystems;

/**
 * TravelViewModel.java
 * ViewModel for traveling to new solar systems.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class TravelViewModel extends AndroidViewModel {

    /**
     * TravelViewModel Constructor - creates a new viewModel for travelling.
     *
     * @param application the application passed in
     */
    public TravelViewModel(Application application) {
        super(application);
        Game game = Game.getInstance();
    }

    /**
     * canTravel method - determines whether the player can travel to the chosen
     *                    solar system.
     *
     * @param solarSystems the solar system the player wants to travel to
     * @return whether the player can travel to the chosen solar system
     */
    public boolean canTravel(SolarSystems solarSystems) {
        return solarSystems.canTravel(solarSystems);
    }

    /**
     * travel method - executes the action of travelling to a new solar system.
     *
     * @param solarSystems the new solar system to travel to
     */
    public void travel(SolarSystems solarSystems) {
        if (solarSystems.canTravel(solarSystems)) {
            solarSystems.changeLocation(solarSystems);
        }
    }

    /**
     * randomEvent method - uses RNG to generate random events when travelling.
     *
     * @return the generated int to execute a random event
     */
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