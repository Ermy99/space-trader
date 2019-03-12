package cs2340.spacetraders.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import cs2340.spacetraders.Model.CargoItem;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.MarketViewModel;

public class SellActivity extends AppCompatActivity {

    private Goods good;
    public MarketViewModel marketViewModel;
    public static final String CARGO_NAME = "GOOD_NAME";


    /*
        Views
     */
    private TextView cargoName;
    private Spinner amountSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);


        cargoName = findViewById(R.id.cargo_item_name);
        //amountSpinner = findViewById(R.id.amount_spinner);
        good = (Goods) getIntent().getSerializableExtra(CARGO_NAME);
        cargoName.setText(good.getCode());
    }

    public void onSell(View view ) {
        marketViewModel.buyGood(good);
    }



}
