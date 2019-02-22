package cs2340.spacetraders.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public enum SolarSystems {
    
    KORMA("A", Resource.LIFELESS, TechLevel.HI_TECH);
    
    private int x;
    private int y;
    private Resource resource;
    private TechLevel tech;
    private String name;
    private ArrayList<Integer> xVals = new ArrayList<>(150);
    private ArrayList<Integer> yVals = new ArrayList<>(100);
    
    SolarSystems(String name, Resource resource, TechLevel tech) {
        
        for (int i = 0; i < 150; i++) {
            xVals.add(i);
        }
        
        for (int i = 0; i < 100; i++) {
            yVals.add(i);
        }
        
        Collections.shuffle(xVals);
        Collections.shuffle(yVals);
        
        this.name = name;
        this.x = xVals.get(ordinal());
        this.y = yVals.get(ordinal());
        this.resource = resource;
        this.tech = tech;
        
    }
    
    
    

    

    
    
    
    
    
    
    
}