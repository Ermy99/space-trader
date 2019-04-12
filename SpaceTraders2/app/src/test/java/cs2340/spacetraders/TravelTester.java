package cs2340.spacetraders;

import org.junit.Test;
import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.Player;
import cs2340.spacetraders.Model.SolarSystems;

import static org.junit.Assert.*;

/**
 * TravelTester.java
 *
 * JUnit test for the 'travel' method (along with associated methods).
 * @author Aditya Tapshalkar
 * @version 1.0
 */
public class TravelTester {
    
    private Game game = Game.getInstance();
    private Player player = new Player("Test", 4, 4, 4, 4, SolarSystems.ADI);
    
    /**
     * setup method - sets up specific conditions for this JUnit.
     *
     * @param fuel currentFuel level to assign to player
     */
    private void setup(int fuel) {
        
        // Creating a reference to an already-existing instance of game
        // (if it exists)
        game = Game.getInstance();
        
        // Creating a test player
        player = new Player("Test", 4, 4, 4, 4, SolarSystems.ADI);
        game.setPlayer(player);
    
        // Setting ADI to (10,10)
        SolarSystems.ADI.setX(10);
        SolarSystems.ADI.setY(10);
    
        // Setting SHALKA to (40,50)
        SolarSystems.SHALKA.setX(40);
        SolarSystems.SHALKA.setY(50);
        
        // Setting the player's current fuel
        player.setFuel(fuel);
        
    }
    
    /**
     * test_CurrentLocation method - tests that the player is currently
     *                              at the right location.
     *
     */
    @Test
    public void test_CurrentLocation() {
    
        setup(150);
        
        // Tests the player's current location.
        assertEquals(SolarSystems.ADI, player.getSolarSystems());
    
    }
    
    /**
     * test_SuccessfulTravel method - tests that the player can successfully
     *                                travel to a new solar system, given that
     *                                the player has adequate fuel.
     *
     */
    @Test
    public void test_SuccessfulTravel() {
        
        setup(150);
        
        SolarSystems.ADI.changeLocation(SolarSystems.SHALKA);
        
        // Tests the player's current fuel.
        assertEquals(100, player.getFuel());
        
        // Tests the player's current location after travel.
        assertEquals(SolarSystems.SHALKA, player.getSolarSystems());
        
    }
    
    /**
     * test_UnsuccessfulTravel method - tests that the player cannot travel to
     *                                  a new solar system, given that
     *                                  the player has inadequate fuel.
     *
     */
    @Test
    public void test_UnsuccessfulTravel() {
    
        setup(1);
    
        SolarSystems.ADI.changeLocation(SolarSystems.SHALKA);
        
        // Tests the player's current fuel.
        assertEquals(1, player.getFuel());
        
        // Tests the player's current location.
        assertEquals(SolarSystems.ADI, player.getSolarSystems());
    
    }

}
