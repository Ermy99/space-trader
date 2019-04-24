package cs2340.spacetraders.View;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import cs2340.spacetraders.R;
/**
 * SplashActivity.java
 * Represents the splash screen upon launching the app.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class SplashActivity extends AppCompatActivity {
    MediaPlayer song;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    int SPLASH_TIME_OUT = 4000;
    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        Intent splashIntent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(splashIntent);
        finish();
      }
    }, SPLASH_TIME_OUT);
  }

}