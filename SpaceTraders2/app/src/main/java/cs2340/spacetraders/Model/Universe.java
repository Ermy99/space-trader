package cs2340.spacetraders.Model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Universe.java
 * Represents all of the solar systems in a single universe.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
class Universe implements Serializable {
    private List<SolarSystems> solarSystems;

    /**
     * Universe Constructor - creates a list of solar systems
     *
     */
    public Universe() {
        this.solarSystems = new ArrayList<>();
        int length = SolarSystems.values().length;
        for (int i = 0; i < length; i++) {
            solarSystems.add(SolarSystems.values()[i]);
            Log.d("Planet Added: ", SolarSystems.values()[i].toString());
        }
    }

    /**
     * getPlanets method - returns the list of solar systems
     *
     * @return the list of planets
     */
    public List<SolarSystems> getPlanets() {
        return solarSystems;
    }

    /**
     * setPlanets method - sets the list of planets to a new list of planets
     *
     * @param solarSystems the new solar systems list to replace the existing
     *                     list of solar systems
     */
    public void setPlanets(List<SolarSystems> solarSystems) {
        this.solarSystems = solarSystems;
    }

}
