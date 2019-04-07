package cs2340.spacetraders.Model;

import java.io.Serializable;

/**
 * PoliticalSystems.java
 * Enum of political systems of the solar systems.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public enum PoliticalSystem implements Serializable {

    ANARCHY("Anarchy"),                     //0
    CAPITALIST("Capitalist State"),         //1
    COMMUNIST("Communist State"),           //2
    CONFEDERACY("Confederacy"),             //3
    CORPORATE("Corporate State"),           //4
    CYBERNETIC("Cybernetic State"),         //5
    DEMOCRATIC("Democratic"),               //6
    DICTATORSHIP("Dictatorship"),           //7
    FASCIST("Fascist State"),               //8
    FEUDAL("Feudal State"),                 //9
    MILITARY("Military State"),             //10
    MONARCHY("Monarchy"),                   //11
    PACIFIST("Pacifist State"),             //12
    SOCIALIST("Socialist State"),           //13
    SATORI("State of Satori"),              //14
    TECHNOCRATIC("Technocratic"),           //15
    THEOCRATIC("Theocratic");               //16
    
    private final String govName;
    
    PoliticalSystem(String govName) {
        this.govName = govName;
    }
    
    public String toString() {
        return govName;
    }

}
