package cs2340.spacetraders.Model;

public class Ship {
    Cargo cargo;
    Shiptype shiptype;
    int cargoSize;


    Ship(Shiptype shiptype){
        this.shiptype = shiptype;
        this.cargo = new Cargo();
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


    //create instance variable for each type of good that counts how many of each
    //type there are --> create getters


    public class Cargo {
        Goods[] shipCargo;
        int waterAmount;
        int furAmount;
        int foodAmount;
        int oreAmount;
        int gamesAmount;
        int firearmsAmount;
        int medicineAmount;
        int machineAmount;
        int narcoticsAmount;
        int robotsAmount;

        public Cargo() {
            this(shiptype.getCargoSize(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        }

        public Cargo(int shipCargoSize, int waterAmount, int furAmount, int foodAmount,
                     int oreAmount, int gamesAmount, int firearmsAmount, int medicineAmount, int machineAmount, int narcoticsAmount, int robotsAmount) {
            this.shipCargo = new Goods[shipCargoSize];
            this.waterAmount = waterAmount;
            this.furAmount = furAmount;
            this.foodAmount = foodAmount;
            this.oreAmount = oreAmount;
            this.gamesAmount = gamesAmount;
            this.firearmsAmount = firearmsAmount;
            this.medicineAmount = medicineAmount;
            this.machineAmount = machineAmount;
            this.narcoticsAmount = narcoticsAmount;
            this.robotsAmount = robotsAmount;
        }

        public int getCargoSize() {
            return shipCargo.length;
        }
    }
}
