package cs2340.spacetraders.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.MarketViewModel;

/**
 * SellActivity.java
 * Creates the sell screen in the game.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class SellActivity extends AppCompatActivity {

    private Goods good;
    public MarketViewModel marketViewModel;
    public static final String CARGO_NAME = "CARGO_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        //amountSpinner = findViewById(R.id.amount_spinner);

        TextView cargoName = findViewById(R.id.cargo_item_name);
        good = (Goods) getIntent().getSerializableExtra(CARGO_NAME);
        cargoName.setText(good.getCode());

//        ArrayAdapter<Integer> adapterQuantities = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, quantities);
//        adapterQuantities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        amountSpinner.setAdapter(adapterQuantities);
//        amountToSell = (Integer) amountSpinner.getSelectedItem();
        //amountToSell = amount.intValue();

        marketViewModel = ViewModelProviders.of(this).get(MarketViewModel.class);
    }
    
    /**
     * onSell method - sells a good that the player chooses to sell.
     *
     * @param view the current screen
     */
    public void onSell(View view) {
//        Log.d("good", good.getCode());
//        Log.d("Amount", String.valueOf(amountToSell));
        EditText amount = findViewById(R.id.amount_to_sell);
        //private Spinner amountSpinner;
        int amountToSell = Integer.parseInt(amount.getText().toString());
        if (marketViewModel.canSell(good, amountToSell)) {
            marketViewModel.sellGood(good, amountToSell);
        } else {
            Toast.makeText(SellActivity.this, "Can't sell!", Toast.LENGTH_SHORT).show();
        }
    }


}
