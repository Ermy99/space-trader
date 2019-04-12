package cs2340.spacetraders.Model;

import android.support.annotation.NonNull;

/**
 * Resource.java
 * Enum of resources of the solar systems.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public enum Resource {
    
    NO_SPECIAL_RESOURCES("No special resources"),   //0
    MINERAL_RICH("Mineral-rich"),                   //1
    MINERAL_POOR("Mineral-poor"),                   //2
    DESERT("Desert"),                               //3
    LOTS_OF_WATER("Lots of water"),                 //4
    RICH_SOIL("Rich soil"),                         //5
    POOR_SOIL("Poor soil"),                         //6
    RICH_FAUNA("Rich fauna"),                       //7
    LIFELESS("Lifeless"),                           //8
    WEIRD_MUSHROOMS("Weird mushrooms"),             //9
    LOTS_OF_HERBS("Rich flora"),                    //10
    ARTISTIC("Artistic"),                           //11
    WARLIKE("Warlike");                             //12
    
    
    private final String resource;
    
    Resource(String resource) {
        this.resource = resource;
    }

    @NonNull
    public String toString() {
        return resource;
    }
    

    
}