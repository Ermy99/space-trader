package cs2340.spacetraders.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.MarketViewModel;

/**
 * BuyActivity.java
 * Represents the 'buy' screen in Activity
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class BuyActivity extends AppCompatActivity {

    private Goods good;
    public MarketViewModel marketViewModel;
    public static final String GOOD_NAME = "GOOD_NAME";
    // --Commented out by Inspection (4/5/2019 8:23 PM):public Game game = Game.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);


        /*
        Views
     */
        TextView goodName = findViewById(R.id.good_name);
        //amountSpinner = findViewById(R.id.amount_spinner);


//        ArrayList<Integer> quantities = new ArrayList<>();
//        quantities.add(1);
//        quantities.add(2);
//        quantities.add(3);
//        quantities.add(4);
//        quantities.add(5);
//
//        ArrayAdapter<Integer> adapterQuantities = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, quantities);
//        adapterQuantities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        amountSpinner.setAdapter(adapterQuantities);
//        amountToBuy = (Integer) amountSpinner.getSelectedItem();
        //amountSpinner.setSelection(amountToBuy);

        good = (Goods) getIntent().getSerializableExtra(GOOD_NAME);
        //Log.d("good", good.getCode());
        goodName.setText(good.getCode());
        marketViewModel = ViewModelProviders.of(this).get(MarketViewModel.class);

    }
    
    /**
     * onBuy method - Method called when attempting to buy an item, then buys
     *                the item if player canBuy
     *
     * @param view The 'buy' screen
     */
    public void onBuy(View view) {
        EditText amount = findViewById(R.id.amount_to_buy);
        int amountToBuy = Integer.parseInt(amount.getText().toString());
        if (marketViewModel.canBuy(good, amountToBuy)) {
            Log.d("goods bought", Integer.toString(amountToBuy));
            marketViewModel.buyGood(good, amountToBuy);
        } else {
            Toast.makeText(BuyActivity.this, "Can't buy!", Toast.LENGTH_SHORT).show();
        }
    }


}
