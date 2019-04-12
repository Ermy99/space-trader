package cs2340.spacetraders;

import org.junit.Test;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.SolarSystems;

import static org.junit.Assert.*;


/**
 * CanTravelTest.java
 * Test for the canTravel() method in SolarSystems
 * @author Ermelinda Izihirwe
 * @version 1.0
 */

public class CanTravelTest {

    /**
     * checkCanTravel method : check if the player can travel.
     */
    @Test
    public void checkCanTravel() {
        Game.getInstance().getPlayer().setSolarSystems(SolarSystems.SOMEBI);
        Game.getInstance().getPlayer().setFuel(SolarSystems.SOMEBI.getDistance(SolarSystems.GHAVI));
        assertTrue(SolarSystems.SOMEBI.canTravel(SolarSystems.GHAVI));
    }

    /**
     * checkFuel method : checks that the player cannot travel when they have no fuel
     */
    @Test
    public void checkFuelEmpty() {
        Game.getInstance().getPlayer().setSolarSystems(SolarSystems.SOMEBI);
        Game.getInstance().getPlayer().setFuel(0);
        assertFalse(SolarSystems.SOMEBI.canTravel(SolarSystems.ADDAM));



    }

    /**
     * checkFuelEnough method : check if the player can travel when they have the exact amount of
     *                          fuel required.
     */
    @Test
    public void checkFuelEnough() {
        Game.getInstance().getPlayer().setSolarSystems(SolarSystems.SOMEBI);
        Game.getInstance().getPlayer().setFuel(SolarSystems.SOMEBI.getDistance(SolarSystems.ADDAM));
        assertTrue(SolarSystems.SOMEBI.canTravel(SolarSystems.ADDAM));
    }


}

