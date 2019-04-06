package cs2340.spacetraders.Model;

import java.io.Serializable;

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

    public SolarSystems getSolarSystems() {
        return solarSystems;
    }

    public void setSolarSystems(SolarSystems solarSystems) {
        this.solarSystems = solarSystems;
    }

    public String getName() {
        return name;
    }

// --Commented out by Inspection START (4/5/2019 8:25 PM):
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:25 PM)

    public int getPilotPoints() {
        return pilotPoints;
    }

// --Commented out by Inspection START (4/5/2019 8:25 PM):
//    public void setPilotPoints(int pilotPoints) {
//        this.pilotPoints = pilotPoints;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:25 PM)

    public int getEngineeringPoints() {
        return engineeringPoints;
    }

// --Commented out by Inspection START (4/5/2019 8:25 PM):
//    public void setEngineeringPoints(int engineeringPoints) {
//        this.engineeringPoints = engineeringPoints;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:25 PM)

    public int getTraderPoints() {
        return traderPoints;
    }

// --Commented out by Inspection START (4/5/2019 8:25 PM):
//    public void setTraderPoints(int traderPoints) {
//        this.traderPoints = traderPoints;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:25 PM)

    public int getFighterPoints() {
        return fighterPoints;
    }

// --Commented out by Inspection START (4/5/2019 8:25 PM):
//    public void setFighterPoints(int fighterPoints) {
//        this.fighterPoints = fighterPoints;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:25 PM)

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Ship getShip() {
        return ship;
    }

    public void setFuel(int fuel) {
        this.Fuel = fuel;
    }

    public int getFuel() {
        return Fuel;
    }

}
