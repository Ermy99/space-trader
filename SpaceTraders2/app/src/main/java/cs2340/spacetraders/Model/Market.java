package cs2340.spacetraders.Model;

import android.util.Log;

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
        int price =  good.getBasePrice() + 3 * 2* (good.getPriceInc() *
                (solarSystems.getTech().ordinal() - good.getMinTechLevelToProd()));
        return price;
    }

    //if the player can buy the goods
    public boolean canBuy(Goods good) {
        return player.getCredits() > goodPrice(good) &&
                player.getShip().getCargoSpace().length + 1 <  player.getShip().getCargoSize();
    }

    //if the player can sell the goods
    public boolean canSell() {
        return false;
    }
}
