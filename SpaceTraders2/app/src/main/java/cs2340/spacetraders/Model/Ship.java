package cs2340.spacetraders.Model;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    public Cargo cargo;
    public Shiptype shiptype;
    public int Fuel;
    //int cargoSize;
    //int cargoCapacity;


    Ship(Shiptype shiptype){
        this.shiptype = shiptype;
        this.cargo = new Cargo(15);
    }

    public Shiptype getShiptype() {
        return shiptype;
    }


    public void setShiptype(Shiptype shiptype) {
        this.shiptype = shiptype;
    }

    public void setCargo() {
        cargo = new Cargo(15);
    }

//    public void setCargoSize() {
//        this.cargoSize = cargo.getCargoSize();
//    }

//    public int getCargoCapacity() {
//        return cargo.cargoCapacity;
//    }

//    public int getCargoSize() {
//        return cargo.getCargoSize();
//    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setFuel(int fuelChange) {
        this.Fuel += fuelChange;
    }



    //create instance variable for each type of good that counts how many of each
    //type there are --> create getters

}
