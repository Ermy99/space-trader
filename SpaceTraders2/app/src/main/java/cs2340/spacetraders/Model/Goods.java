package cs2340.spacetraders.Model;

import android.util.Log;

import java.io.Serializable;
import java.util.List;

/**
 * Goods.java
 * Enum for the goods present in the game.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public enum Goods implements Serializable {
    Water("Water", 0, 0, 2, 30, 3),
    Furs("Furs", 0, 0, 0, 250, 10),
    Food("Foods", 1, 0, 1, 100, 5),
    Ore("Ore", 2, 2, 3, 350, 20),
    Games("Games", 3, 1, 6, 250, -10),
    Firearms("Firearms", 3, 1, 5, 1250, -75),
    Medicine("Medicine", 4, 1, 6, 650, -20),
    Machines("Machines", 4, 3, 5, 900, -30),
    Narcotics("Narcotics",5, 0, 5, 3500, -125),
    Robots("Robots", 6, 4, 7, 5000, -150);

    private final String code;
    private final int minTechLevelToProd;
    private final int basePrice;
    private final int priceInc;

    Goods(String code, int minTechLevelToProd, int minTechLevelToUse, int techLevel,
          int basePrice, int priceInc) {
        this.code = code;
        this.minTechLevelToProd = minTechLevelToProd;
        int minTechLevelToUse1 = minTechLevelToUse;
        int techLevel1 = techLevel;
        this.basePrice = basePrice;
        this.priceInc = priceInc;
    }


    //returns a price for the tradegood
    public int getPrice(int level) {
        return Math.abs(basePrice + 3 * 2 * priceInc * (level - minTechLevelToProd));
    }

    public boolean canSell(Goods good, int quantityToSell) {

        for (CargoItem c: Game.getInstance().player.getShip().getCargo().getShipCargo()) {
            if (c.getGood().equals(good) && quantityToSell <= c.getQuantity()) {
                return true;
            }
        }

        return false;
    }

    public boolean canBuy(Goods good, int quantityToBuy) {
        return Game.getInstance().player.getCredits() > (good.getPrice(Game.getInstance().player.getSolarSystems().getTech().ordinal()) * quantityToBuy) &&
                Game.getInstance().player.getShip().getCargo().getCargoSize() + quantityToBuy <=  Game.getInstance().player.getShip().getCargo().getCargoCapacity();
    }

    public void buy(Goods good, int quantityToBuy) {
        if (canBuy(good, quantityToBuy)) {
            for (CargoItem c: Game.getInstance().player.getShip().getCargo().getShipCargo()) {
                if (c.getGood().equals(good)) {
                    //c.quantity += quantityToBuy;
                    //Log.d("Add", Integer.toString(quantityToBuy));
                    c.quantity = c.quantity + quantityToBuy;
                    //Log.d("Add", c.good.getCode());
                   // Log.d("Add", Integer.toString(c.quantity));
                }
            }

            int playerCredits = Game.getInstance().player.getCredits();
            Game.getInstance().player.setCredits(playerCredits -
                    good.getPrice(Game.getInstance().solarSystemLevel) * quantityToBuy);
            Log.d("edit", Integer.toString(Game.getInstance().player.getCredits()));
        }

    }

    public void sell(Goods good, int quantityToSell) {
        if (canSell(good, quantityToSell)) {
            for (CargoItem c : Game.getInstance().player.getShip().getCargo().getShipCargo()) {
                if (c.getGood().equals(good)) {
                    c.quantity -= quantityToSell;
                    int currentCredits = Game.getInstance().getPlayer().getCredits();
                    Game.getInstance().getPlayer().setCredits(currentCredits + good.getPrice(Game.getInstance().solarSystemLevel));
                }
            }
        }
    }

    public static void pirateAttack() {
        List<CargoItem> cargo = Game.getInstance().player.getShip().getCargo().getShipCargo();
        for (CargoItem c: cargo) {
            c.setQuantity(0);
        }
    }

    public String getCode() {
        return code;

    }

// --Commented out by Inspection START (4/5/2019 8:24 PM):
//    public int getMinTechLevelToProd() {
//        return minTechLevelToProd;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:24 PM)

// --Commented out by Inspection START (4/5/2019 8:24 PM):
//    public void setMinTechLevelToProd(int minTechLevelToProd) {
//        this.minTechLevelToProd = minTechLevelToProd;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:24 PM)

// --Commented out by Inspection START (4/5/2019 8:24 PM):
//    public int getMinTechLevelToUse() {
//        return minTechLevelToUse;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:24 PM)

// --Commented out by Inspection START (4/5/2019 8:24 PM):
//    public void setMinTechLevelToUse(int minTechLevelToUse) {
//        this.minTechLevelToUse = minTechLevelToUse;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:24 PM)

// --Commented out by Inspection START (4/5/2019 8:24 PM):
//    public int getTechLevel() {
//        return techLevel;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:24 PM)

// --Commented out by Inspection START (4/5/2019 8:24 PM):
//    public void setTechLevel(int techLevel) {
//        this.techLevel = techLevel;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:24 PM)

// --Commented out by Inspection START (4/5/2019 8:24 PM):
//    public int getBasePrice() {
//        return basePrice;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:24 PM)

// --Commented out by Inspection START (4/5/2019 8:24 PM):
//    public void setBasePrice(int basePrice) {
//        this.basePrice = basePrice;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:24 PM)

// --Commented out by Inspection START (4/5/2019 8:24 PM):
//    public int getPriceInc() {
//        return priceInc;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:24 PM)

// --Commented out by Inspection START (4/5/2019 8:24 PM):
//    public void setPriceInc(int priceInc) {
//        this.priceInc = priceInc;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:24 PM)


}
