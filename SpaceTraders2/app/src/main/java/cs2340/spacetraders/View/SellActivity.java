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

import cs2340.spacetraders.Model.CargoItem;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.MarketViewModel;

public class SellActivity extends AppCompatActivity {

    private Goods good;
    public MarketViewModel marketViewModel;
    public static final String CARGO_NAME = "CARGO_NAME";

    private TextView cargoName;
    private Spinner amountSpinner;
    private int amountToSell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        amountSpinner = findViewById(R.id.amount_spinner);

        cargoName = findViewById(R.id.cargo_item_name);
        amountSpinner = findViewById(R.id.sell_spinner);
        good = (Goods) getIntent().getSerializableExtra(CARGO_NAME);
        Log.d("APP", "EEEEEEEEEEwater");
        cargoName.setText(good.getCode());

        ArrayList<Integer> quantities = new ArrayList<>();
        quantities.add(1);
        quantities.add(2);
        quantities.add(3);
        quantities.add(4);
        quantities.add(5);

        ArrayAdapter<Integer> adapterQuantities = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, quantities);
        adapterQuantities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        amountSpinner.setAdapter(adapterQuantities);
        Integer amount = (Integer) amountSpinner.getSelectedItem();
        amountToSell = amount.intValue();

        marketViewModel = ViewModelProviders.of(this).get(MarketViewModel.class);
    }

    public void onSell(View view ) {
        Log.d("good", good.getCode());
        Log.d("Amount", String.valueOf(amountToSell));
        if (marketViewModel.canSell(good, amountToSell)) {
            marketViewModel.sellGood(good, amountToSell);
        } else {
            Toast.makeText(SellActivity.this, "Can't sell!", Toast.LENGTH_SHORT).show();
        }
    }


}
