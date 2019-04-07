package cs2340.spacetraders.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.PlayerViewModel;

/**
 * GameActivity.java
 * Main screen with status, travel, market, and cargo buttons.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class GameActivity extends AppCompatActivity {
    private Button saveButton;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String GAME = "game";
    PlayerViewModel playerViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        setContentView(R.layout.activity_game);

        Button statusButton =  findViewById(R.id.status_button);
        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent statusIntent = new Intent(GameActivity.this, StatusActivity.class);
                startActivity(statusIntent);
            }
        });

        Button travelButton =  findViewById(R.id.travel_button);
        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent travelIntent = new Intent(GameActivity.this, TravelActivity.class);
                startActivity(travelIntent);
            }
        });

        Button marketButton =  findViewById(R.id.market_button);
        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent marketIntent = new Intent(GameActivity.this, MarketActivity.class);
                startActivity(marketIntent);
            }
        });

        Button cargoButton =  findViewById(R.id.cargo_button);
        cargoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cargoIntent = new Intent(GameActivity.this, CargoActivity.class);
                startActivity(cargoIntent);
            }
        });

        saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerViewModel.saveGame();
            }
        });
    }

}
