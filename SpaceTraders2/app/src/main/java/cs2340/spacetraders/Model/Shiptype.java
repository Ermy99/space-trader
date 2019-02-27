package cs2340.spacetraders.Model;

public enum Shiptype {
    GNAT(10);

    int cargoSize;

    Shiptype(int cargoSize) {
        this.cargoSize = cargoSize;
    }

    public int getCargoSize() {
        return cargoSize;
    }
}
