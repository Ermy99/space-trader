package cs2340.spacetraders.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

    public String toString(){
        String planetToString = String.format("%s at (%d, %d) with %s resources and " +
                "%s tech level.", name, x, y, resource.toString(), tech.toString());
        return  planetToString;
    }
    
    

    

    
    
    
    
    
    
    
}