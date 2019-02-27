package cs2340.spacetraders.Model;

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
        this()
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



}
