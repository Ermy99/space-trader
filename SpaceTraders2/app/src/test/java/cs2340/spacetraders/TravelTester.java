package cs2340.spacetraders;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TravelTester {
    
    private Player player = new Player("Test", 4, 4, 4, 4, SolarSystems.ADI);
    
    /**
     * setup method - sets up specific conditions for this JUnit.
     *
     * @param fuel currentFuel level to assign to player
     * @param scenario the scenario of JUnit to test
     */
    private void setup(int fuel, int scenario) throws IllegalArgumentException {
        
        // Creating a reference to an already-existing instance of game
        // (if it exists)
        Game game = Game.getInstance();
        
        // Creating a test player
        player = new Player("Test", 4, 4, 4, 4, SolarSystems.ADI);
        game.setPlayer(player);
    
        // Setting the player's current fuel
        player.setFuel(fuel);
        
        switch (scenario) {
            case 1:
                
                // Setting ADI to (37,49)
                SolarSystems.ADI.setXY(37, 49);
    
                // Setting SHALKA to (25,44)
                SolarSystems.SHALKA.setXY(25, 44);
                
                break;
                
            case 2:
                
                player.setSolarSystems(SolarSystems.ERMIL);
                
                // Setting ERMIL to (109,9)
                SolarSystems.ERMIL.setXY(109, 9);
                
                // Setting SHIBI to (79, 137)
                SolarSystems.SHIBI.setXY(79, 137);
                
                break;
                
            default:
                throw new IllegalArgumentException("Input a valid scenario.");
                
        }
        
    }
    
    /**
     * test_CurrentLocation method - tests that the player is currently
     *                              at the right location.
     *
     */
    @Test
    public void test_CurrentLocation() {
    
        setup(154, 1);
        
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
        
        // Test 1: Setting up planets with a pythagorean triplet
        setup(154, 1);
        
        SolarSystems.ADI.changeLocation(SolarSystems.SHALKA);
        
        // Tests the player's current fuel.
        assertEquals(141, player.getFuel());
        
        // Tests the player's current location after travel.
        assertEquals(SolarSystems.SHALKA, player.getSolarSystems());
        
        //----------------------------------------------------------------------
        
        // Test 2: Setting up coordinates with a random triangle
        setup(777, 2);
        
        SolarSystems.ERMIL.changeLocation(SolarSystems.SHIBI);
        
        // Tests the player's current fuel.
        assertEquals(646, player.getFuel());
        
        // Tests the player's current location after travel.
        assertEquals(SolarSystems.SHIBI, player.getSolarSystems());
        
    }
    
    /**
     * test_UnsuccessfulTravel method - tests that the player cannot travel to
     *                                  a new solar system, given that
     *                                  the player has inadequate fuel.
     *
     */
    @Test
    public void test_UnsuccessfulTravel() {
    
        setup(1, 1);
    
        SolarSystems.ADI.changeLocation(SolarSystems.SHALKA);
        
        // Tests the player's current fuel.
        assertEquals(1, player.getFuel());
        
        // Tests the player's current location.
        assertEquals(SolarSystems.ADI, player.getSolarSystems());
    
    }

}
