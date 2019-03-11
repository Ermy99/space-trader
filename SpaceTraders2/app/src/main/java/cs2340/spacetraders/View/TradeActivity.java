package cs2340.spacetraders.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.MarketViewModel;

public class TradeActivity extends AppCompatActivity {

    public MarketViewModel marketViewModel;
    private Goods good;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);
    }

    public void onSell(View view ) {
        marketViewModel.buyGood(good);
    }

    public void onBuy(View view) {
        marketViewModel.sellGood(good);
    }


}
