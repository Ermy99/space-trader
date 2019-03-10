package cs2340.spacetraders.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cs2340.spacetraders.R;
/*
Main game screen
The screen with the four buttons on it.
 */
public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button marketButton =  findViewById(R.id.market_button);
        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent marketIntent = new Intent(GameActivity.this, MarketActivity.class);
                startActivity(marketIntent);
            }
        });
    }
}
