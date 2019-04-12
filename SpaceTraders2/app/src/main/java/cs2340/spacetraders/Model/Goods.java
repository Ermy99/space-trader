package cs2340.spacetraders.Model;

import android.util.Log;

import java.util.List;

/**
 * Goods.java
 * Enum for the goods present in the game.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public enum Goods {
    Water("Water", 0, 30, 3),
    Furs("Furs", 0, 250, 10),
    Food("Foods", 1, 100, 5),
    Ore("Ore", 2, 350, 20),
    Games("Games", 3, 250, -10),
    Firearms("Firearms", 3, 1250, -75),
    Medicine("Medicine", 4, 650, -20),
    Machines("Machines", 4, 900, -30),
    Narcotics("Narcotics",5, 3500, -125),
    Robots("Robots", 6, 5000, -150);

    private final String code;
    private final int minTechLevelToProd;
    private final int basePrice;
    private final int priceInc;
    
    /**
     * Goods constructor - creates a good based on tech level
     *
     * @param code the name of the good
     * @param minTechLevelToProd minimum tech level to produce the good
     * @param basePrice the base price of the good
     * @param priceInc price increase of the good
     */
    Goods(String code, int minTechLevelToProd, int basePrice, int priceInc) {
        this.code = code;
        this.minTechLevelToProd = minTechLevelToProd;
        this.basePrice = basePrice;
        this.priceInc = priceInc;
    }
    
    
    /**
     * getPrice method - returns the price of the good.
     *
     * @param level the level of the good
     * @return the price of the good
     */
    public int getPrice(int level) {
        return Math.abs(basePrice + (3 * 2 * priceInc * (level - minTechLevelToProd)));
    }

    /**
     * canSell method - determines if you can sell a number of goods given the
     *                  player's cargo.
     *
     * @param good the good to sell
     * @param quantityToSell the quantity of the good to sell
     * @return whether the player can or cannot sell the good(s)
     */
    public boolean canSell(Goods good, int quantityToSell) {
        Game game = Game.getInstance();
        for (CargoItem c: game.getPlayer().getShipCargo()) {
            Goods goods = c.getGood();
            if (goods.equals(good) && (quantityToSell <= c.getQuantity())) {
                return true;
            }
        }

        return false;
    }
    
    /**
     * canBuy method - determines whether the player can buy a number of goods
     *                 based on the player's number of credits
     *
     * @param good the good to buy
     * @param quantityToBuy the quantity of the good to buy
     * @return whether the player can or cannot buy the good(s)
     */
    public boolean canBuy(Goods good, int quantityToBuy) {
        Game game = Game.getInstance();
        return (Game.getInstance().getPlayer().getCredits() > (good.getPrice(game.getTech())
                * quantityToBuy)) &&
                ((game.getCargoSize() + quantityToBuy) <= game.getCargoCapacity());
    }

    /**
     * buy method - executes the action of buying a number of goods.
     *
     * @param good the good to buy
     * @param quantityToBuy the number of goods to buy
     */
    public void buy(Goods good, int quantityToBuy) {
        //Game game = Game.getInstance();
        if (canBuy(good, quantityToBuy)) {
            for (CargoItem c: Game.getInstance().getPlayer().getShipCargo()) {
                Goods goods = c.getGood();
                if (goods.equals(good)) {
                    //c.quantity += quantityToBuy;
                    //Log.d("Add", Integer.toString(quantityToBuy));
                    c.setQuantity(c.getQuantity() + quantityToBuy); ;
                    //Log.d("Add", c.good.getCode());
                   // Log.d("Add", Integer.toString(c.quantity));
                }
            }

            int playerCredits = Game.getInstance().getPlayer().getCredits();
            Game.getInstance().getPlayer().setCredits(playerCredits -
                    (good.getPrice(Game.getInstance().getSolarSystemLevel()) * quantityToBuy));
            Log.d("edit", Integer.toString(Game.getInstance().getPlayer().getCredits()));
        }

    }

    /**
     * sell method - executes the action of selling a number of goods.
     *
     * @param good the good to sell
     * @param quantityToSell the number of goods to sell
     */
    public void sell(Goods good, int quantityToSell) {
        Game game = Game.getInstance();
        if (canSell(good, quantityToSell)) {
            for (CargoItem c : game.getPlayer().getShipCargo()) {
                Goods goods = c.getGood();
                if (goods.equals(good)) {
                    c.setQuantity(c.getQuantity() - quantityToSell);
                    int currentCredits = game.getCredits();
                    game.getPlayer().setCredits(currentCredits +
                            good.getPrice(game.getSolarSystemLevel()));
                }
            }
        }
    }
    
    /**
     * pirateAttack method - executes action of pirate plundering the player's
     *                       cargo.
     *
     */
    public static void pirateAttack() {
        Game game = Game.getInstance();
        List<CargoItem> cargo = game.getPlayer().getShipCargo();
        for (CargoItem c: cargo) {
            c.setQuantity(0);
        }
    }
    
    /**
     * getCode method - returns the name of the good
     *
     * @return the name of the good
     */
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
