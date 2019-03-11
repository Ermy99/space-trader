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

    public void buyGood(Goods goods) {
        if (goods.canBuy(goods, 1)) {
            goods.buy(goods,1);
        }
    }

    public void sellGood(Goods goods) {
        if (goods.canSell(goods, 1)) {
            goods.sell(goods,1);
        }
    }

}
