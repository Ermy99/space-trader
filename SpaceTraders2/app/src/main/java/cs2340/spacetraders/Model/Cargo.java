package cs2340.spacetraders.Model;

import java.util.ArrayList;
import java.util.List;

public class Cargo {

        List<CargoItem> shipCargo;
        int cargoCapacity;


        public Cargo(int cargoCapacity) {
            this.cargoCapacity = cargoCapacity;
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
