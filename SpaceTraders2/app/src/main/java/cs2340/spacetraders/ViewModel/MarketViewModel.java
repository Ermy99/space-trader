package cs2340.spacetraders.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import cs2340.spacetraders.Model.CargoItem;
import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.Goods;

public class MarketViewModel extends AndroidViewModel {
    Game game;

    public MarketViewModel(Application application) {
        super(application);
        game = Game.getInstance();
    }

    public void buyGood(Goods goods, int quantity) {
        if (goods.canBuy(goods, quantity)) {
            goods.buy(goods, quantity);
        }
    }

    public boolean canBuy(Goods goods, int quantity) {
        return goods.canBuy(goods, quantity);
    }

    public void sellGood(Goods goods, int quantity) {
        if (goods.canSell(goods, quantity)) {
            goods.sell(goods,quantity);
        }
    }

    public boolean canSell(Goods goods, int quantity) {
        return goods.canSell(goods, quantity);
    }

}
