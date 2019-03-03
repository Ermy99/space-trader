package cs2340.spacetraders.Model;

import android.util.Log;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class Market {
    SolarSystems solarSystems;
    List<Goods> marketGoods;
    Player player;

    public Market(SolarSystems solarSystems, Player player) {
        this.solarSystems = solarSystems;
        this.player = player;
    }

    public void setMarketGoods() {
        this.marketGoods = new ArrayList<>();
        int length = Goods.values().length;
        for (int i = 0; i < length; i++) {
            marketGoods.add(Goods.values()[i]);
        }
    }

    public int goodPrice(Goods good) {
        int price =  good.getBasePrice() + 3 * 2 * (good.getPriceInc() *
                (solarSystems.getTech().ordinal() - good.getMinTechLevelToProd()));
        return price;
    }

    //if the player can buy the goods
    public boolean canBuy(Goods good) {
        return player.getCredits() > goodPrice(good) &&
               player.getShip().getCargoSize() + 1 < player.getShip().getCargoSize();
    }
    //if the player can sell the goods
    public boolean canSell(int amountToSell, Goods good) {
        if(good == Goods.Water && amountToSell <= player.getShip().getCargo().getWaterAmount()) {
            return true;
        } else if (good == Goods.Furs && amountToSell <= player.getShip().getCargo().getFurAmount()) {
            return true;
        } else if (good == Goods.Food && amountToSell <= player.getShip().getCargo().getFoodAmount()) {
            return true;
        } else if (good == Goods.Ore && amountToSell <= player.getShip().getCargo().getOreAmount()) {
            return true;
        } else if (good == Goods.Games && amountToSell <= player.getShip().getCargo().getGamesAmount()) {
            return true;
        } else if (good == Goods.Firearms && amountToSell <= player.getShip().getCargo().getFirearmsAmount()) {
            return true;
        } else if (good == Goods.Medicine && amountToSell <= player.getShip().getCargo().getMedicineAmount()) {
            return true;
        } else if (good == Goods.Machines && amountToSell <= player.getShip().getCargo().getMachineAmount()){
            return true;
        } else if (good == Goods.Narcotics && amountToSell <= player.getShip().getCargo().getNarcoticsAmount()){
            return true;
        } else if (good == Goods.Robots && amountToSell <= player.getShip().getCargo().getRobotsAmount()) {
            return true;
        } else {
            return false;
        }
    }
    
}
