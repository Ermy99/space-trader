package cs2340.spacetraders;
import org.junit.Test;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.Model.Player;
import cs2340.spacetraders.Model.SolarSystems;

import static org.junit.Assert.*;

public class SanghaviJUnitTest {

    @Test
    public void testCanBuy() {
        Game game = Game.getInstance();
        Player player = new Player("Ed", 4, 4,
                4, 4, SolarSystems.SOMEBI);

        //price and number of goods are okay
        game.setPlayer(player);
        Goods goods = Goods.Water;
        Boolean val1 = goods.canBuy(goods, 1);
        assertEquals(true, val1);

        //price of goods is too high
        Goods goods2 = Goods.Narcotics;
        Boolean val2 = goods2.canBuy(goods2, 3);
        assertEquals(false, val2);

        //the quantity that you want to buy is too high
        Goods goods3 = Goods.Water;
        Boolean val3 = goods3.canBuy(goods3, 16);
        assertEquals(false, val3);
    }

}
