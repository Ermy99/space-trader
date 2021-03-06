package cs2340.spacetraders.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;
import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.PlayerViewModel;

/**
 * StatusActivity.java
 * Displays player's statistics.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class StatusActivity extends AppCompatActivity {

    public PlayerViewModel playerViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Game game = Game.getInstance();

        TextView playerName = findViewById(R.id.player_name);
        TextView location = findViewById(R.id.location);
        TextView points = findViewById(R.id.points);
        TextView ship = findViewById(R.id.ship);
        TextView cargoSpace = findViewById(R.id.cargo_space);
        TextView fuel = findViewById(R.id.fuel);

        playerName.setText(game.getPlayer().getName());
        points.setText(Integer.toString(game.getCredits()));
        location.setText(game.getSolarSystemName());
        ship.setText(game.getShipName());
        cargoSpace.setText(Integer.toString(game.getCargoCapacity()
                - game.getCargoSize()));
        fuel.setText(Integer.toString(game.getPlayer().getFuel()));



    }

}
