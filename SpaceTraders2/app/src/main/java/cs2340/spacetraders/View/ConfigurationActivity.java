package cs2340.spacetraders.View;

import android.content.Intent;
import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;


import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.GameDifficulty;
import cs2340.spacetraders.R;
import cs2340.spacetraders.ViewModel.PlayerViewModel;

/*
Player configuration screen
 */
public class ConfigurationActivity extends AppCompatActivity {

  //need to instantiate/assign a value to the playerViewModel

  private PlayerViewModel playerViewModel;

  private EditText name;
  private EditText pilotPoints;
  private EditText engineeringPoints;
  private EditText traderPoints;
  private EditText fighterPoints;
  private Spinner difficultyLevel;

//    public Player player;
//    public Game game;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_configuration);
      name = findViewById(R.id.player_name);
      pilotPoints = findViewById(R.id.pilot_points);
      engineeringPoints = findViewById(R.id.engineering_points);
      traderPoints = findViewById(R.id.trade_points);
      fighterPoints= findViewById(R.id.fighter_points);
      difficultyLevel = findViewById(R.id.difficulty);
      ArrayAdapter<GameDifficulty> adapterGameDifficulty = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Game.gameDifficulties);
      adapterGameDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      difficultyLevel.setAdapter(adapterGameDifficulty);
     // playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);

//        PlayerViewModel.onOK(name.getText().toString(), Integer.parseInt(pilotPoints.getText().toString()),
//                Integer.parseInt(engineeringPoints.getText().toString()), Integer.parseInt(traderPoints.getText().toString()),
//                Integer.parseInt(fighterPoints.getText().toString()));

      Button loadGame = findViewById(R.id.loadGame_button);
      loadGame.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              playerViewModel = new PlayerViewModel(getApplication());
              playerViewModel.loadSavedGame();
              Intent configIntent = new Intent(ConfigurationActivity.this, GameActivity.class);
              startActivity(configIntent);
          }
      });


  }

  /**
   * Button handler for the ok button
   * @param view the button that was pressed
   */
  public void onAdd(View view) {
      Button okay = findViewById(R.id.okay);
      Intent configIntent = new Intent(ConfigurationActivity.this, GameActivity.class);
      playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);

      if (PlayerViewModel.onOK(name.getText().toString(), Integer.parseInt(pilotPoints.getText().toString()),
            Integer.parseInt(engineeringPoints.getText().toString()),
            Integer.parseInt(traderPoints.getText().toString()),
            Integer.parseInt(fighterPoints.getText().toString()))) {
      playerViewModel.createPlayer(
              name.getText().toString(),
              Integer.parseInt(pilotPoints.getText().toString()),
              Integer.parseInt(engineeringPoints.getText().toString()),
              Integer.parseInt(traderPoints.getText().toString()),
              Integer.parseInt(fighterPoints.getText().toString()));
      playerViewModel.createGame(playerViewModel.getPlayer(), (GameDifficulty) difficultyLevel.getSelectedItem());
      startActivity(configIntent);

      } else {
          Toast.makeText(ConfigurationActivity.this, "Invalid inputs", Toast.LENGTH_SHORT).show();
      }

  }

//        player.setName(name.getText().toString());
//        player.setPilotPoints(Integer.parseInt(pilotPoints.getText().toString()));
//        player.setEngineeringPoints(Integer.parseInt(engineeringPoints.getText().toString()));
//        player.setTraderPoints(Integer.parseInt(traderPoints.getText().toString()));
//        player.setFighterPoints(Integer.parseInt(fighterPoints.getText().toString()));

}