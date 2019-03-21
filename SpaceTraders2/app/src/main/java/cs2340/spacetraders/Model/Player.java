package cs2340.spacetraders.Model;

public class Player {
    private String name;
    private int pilotPoints;
    private int engineeringPoints;
    private int traderPoints;
    private int fighterPoints;
    private int credits;
    private Ship ship;
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
        this.ship = new Ship(Shiptype.GNAT);
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

    public void setName(String name) {
        this.name = name;
    }

    public int getPilotPoints() {
        return pilotPoints;
    }

    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    public int getEngineeringPoints() {
        return engineeringPoints;
    }

    public void setEngineeringPoints(int engineeringPoints) {
        this.engineeringPoints = engineeringPoints;
    }

    public int getTraderPoints() {
        return traderPoints;
    }

    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    public int getFighterPoints() {
        return fighterPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

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
        this.Fuel += fuel;
    }

    public int getFuel() {
        return Fuel;
    }

}
