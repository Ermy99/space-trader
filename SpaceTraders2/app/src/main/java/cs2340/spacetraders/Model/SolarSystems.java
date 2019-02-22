package cs2340.spacetraders.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum SolarSystems {
    
    KORMA("A");
    
    private int x;
    private int y;
    private Resource resource;
    private TechLevel tech;
    private String name;
    private ArrayList<Integer> xVals = new ArrayList<>(150);
    private ArrayList<Integer> yVals = new ArrayList<>(100);
    
    SolarSystems(String name) {
    
        Random rng = new Random();
        Coordinates coordinates = new Coordinates();
        
        this.name = name;
        this.x = coordinates.getxVals().get(ordinal());
        this.y = coordinates.getyVals().get(ordinal());
        this.resource = Resource.values()[rng.nextInt(12)];
        this.tech = TechLevel.values()[rng.nextInt(7)];
        
    }
    
    
    

    

    
    
    
    
    
    
    
}