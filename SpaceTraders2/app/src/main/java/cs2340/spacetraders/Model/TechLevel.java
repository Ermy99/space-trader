package cs2340.spacetraders.Model;

import java.io.Serializable;

public enum TechLevel {
    
    PREAGRICULTURAL("Pre-Agricultural"),        //0
    AGRICULTURAL("Agricultural"),               //1
    MEDIEVAL("Medieval"),                       //2
    RENAISSANCE("Renaissance"),                 //3
    EARLY_INDUSTRIAL("Early Industrial"),       //4
    INDUSTRIAL("Industrial"),                   //5
    POST_INDUSTRIAL("Post-Industrial"),         //6
    HI_TECH("Hi-Tech");                         //7
    
    private final String TechLevel;
    
    TechLevel(String techLevel) {
        TechLevel = techLevel;
    }

    public String toString() {
        return TechLevel;
    }
    
}