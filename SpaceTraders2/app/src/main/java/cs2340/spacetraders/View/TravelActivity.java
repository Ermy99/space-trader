package cs2340.spacetraders.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.Model.SolarSystems;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.MarketViewModel;
import cs2340.spacetraders.ViewModel.TravelViewModel;

/*
The screen with the buy and sell buttons
 */
public class TravelActivity extends AppCompatActivity {


    private SolarSystemAdapter adapter;
    public TravelViewModel travelViewModel;

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

//    public void onTravel(View view) {
//        SolarSystems solarSystems;
//        if (travelViewModel.canTravel(solarSystems)) {
//            travelViewModel.travel(solarSystems);
//        } else {
//            Toast.makeText(TravelActivity.this, "You don't have enough fuel to travel there!", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.setSolarSystemList(Arrays.asList(SolarSystems.values()));

        adapter.setOnSolarSystemClickListener(new SolarSystemAdapter.OnSolarSystemClickListener() {
            @Override
            public void onSolarSystemClicked(SolarSystems solarSystem) {
                if (travelViewModel.canTravel(solarSystem)) {
                    travelViewModel.travel(solarSystem);
                    Log.d("current location", Game.getInstance().getPlayer().getSolarSystems().toString());
                    Log.d("fuel", Integer.toString(Game.getInstance().getPlayer().getFuel()));

                } else {
                    Toast.makeText(TravelActivity.this, "You don't have enough fuel to travel there!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
