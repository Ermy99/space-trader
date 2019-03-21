package cs2340.spacetraders.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.SolarSystems;

public class TravelViewModel extends AndroidViewModel {
    Game game;

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
}
