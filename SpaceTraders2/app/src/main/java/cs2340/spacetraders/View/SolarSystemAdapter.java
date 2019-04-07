package cs2340.spacetraders.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.Player;
import cs2340.spacetraders.Model.SolarSystems;
import cs2340.spacetraders.R;

/**
 * SolarSystemAdapter.java
 * Adapter for the solar systems.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class SolarSystemAdapter extends RecyclerView.Adapter<SolarSystemAdapter.SolarSystemViewHolder> {

    private List<SolarSystems> solarSystemList = Arrays.asList(SolarSystems.values());

    private OnSolarSystemClickListener listener;

    private final Game game = Game.getInstance();


    @NonNull
    @Override
    public SolarSystemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.solar_system_item, parent, false);

        return new SolarSystemViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull SolarSystemViewHolder holder, int position) {
        SolarSystems solarSystem = solarSystemList.get(position);
        holder.solarSystemName.setText(solarSystem.getName());
        Player player = game.getPlayer();
        //SolarSystems solarSystems = player.getSolarSystems();

        holder.solarSystemDistance.setText(Integer.toString(solarSystem.getDistance(solarSystem))); //fix logic
    }

    @Override
    public int getItemCount() {
        Log.d("APP","size is" + solarSystemList.size());
        return solarSystemList.size();
    }
    
    /**
     * setSolarSystemList method - creates a new list of solar systems
     *
     * @param solarSystems the new list of solar systems
     */
    public void setSolarSystemList(List<SolarSystems> solarSystems) {
        solarSystemList = solarSystems;
        notifyDataSetChanged();
    }

    class SolarSystemViewHolder extends RecyclerView.ViewHolder {

        //ImageView image;
        final TextView solarSystemName;
        final TextView solarSystemDistance;

        public SolarSystemViewHolder(@NonNull View itemView) {
            super(itemView);
            //image = itemView.findViewById(R.id.image);
            solarSystemName = itemView.findViewById(R.id.solar_system_name);
            solarSystemDistance = itemView.findViewById(R.id.solar_system_distance);
            //parentLayout = itemView.findViewById(R.id.parent_layout);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onSolarSystemClicked(solarSystemList.get(position));
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
    
    /**
     * OnSolarSystemClickListener interface - creates interface for
     *                                        solar system.
     *
     */
    public interface OnSolarSystemClickListener {
    
        /**
         * onSolarSystemClicked method - abstract listener method.
         *
         * @param solarSystem the solar system that is clicked
         */
        void onSolarSystemClicked(SolarSystems solarSystem);
    
    }
    
    /**
     * setOnSolarSystemClickListener method - listens to which solar system
     *                                        is clicked.
     *
     * @param listener the click listener
     */
    public void setOnSolarSystemClickListener(OnSolarSystemClickListener listener) {
        this.listener = listener;
    }

}
