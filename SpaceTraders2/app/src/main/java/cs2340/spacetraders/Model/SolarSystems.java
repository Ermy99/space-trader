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
        
        for (int i = 0; i < 150; i++) {
            xVals.add(i);
        }
        
        for (int i = 0; i < 100; i++) {
            yVals.add(i);
        }
        
        Collections.shuffle(xVals);
        Collections.shuffle(yVals);
    
        Random rng = new Random();
        int randomInt = rng.nextInt(50) + 1;
        
        this.name = name;
        this.x = xVals.get(ordinal());
        this.y = yVals.get(ordinal());
        this.resource = Resource.values()[rng.nextInt(12)];
        this.tech = TechLevel.values()[rng.nextInt(7)];
        
    }
    
    
    

    

    
    
    
    
    
    
    
}