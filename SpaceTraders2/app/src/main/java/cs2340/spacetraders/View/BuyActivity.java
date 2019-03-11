package cs2340.spacetraders.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.MarketViewModel;

public class BuyActivity extends AppCompatActivity {

    private Goods good;
    public MarketViewModel marketViewModel;
    public static final String GOOD_NAME = "GOOD_NAME";


    /*
        Views
     */
    private TextView goodName;
    private Spinner amountSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);


        goodName = findViewById(R.id.good_name);
        //amountSpinner = findViewById(R.id.amount_spinner);
        good = (Goods) getIntent().getSerializableExtra(GOOD_NAME);
        goodName.setText(good.getCode());
    }

    public void onSell(View view ) {
        marketViewModel.buyGood(good);
    }

    public void onBuy(View view) {
        marketViewModel.sellGood(good);
    }


}
