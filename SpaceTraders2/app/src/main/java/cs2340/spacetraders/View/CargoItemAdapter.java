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

import cs2340.spacetraders.Model.CargoItem;
import cs2340.spacetraders.Model.Game;
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;

public class CargoItemAdapter extends RecyclerView.Adapter<CargoItemAdapter.CargoItemViewHolder> {

    private List<CargoItem> cargoList = Game.getInstance().shipCargo;

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
        Goods good = cargoItem.getGood();
        int quantity = cargoItem.getQuantity();
        Log.d("APP", "quantity issss" + quantity);

        holder.cargoItemName.setText(good.getCode());
        holder.cargoItemPrice.setText(Integer.toString(good.getPrice(Game.getInstance().solarSystemLevel)));
        holder.cargoItemQuantity.setText(Integer.toString(quantity));


    }

    @Override
    public int getItemCount() {
        //Log.d("APP","size is" + cargoList.size());
        return 10;
    }

    public void setCargoList(List<CargoItem> cargoItems) {
        this.cargoList = cargoItems;
        notifyDataSetChanged();
    }

    class CargoItemViewHolder extends RecyclerView.ViewHolder {

        //ImageView image;
        TextView cargoItemName;
        TextView cargoItemQuantity;
        TextView cargoItemPrice;

        public CargoItemViewHolder(@NonNull View itemView) {
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

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onCargoItemClicked(cargoList.get(position));
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }

    public interface OnCargoItemClickListener {
        void onCargoItemClicked(CargoItem cargoItem);
    }

    public void setonCargoItemClickListener(OnCargoItemClickListener listener) {
        this.listener = listener;
    }

}
