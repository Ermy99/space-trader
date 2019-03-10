package cs2340.spacetraders.Model;

public enum Goods {
    Water(0, 0, 2, 30, 3),
    Furs(0, 0, 0, 250, 10),
    Food(1, 0, 1, 100, 5),
    Ore(2, 2, 3, 350, 20),
    Games(3, 1, 6, 250, -10),
    Firearms(3, 1, 5, 1250, -75),
    Medicine(4, 1, 6, 650, -20),
    Machines(4, 3, 5, 900, -30),
    Narcotics(5, 0, 5, 3500, -125),
    Robots(6, 4, 7, 5000, -150);

    private int minTechLevelToProd;
    private int minTechLevelToUse;
    private int techLevel;
    private int basePrice;
    private int priceInc;

    Goods(int minTechLevelToProd, int minTechLevelToUse, int techLevel,
          int basePrice, int priceInc) {
        this.minTechLevelToProd = minTechLevelToProd;
        this.minTechLevelToUse = minTechLevelToUse;
        this.techLevel = techLevel;
        this.basePrice = basePrice;
        this.priceInc = priceInc;
    }


    //returns a price for the tradegood
    public int getPrice(int level) {
        return basePrice + 3 * 2 * priceInc * (level - minTechLevelToProd);
    }

    public boolean canSell(Goods good, int quantityToSell) {

        for (CargoItem c: Game.getInstance().player.getShip().getCargo().getShipCargo()) {
            if (c.getGood().equals(good) && quantityToSell < c.getQuantity()) {
                return true;
            }
        }

        return false;
    }

    public boolean canBuy(Goods good, int quantityToBuy) {
        return Game.getInstance().player.getCredits() > (getPrice(Game.getInstance().player.getSolarSystems().getTech().ordinal()) * quantityToBuy) &&
                Game.getInstance().player.getShip().getCargoSize() + 1 <  Game.getInstance().player.getShip().getCargoSize();
    }

    public void buy(Goods good, int quantityToBuy) {
        if (canBuy(good, quantityToBuy)) {
            for (CargoItem c: Game.getInstance().player.getShip().getCargo().getShipCargo()) {
                if (c.getGood().equals(good)) {
                    c.quantity += quantityToBuy;
                }
            }
        }
    }

    public void sell(Goods good, int quantityToSell) {
        if (canSell(good, quantityToSell)) {
            for (CargoItem c: Game.getInstance().player.getShip().getCargo().getShipCargo()) {
                if (c.getGood().equals(good)) {
                    c.quantity -= quantityToSell;
                }
            }
        }
    }

    public int getMinTechLevelToProd() {
        return minTechLevelToProd;
    }

    public void setMinTechLevelToProd(int minTechLevelToProd) {
        this.minTechLevelToProd = minTechLevelToProd;
    }

    public int getMinTechLevelToUse() {
        return minTechLevelToUse;
    }

    public void setMinTechLevelToUse(int minTechLevelToUse) {
        this.minTechLevelToUse = minTechLevelToUse;
    }

    public int getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getPriceInc() {
        return priceInc;
    }

    public void setPriceInc(int priceInc) {
        this.priceInc = priceInc;
    }


}
