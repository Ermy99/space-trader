package cs2340.spacetraders.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import cs2340.spacetraders.Model.Goods;

/**
 * MarketViewModel.java
 * ViewModel pairing model and view for the marketplace.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class MarketViewModel extends AndroidViewModel {
    // --Commented out by Inspection (4/5/2019 8:24 PM):Game game;
    
    /**
     * MarketViewModel Constructor - creates a new MarketVM object.
     *
     * @param application the application passed in
     */
    public MarketViewModel(Application application) {
        super(application);
        //game = Game.getInstance();
    }
    
    /**
     * buyGood method - conveys buying information from view to model.
     *
     * @param goods the goods to buy
     * @param quantity the quantity of goods to buy
     */
    public void buyGood(Goods goods, int quantity) {
        if (goods.canBuy(goods, quantity)) {
            goods.buy(goods, quantity);
        }
    }
    
    /**
     * canBuy method - returns whether or not the player can buy a number
     *                 of goods.
     *
     * @param goods the goods to buy
     * @param quantity the quantity of goods to buy
     * @return whether the player can buy the number of goods
     */
    public boolean canBuy(Goods goods, int quantity) {
        return goods.canBuy(goods, quantity);
    }
    
    /**
     * sellGood method - conveys selling information from view to model.
     *
     * @param goods the goods to sell
     * @param quantity the number of goods to sell
     */
    public void sellGood(Goods goods, int quantity) {
        if (goods.canSell(goods, quantity)) {
            goods.sell(goods,quantity);
        }
    }
    
    /**
     * canSell method - returns whether or not the player can sell a number
     *                  of goods.
     *
     * @param goods the goods to sell
     * @param quantity the quantity of goods to sell
     * @return whether the player can sell the number of goods
     */
    public boolean canSell(Goods goods, int quantity) {
        return goods.canSell(goods, quantity);
    }

}
