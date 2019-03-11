package cs2340.spacetraders.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;
/*
The screen with the buy and sell buttons
 */
public class MarketActivity extends AppCompatActivity {


    private GoodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        //initImageBitmaps();
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
                Intent intent = new Intent(MarketActivity.this, TradeActivity.class);
                startActivity(intent);
            }
        });
    }


//    private void initImageBitmaps() {
//        //change this to get information from the enum
//        mNames.add("Water");
//        mNames.add("Fuel");
//
//        initRecyclerView();
//    }

//    private void initRecyclerView() {
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        GoodAdapter adapter = new GoodAdapter(mImageURLs, mNames, this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }


}
