package cs2340.spacetraders.Model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Universe implements Serializable {
    List<SolarSystems> solarSystems;

    public Universe() {
        this.solarSystems = new ArrayList<>();
        int length = SolarSystems.values().length;
        for (int i = 0; i < length; i++) {
            solarSystems.add(SolarSystems.values()[i]);
            Log.d("Planet Added: ", SolarSystems.values()[i].toString());
        }
    }

    public List<SolarSystems> getPlanets() {
        return solarSystems;
    }

    public void setPlanets(List<SolarSystems> solarSystems) {
        this.solarSystems = solarSystems;
    }

}
