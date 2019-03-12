package cs2340.spacetraders.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.GameDifficulty;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.MarketViewModel;
import cs2340.spacetraders.ViewModel.PlayerViewModel;

public class BuyActivity extends AppCompatActivity {

    private Goods good;
    public MarketViewModel marketViewModel;
    public static final String GOOD_NAME = "GOOD_NAME";
    public Game game = Game.getInstance();


    /*
        Views
     */
    private TextView goodName;
    private Spinner amountSpinner;
    private int amountToBuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);


        goodName = findViewById(R.id.good_name);
        amountSpinner = findViewById(R.id.amount_spinner);

        ArrayList<Integer> quantities = new ArrayList<>();
        quantities.add(1);
        quantities.add(2);
        quantities.add(3);
        quantities.add(4);
        quantities.add(5);

        ArrayAdapter<Integer> adapterQuantities = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, quantities);
        adapterQuantities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        amountSpinner.setAdapter(adapterQuantities);

        good = (Goods) getIntent().getSerializableExtra(GOOD_NAME);
        Log.d("good", good.getCode());
        goodName.setText(good.getCode());
        amountToBuy = (int) amountSpinner.getSelectedItem();
        marketViewModel = ViewModelProviders.of(this).get(MarketViewModel.class);

    }


    public void onBuy(View view) {
        if (marketViewModel.canBuy(good, amountToBuy)) {
            marketViewModel.buyGood(good, amountToBuy);
        } else {
            Toast.makeText(BuyActivity.this, "Can't buy!", Toast.LENGTH_SHORT).show();
        }
    }


}
