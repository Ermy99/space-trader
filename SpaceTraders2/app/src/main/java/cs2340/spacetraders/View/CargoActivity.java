package cs2340.spacetraders.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import cs2340.spacetraders.Model.CargoItem;
import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.R;

/**
 * CargoActivity.java
 * Represents the screen with 'buy' and 'sell' buttons.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class CargoActivity extends AppCompatActivity {
    
    private CargoItemAdapter adapter;

    /** a key for passing data */
    private static final String CARGO_NAME = "CARGO_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo);
        //initImageBitmaps();
        
        /*
         Set up our recycler view by grabbing the layout for a single item
         */
        
        RecyclerView recyclerView = findViewById(R.id.cargo_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapter = new CargoItemAdapter();
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.setCargoList((Game.getInstance().shipCargo));

        adapter.setonCargoItemClickListener(new CargoItemAdapter.OnCargoItemClickListener() {
            @Override
            public void onCargoItemClicked(CargoItem cargoItem) {
                Intent intent = new Intent(CargoActivity.this, SellActivity.class);
                intent.putExtra(CARGO_NAME, cargoItem.getGood()); //// can only pass in good for some reason
                startActivity(intent);
            }
        });
    }
}
