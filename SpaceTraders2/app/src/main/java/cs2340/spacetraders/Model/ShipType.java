package cs2340.spacetraders.Model;

/**
 * ShipType.java
 * Enum of various ship types player can purchase in the game.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public enum ShipType {
    FLEA("Flea", 10, 20),
    GNAT("Gnat", 15, 14),
    FIREFLY("Firefly", 20, 17),
    MOSQUITO("Mosquito", 15, 13),
    BUMBLEBEE("Bumblebee", 25, 15),
    BEETLE("Beetle", 50, 14),
    HORNET("Hornet", 20, 16),
    GRASSHOPPER("Grasshopper", 30, 15),
    TERMITE("Termite", 60, 13),
    WASP("Wasp", 35, 14);

    final String name;
    final int cargoSize;
    final int parsecs;

    ShipType(String name, int cargoSize, int parsecs) {
        this.name = name;
        this.cargoSize = cargoSize;
        this.parsecs = parsecs;
    }

    /**
     * getName method - returns the name of the ship type.
     *
     * @return the name of the ship type
     */
    public String getName() {
        return name;
    }
    
    /**
     * getCargoSize method - returns the size of the cargo.
     *
     * @return number of items inside the cargo
     */
    public int getCargoSize() {
        return cargoSize;
    }
    
    /**
     * getParsecs method - returns the number of parsecs the ship can travel.
     *
     * @return number of parsecs the ship can travel
     */
    public int getParsecs() {
        return parsecs;
    }
}
