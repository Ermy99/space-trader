package cs2340.spacetraders.Model;

public class Player {
    private String name;
    private int pilotPoints;
    private int engineeringPoints;
    private int traderPoints;
    private int fighterPoints;
    private int credits;
    private Shiptype shiptype;

    public Player(String name, int pilotPoints, int engineeringPoints, int traderPoints,
                  int fighterPoints) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.engineeringPoints = engineeringPoints;
        this.traderPoints = traderPoints;
        this.fighterPoints = fighterPoints;
        this.credits = 1000;
        this.shiptype = Shiptype.GNAT;
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

}
