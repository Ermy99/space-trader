package cs2340.spacetraders.Model;

import java.io.Serializable;

public class Ship implements Serializable {
    public final Cargo cargo;
    public Shiptype shiptype;
    public int Fuel;
    //int cargoSize;
    //int cargoCapacity;


    Ship(){
        this.shiptype = Shiptype.GNAT;
        this.cargo = new Cargo(15);
    }

    public Shiptype getShiptype() {
        return shiptype;
    }


    public void setShiptype(Shiptype shiptype) {
        this.shiptype = shiptype;
    }

// --Commented out by Inspection START (4/5/2019 8:26 PM):
//    public void setCargo() {
//        cargo = new Cargo(15);
//    }
// --Commented out by Inspection STOP (4/5/2019 8:26 PM)

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
