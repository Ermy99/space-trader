package cs2340.spacetraders.Model;

public enum Shiptype {
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

    int cargoSize;
    int parsecs;

    Shiptype(String name, int cargoSize, int parsecs) {
        this.cargoSize = cargoSize;
        this.parsecs = parsecs;
    }

    public int getCargoSize() {
        return cargoSize;
    }
    
    public int getParsecs() {
        return parsecs;
    }
}
