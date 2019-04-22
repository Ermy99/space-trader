package cs2340.spacetraders.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import cs2340.spacetraders.Model.CargoItem;
import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.Model.Player;
import cs2340.spacetraders.R;

/**
 * CargoItemAdapter.java
 * Adapter for CargoItems
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class CargoItemAdapter extends RecyclerView.Adapter<CargoItemAdapter.CargoItemViewHolder> {

    private List<CargoItem> cargoList = Game.getInstance().getShipCargo();

    private OnCargoItemClickListener listener;


    @NonNull
    @Override
    public CargoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cargo_item, parent, false);

        return new CargoItemViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull CargoItemViewHolder holder, int position) {
        CargoItem cargoItem = cargoList.get(position);
        //Goods good = cargoItem.getGood();
        int quantity = cargoItem.getQuantity();
        holder.cargoItemName.setText(cargoItem.getGoodCode());
        //Player player = Game.getInstance().player;
        //Game game = Game.getInstance();
        holder.cargoItemPrice.setText(Integer.toString(cargoItem.getGoodPrice()));
        holder.cargoItemQuantity.setText(Integer.toString(quantity));


    }

    @Override
    public int getItemCount() {
        //Log.d("APP","size is" + cargoList.size());
        return 10;
    }
    
    /**
     * setCargoList method - replaces existing cargo list with new list of
     *                       cargo items.
     *
     * @param cargoItems the new list to replace existing cargo items list
     */
    public void setCargoList(List<CargoItem> cargoItems) {
        this.cargoList = cargoItems;
        notifyDataSetChanged();
    }

    class CargoItemViewHolder extends RecyclerView.ViewHolder {

        //ImageView image;
        final TextView cargoItemName;
        final TextView cargoItemQuantity;
        final TextView cargoItemPrice;

        CargoItemViewHolder(@NonNull View itemView) {
            super(itemView);
            //image = itemView.findViewById(R.id.image);
            cargoItemName = itemView.findViewById(R.id.cargo_item_name);
            cargoItemPrice = itemView.findViewById(R.id.cargo_item_price);
            cargoItemQuantity = itemView.findViewById(R.id.cargo_item_quantity);

            //parentLayout = itemView.findViewById(R.id.parent_layout);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if ((listener != null) && (position != RecyclerView.NO_POSITION)) {
                        listener.onCargoItemClicked(cargoList.get(position));
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
    
    /**
     * OnCargoItemClickListener interface - interface for cargo items list
     *
     */
    public interface OnCargoItemClickListener {
    
        /**
         * onCargoItemClicked method - abstract method for cargo items list
         *
         * @param cargoItem the cargo item that is clicked from the list
         */
        void onCargoItemClicked(CargoItem cargoItem);
    
    }
    
    /**
     * setonCargoItemClickListener method - click listener for cargo items
     *
     * @param listener click listener for cargo items
     */
    public void setonCargoItemClickListener(OnCargoItemClickListener listener) {
        this.listener = listener;
    }

}
