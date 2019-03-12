package cs2340.spacetraders.Model;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    Cargo cargo;
    public Shiptype shiptype;
    int cargoSize;


    Ship(Shiptype shiptype){
        this.shiptype = shiptype;
        this.cargo = new Cargo(shiptype.getCargoSize());
    }



    public Shiptype getShiptype() {
        return shiptype;
    }

    public void setShiptype(Shiptype shiptype) {
        this.shiptype = shiptype;
    }

    public int getCargoSize() {
        return cargo.getCargoSize();
    }

    public Cargo getCargo() {
        return cargo;
    }


    //create instance variable for each type of good that counts how many of each
    //type there are --> create getters


    public class Cargo {
       List<CargoItem> shipCargo;
       int cargoSize;


        public Cargo(int cargoSize) {
            this.cargoSize = 15;
            shipCargo = new ArrayList<>();
            shipCargo.add(new CargoItem(0, Goods.Water));
            shipCargo.add(new CargoItem(0, Goods.Furs));
            shipCargo.add(new CargoItem(0, Goods.Food));
            shipCargo.add(new CargoItem(0, Goods.Ore));
            shipCargo.add(new CargoItem(0, Goods.Games));
            shipCargo.add(new CargoItem(0, Goods.Firearms));
            shipCargo.add(new CargoItem(0, Goods.Medicine));
            shipCargo.add(new CargoItem(0, Goods.Machines));
            shipCargo.add(new CargoItem(0, Goods.Narcotics));
            shipCargo.add(new CargoItem(0, Goods.Robots));
        }

        public int getCargoSize() {
            int returnVal = 0;
            for (CargoItem c: shipCargo) {
                returnVal +=  c.getQuantity();
            }
            return returnVal;
        }

        public List<CargoItem> getShipCargo() {
            return shipCargo;
        }

    }
}
