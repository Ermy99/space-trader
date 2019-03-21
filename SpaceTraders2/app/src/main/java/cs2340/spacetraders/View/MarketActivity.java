package cs2340.spacetraders.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;
/*
The screen with the buy and sell buttons
 */
public class MarketActivity extends AppCompatActivity {

    private GoodAdapter adapter;

    /** a key for passing data */
    public static final String GOOD_NAME = "GOOD_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        /*
         Set up our recycler view by grabbing the layout for a single item
         */
        RecyclerView recyclerView = findViewById(R.id.goods_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapter = new GoodAdapter();
        recyclerView.setAdapter(adapter);

        }

        @Override
        public void onResume() {
            super.onResume();
            adapter.setGoodList(Arrays.asList(Goods.values()));

            adapter.setOnGoodClickListener(new GoodAdapter.OnGoodClickListener() {
                @Override
                public void onGoodClicked(Goods good) {
                    Intent intent = new Intent(MarketActivity.this, BuyActivity.class);
                    intent.putExtra(GOOD_NAME, good);
                    startActivity(intent);
                }
            });
        }



}