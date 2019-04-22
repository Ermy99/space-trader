package cs2340.spacetraders.Model

import android.util.Log

import java.io.Serializable
import java.util.ArrayList

/**
 * Universe.kt
 * Represents all of the solar systems in a single universe.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
internal class Universe : Serializable {
    var solarSystems: MutableList<SolarSystems>

    /**
     * getPlanets method - returns the list of solar systems
     *
     * @return the list of planets
     */
    /**
     * setPlanets method - sets the list of planets to a new list of planets
     *
     * @param solarSystems the new solar systems list to replace the existing
     * list of solar systems
     */
    var planets: MutableList<SolarSystems>
        get() = solarSystems
        set(solarSystems) {
            this.solarSystems = solarSystems
        }

    /**
     * Universe Constructor - creates a list of solar systems
     *
     */
    init {
        this.solarSystems = ArrayList()
        val length = SolarSystems.values().size
        for (i in 0 until length) {
            solarSystems.add(SolarSystems.values()[i])
            Log.d("Planet Added: ", SolarSystems.values()[i].toString())
        }
    }

}
