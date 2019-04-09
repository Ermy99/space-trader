package cs2340.spacetraders.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.R;

/**
 * MainActivity.java
 * Represents the screen with the start button.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    private SimpleItemRecyclerViewAdapter adapter;

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();
        adapter = new SimpleItemRecyclerViewAdapter(
                game.player.getName(),
                game.player.getPilotPoints(),
                game.player.getEngineeringPoints(),
                game.player.getFighterPoints(),
                game.player.getTraderPoints()
        );

        //This code sets up our button at bottom of screen to start game
        Button start =  findViewById(R.id.button_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this, ConfigurationActivity.class);
                startActivity(mainIntent);
            }
        });

    }

    /* grab the resume state so we can reshow the data in the list since we most likely just came
    from
   adding a new student.
    */
    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();

    }

    /* Next two methods handle the menu options */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private String name;
        private int pilotPoints;
        private int engineeringPoints;
        private int fighterPoints;
        private int traderPoints;

        private final List<Object> list;

        /**
         * SimpleItemRecyclerViewAdapter Constructor - creates a recycler-view
         *                                             adapter using user
         *                                             configuration info.
         *
         * @param name the name of the player
         * @param pilotPoints the pilot points the player input
         * @param engineeringPoints the engineering points the player input
         * @param fighterPoints the fighter points the player input
         * @param traderPoints the trader points the player input
         */
        SimpleItemRecyclerViewAdapter(String name,
                                      int pilotPoints,
                                      int engineeringPoints,
                                      int fighterPoints,
                                      int traderPoints) {

            list = new ArrayList<Object>();
            list.add(name);
            list.add(pilotPoints);
            list.add(engineeringPoints);
            list.add(fighterPoints);
            list.add(traderPoints);

        }

        /**
         * updateList method - updates the player configuration info.
         *
         * @param name the new name to replace existing name
         * @param pilotPoints new pilot points to replace existing points
         * @param engineeringPoints new engineering points to replace existing points
         * @param fighterPoints new fighter points to replace existing points
         * @param traderPoints new trader points to replace existing points
         */
        public void updateList(String name,
                               int pilotPoints,
                               int engineeringPoints,
                               int fighterPoints,
                               int traderPoints) {

            list.set(0, name);
            list.set(1, pilotPoints);
            list.set(2, engineeringPoints);
            list.set(3, fighterPoints);
            list.set(4, traderPoints);

            notifyDataSetChanged();

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.game_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = list.get(position);
            holder.mIdView.setText(list.get(position).toString());
            holder.mContentView.setText(list.get(position).toString());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d("MY APPLICATION", holder.mItem.toString());
                    Context context = v.getContext();
                    //Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
                    //intent.putExtra(StudentDetailFragment.ARG_ITEM_ID, holder.mItem.toString());

                    //context.startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            final View mView;
            final TextView mIdView;
            final TextView mContentView;
            Object mItem;

            /**
             * ViewHolder Constructor - constructing a new view
             *
             * @param view the current screen on the phone
             */
            ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = view.findViewById(R.id.id);
                mContentView = view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }


    }

}