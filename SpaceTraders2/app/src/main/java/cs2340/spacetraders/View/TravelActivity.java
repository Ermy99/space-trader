package cs2340.spacetraders.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.SolarSystems;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.TravelViewModel;

/**
 * TravelActivity.java
 * Creates a screen where the player can choose a new destination.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class TravelActivity extends AppCompatActivity {


    private SolarSystemAdapter adapter;
    private TravelViewModel travelViewModel;

    /** a key for passing data */
    public static final String SOLAR_SYSTEM_NAME = "SOLAR_SYSTEM_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        //initImageBitmaps();
        /*
         Set up our recycler view by grabbing the layout for a single item
         */
        RecyclerView recyclerView = findViewById(R.id.solar_systems_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapter = new SolarSystemAdapter();
        recyclerView.setAdapter(adapter);

        travelViewModel = ViewModelProviders.of(this).get(TravelViewModel.class);


    }


    @Override
    public void onResume() {
        super.onResume();
        adapter.setSolarSystemList(Arrays.asList(SolarSystems.values()));

        adapter.setOnSolarSystemClickListener(new SolarSystemAdapter.OnSolarSystemClickListener() {
            @Override
            public void onSolarSystemClicked(SolarSystems solarSystem) {

                int n = travelViewModel.randomEvent();
                AlertDialog.Builder builder = new AlertDialog.Builder(TravelActivity.this);
                if (n == 0) {
                    //this is a pirateAttack
                    Log.d("ATTACK", "PIRATE");
                    builder.setTitle("Random Encounter");
                    builder.setMessage("Arrr! You have encountered a pirate! They took all your things :)");
                    builder.show();

                } else if (n == 1) {
                    //this is a magician event
                    Log.d("ATTACK", "MAGICIAN");
                    builder.setTitle("Random Encounter");
                    builder.setMessage("Oh wow! A magician just gave you some points!!");
                    builder.show();
                }
                
                if (travelViewModel.canTravel(solarSystem)) {
                    travelViewModel.travel(solarSystem);
                    Game game = Game.getInstance();
                    Log.d("current location", game.getSolarSystemName());
                    Log.d("fuel", Integer.toString(Game.getInstance().player.getFuel()));

                } else {
                    Toast.makeText(TravelActivity.this, "You don't have enough fuel to travel there!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
