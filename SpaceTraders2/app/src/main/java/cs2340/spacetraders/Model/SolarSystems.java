package cs2340.spacetraders.Model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Random;

/**
 * SolarSystems.java
 * Enum of various solar systems the player can travel to.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public enum SolarSystems {
    ADDAM("Addam"), //7
    ADI("Adi"), //2
    DEBO("Debo"), //5
    ERMIL("Ermil"), //3
    GHAVI("Ghavi"), //1
    SHALKA("Shalka"), //8
    SHIBI("Shibi"),
    SOMEBI("Somebi"), //0
    TAOFI("Taofi"), //4
    WEZIHIR("Wezihir") //6
    ;                 //9

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

    /**
     * getX method - returns the x coordinate of the solar system.
     *
     * @return the x coordinate of the solar system
     */
    public int getX() {
        return x;
    }

    /**
     * setX method - sets a new value for the x coordinate for the solar system.
     *
     * @param x the new x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getY method - returns the y coordinate of the solar system.
     *
     * @return the y coordinate of the solar system
     */
    public int getY() {
        return y;
    }

    /**
     * setY method - sets a new value for the y coordinate for the solar system.
     *
     * @param y the new y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getResource method - returns the resource most abundant in the solar
     *                      system.
     *
     * @return solar system's resource
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * setResource method - sets the solar system's abundant resource.
     *
     * @param resource a new resource to be set to the solar system
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * getTech method - returns the tech level of the solar system.
     *
     * @return solar system's tech level
     */
    public TechLevel getTech() {
        return tech;
    }

    /**
     * setTech method - sets the tech level of the solar system.
     *
     * @param tech new tech level to assign to a solar system
     */
    public void setTech(TechLevel tech) {
        this.tech = tech;
    }

    /**
     * getName method - returns the name of the solar system.
     *
     * @return the name of the solar system
     */
    public String getName() {
        return name;
    }

    /**
     * setName method - sets a new name for the solar system.
     *
     * @param name the new name to set for the solar system
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * canTravel method - returns whether the solar system selected by the
     *                    player can be reached.
     *
     * @param solarSystems destination solar system
     * @return whether the player can reach the target solar system
     */
    public boolean canTravel(SolarSystems solarSystems) {
        Game game = Game.getInstance();
        int Distance = Distance(solarSystems);
        SolarSystems currentLocation = game.player.getSolarSystems();

        return Distance < game.getPlayer().getFuel();
    }

    /**
     * Distance method - determines the distance between the current solar
     *                   system and the destination solar system.
     *
     * @param solarSystems the destination solar system
     * @return the distance between the two systems
     */
    public int Distance(SolarSystems solarSystems) {
        Game game = Game.getInstance();
        SolarSystems currentLocation = game.player.getSolarSystems();
        return (int) Math.round(Math.pow((Math.pow((solarSystems.x - currentLocation.x), 2)
                + Math.pow((solarSystems.y - currentLocation.y), 2)), 0.5));
    }

    /**
     * changeLocation method - executes the action of travelling to the new
     *                         solar system.
     *
     * @param solarSystems target solar system
     */
    public void changeLocation(SolarSystems solarSystems) {
        if (canTravel(solarSystems)) {
            int fuelToTravel = Distance(solarSystems);
            int currentFuel = Game.getInstance().player.getFuel();
            Game.getInstance().player.setFuel(currentFuel - fuelToTravel);
            Game.getInstance().player.setSolarSystems(solarSystems);
        }
    }

    /**
     * getDistance method - returns the distance between the current solar
     *                      system and the destination solar system.
     *
     * @param solarSystems destination solar system
     * @return the distance between the two systems.
     */
    public int getDistance(SolarSystems solarSystems) {
        return Distance(solarSystems);
    }


    public String toString() {
        return String.format(
                "%s at (%d, %d) with %s resources and " +
                        "%s tech level, with an %s government.",
                name, x, y, resource.toString(),
                tech.toString(), government.toString());
    }


}