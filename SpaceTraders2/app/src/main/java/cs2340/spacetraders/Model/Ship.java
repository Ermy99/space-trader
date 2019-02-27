package cs2340.spacetraders.Model;

public class Ship {
    Goods[] cargoSpace;
    Shiptype shiptype;
    int cargoSize;

    Ship(int cargoSpace, Shiptype shiptype) {
        this.cargoSpace = new Goods[cargoSpace];
        this.shiptype = shiptype;
        this.cargoSize = cargoSpace;
    }

    public Goods[] getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(Goods[] cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public Shiptype getShiptype() {
        return shiptype;
    }

    public void setShiptype(Shiptype shiptype) {
        this.shiptype = shiptype;
    }

    public int getCargoSize() {
        return cargoSize;
    }

    public void updateCargoSize(int change) {
        cargoSize += change;
    }

    //create instance variable for each type of good that counts how many of each
    //type there are --> create getters
}
