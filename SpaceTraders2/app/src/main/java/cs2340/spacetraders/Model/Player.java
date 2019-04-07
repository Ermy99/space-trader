package cs2340.spacetraders.Model;

import java.io.Serializable;

/**
 * Player.java
 * Represents Player configuration data.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class Player implements Serializable {
    
    private final String name;
    private final int pilotPoints;
    private final int engineeringPoints;
    private final int traderPoints;
    private final int fighterPoints;
    private int credits;
    private final Ship ship;
    private SolarSystems solarSystems;
    private int Fuel = 1000;
    
    /**
     * Player Constructor - creates a new player from configuration data.
     *
     * @param name the inputted name of the player
     * @param pilotPoints inputted pilot points
     * @param engineeringPoints inputted engineering points
     * @param traderPoints inputted trader points
     * @param fighterPoints inputted fighter points
     * @param solarSystems randomly generated solar systems
     */
    public Player(String name, int pilotPoints, int engineeringPoints, int traderPoints,
                  int fighterPoints, SolarSystems solarSystems) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.engineeringPoints = engineeringPoints;
        this.traderPoints = traderPoints;
        this.fighterPoints = fighterPoints;
        this.credits = 1000;
        this.ship = new Ship();
        this.solarSystems = solarSystems;
    }
    
    /**
     * getSolarSystems method - returns the solar systems and their coordinates.
     *
     * @return the game's solar systems and their coordinates
     */
    public SolarSystems getSolarSystems() {
        return solarSystems;
    }
    
    /**
     * setSolarSystems method - sets a new solar system to replace the existing
     *                          one.
     *
     * @param solarSystems the new solar systems to replace the existing one
     */
    public void setSolarSystems(SolarSystems solarSystems) {
        this.solarSystems = solarSystems;
    }
    
    /**
     * getName method - returns player's name.
     *
     * @return player's name
     */
    public String getName() {
        return name;
    }

// --Commented out by Inspection START (4/5/2019 8:25 PM):
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:25 PM)
    
    /**
     * getPilotPoints method - returns player's pilot points.
     *
     * @return player's pilot points
     */
    public int getPilotPoints() {
        return pilotPoints;
    }

// --Commented out by Inspection START (4/5/2019 8:25 PM):
//    public void setPilotPoints(int pilotPoints) {
//        this.pilotPoints = pilotPoints;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:25 PM)
    
    /**
     * getEngineeringPoints method - returns player's engineering points.
     *
     * @return player's engineering points
     */
    public int getEngineeringPoints() {
        return engineeringPoints;
    }

// --Commented out by Inspection START (4/5/2019 8:25 PM):
//    public void setEngineeringPoints(int engineeringPoints) {
//        this.engineeringPoints = engineeringPoints;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:25 PM)
    
    /**
     * getTraderPoints method - returns player's trader points.
     *
     * @return player's trader points
     */
    public int getTraderPoints() {
        return traderPoints;
    }

// --Commented out by Inspection START (4/5/2019 8:25 PM):
//    public void setTraderPoints(int traderPoints) {
//        this.traderPoints = traderPoints;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:25 PM)
    
    /**
     * getFighterPoints method - returns player's fighter points.
     *
     * @return player's fighter points
     */
    public int getFighterPoints() {
        return fighterPoints;
    }

// --Commented out by Inspection START (4/5/2019 8:25 PM):
//    public void setFighterPoints(int fighterPoints) {
//        this.fighterPoints = fighterPoints;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:25 PM)
    
    /**
     * getCredits method - returns the player's number of credits.
     *
     * @return number of credits the player has
     */
    public int getCredits() {
        return credits;
    }
    
    /**
     * setCredits method - sets the player's credits to a new amount.
     *
     * @param credits the new number of credits to replace the old number
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    /**
     * getShip method - returns the player's ship.
     *
     * @return the player's ship
     */
    public Ship getShip() {
        return ship;
    }
    
    /**
     * setFuel method - sets a new value to the fuel in the player's ship.
     *
     * @param fuel the new amount of fuel in the player's ship.
     */
    public void setFuel(int fuel) {
        this.Fuel = fuel;
    }
    
    /**
     * getFuel method - returns the amount of fuel in the player's ship.
     *
     * @return the amount of fuel in the player's ship.
     */
    public int getFuel() {
        return Fuel;
    }

}
