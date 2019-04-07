package cs2340.spacetraders.Model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Random;

@SuppressWarnings("SpellCheckingInspection")
public enum SolarSystems {
    
    SOMEBI("Somebi"),               //0
    GHAVI("Ghavi"),                 //1
    ADI("Adi"),                     //2
    ERMIL("Ermil"),                 //3
    TAOFI("Taofi"),                 //4
    DEBO("Debo"),                   //5
    WEZIHIR("Wezihir"),             //6
    ADDAM("Addam"),                 //7
    SHALKA("Shalka"),               //8
    SHIBI("Shibi");                 //9
    
    private int x;
    private int y;
    private Resource resource;
    private TechLevel tech;
    private PoliticalSystem government;
    private String name;
    private ArrayList<Integer> xVals = new ArrayList<>(150);
    private ArrayList<Integer> yVals = new ArrayList<>(100);
    Double distance;
    
    
    SolarSystems(String name) {
    
        Random rng = new Random();
        Coordinates coordinates = new Coordinates();
        
        this.name = name;
        this.x = coordinates.getxVals().get(ordinal());
        this.y = coordinates.getyVals().get(ordinal());
        this.resource = Resource.values()[rng.nextInt(13)];
        this.tech = TechLevel.values()[rng.nextInt(8)];
        this.government = PoliticalSystem.values()[rng.nextInt(17)];
        
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public TechLevel getTech() {
        return tech;
    }

    public void setTech(TechLevel tech) {
        this.tech = tech;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean canTravel(SolarSystems solarSystems) {
        Game game = Game.getInstance();
        int Distance = Distance(solarSystems);
        SolarSystems currentLocation = game.player.getSolarSystems();

        return Distance < game.getPlayer().getFuel();
    }

    public int Distance(SolarSystems solarSystems) {
        Game game = Game.getInstance();
        SolarSystems currentLocation = game.player.getSolarSystems();
        return (int) Math.round(Math.pow((Math.pow((solarSystems.x - currentLocation.x), 2)
                + Math.pow((solarSystems.y - currentLocation.y),2)), 0.5));
    }

    public void changeLocation (SolarSystems solarSystems) {
        if (canTravel(solarSystems)) {
            int fuelToTravel = Distance(solarSystems);
            int currentFuel = Game.getInstance().player.getFuel();
            Game.getInstance().player.setFuel(currentFuel - fuelToTravel);
            Game.getInstance().player.setSolarSystems(solarSystems);
        }
    }

    public int getDistance(SolarSystems solarSystems) {
        return Distance(solarSystems);
    }


    public String toString(){
        return String.format(
                "%s at (%d, %d) with %s resources and " +
                "%s tech level, with an %s government.",
                name, x, y, resource.toString(),
                tech.toString(), government.toString());
    }
    
    

    

    
    
    
    
    
    
    
}