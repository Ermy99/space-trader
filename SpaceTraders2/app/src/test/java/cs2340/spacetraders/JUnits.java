package cs2340.spacetraders;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.Model.Player;
import cs2340.spacetraders.Model.SolarSystems;

import static org.junit.Assert.*;

/**
 * JUnits.java
 * Comprehensive JUnit Testing
 *
 * @author  Aditya Tapshalkar (TravelTester),
 *          Sanghavi Gaddam (SanghaviJUnitTest),
 *          Emerlinda Izihirwe (canTravelTest),
 *          Chisomebi Obed,
 *          Taofikat Bishi
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Enclosed.class)
public class JUnits {
    
    /**
     * TravelTester.java
     * JUnit test for the 'travel' method (along with associated methods).
     *
     * @author Aditya Tapshalkar
     * @version 1.0
     */
    public static class TravelTester {
    
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
    
    /**
     * CanTravelTest.java
     * Test for the canTravel() method in SolarSystems
     * @author Ermelinda Izihirwe
     * @version 1.0
     */
    public static class canTravelTest {
    
        @Test
        public void checkCanTravel() {
            Game.getInstance().getPlayer().setSolarSystems(SolarSystems.SOMEBI);
            Game.getInstance().getPlayer().setFuel(SolarSystems.SOMEBI.getDistance(SolarSystems.GHAVI) + 1);
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
            Game.getInstance().getPlayer().setFuel(SolarSystems.SOMEBI.getDistance(SolarSystems.ADDAM) + 1);
            assertTrue(SolarSystems.SOMEBI.canTravel(SolarSystems.ADDAM));
        }
    
    }
    
    public static class SanghaviJUnitTest {
        
        @Test
        public void testCanBuy() {
            Game game = Game.getInstance();
            Player player = new Player("Ed", 4, 4,
                    4, 4, SolarSystems.SOMEBI);
            
            //price and number of goods are okay
            game.setPlayer(player);
            Goods goods = Goods.Water;
            Boolean val1 = goods.canBuy(goods, 1);
            assertEquals(true, val1);
            
            //price of goods is too high
            Goods goods2 = Goods.Narcotics;
            Boolean val2 = goods2.canBuy(goods2, 3);
            assertEquals(false, val2);
            
            //the quantity that you want to buy is too high
            Goods goods3 = Goods.Water;
            Boolean val3 = goods3.canBuy(goods3, 16);
            assertEquals(false, val3);
        }
        
    }
    
    
    
}
