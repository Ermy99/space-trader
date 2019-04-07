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
import cs2340.spacetraders.Model.Goods;
import cs2340.spacetraders.R;

/**
 * GoodAdapter.java
 * Adapter for goods.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public class GoodAdapter extends
        RecyclerView.Adapter<GoodAdapter.GoodViewHolder> {

    private List<Goods> goodList = Arrays.asList(Goods.values());

    private OnGoodClickListener listener;

    private final Game game = Game.getInstance();


    @NonNull
    @Override
    public GoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.good_item, parent, false);

        return new GoodViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull GoodViewHolder holder, int position) {
        Goods good = goodList.get(position);
        holder.goodName.setText(good.getCode());
        //Player player = game.getPlayer();
        //SolarSystems solarSystems = player.getSolarSystems();

        holder.goodPrice.setText(Integer.toString(good.getPrice(game.getPlayer().getSolarSystems().getTech().ordinal())));
    }

    @Override
    public int getItemCount() {
        Log.d("APP","size is" + goodList.size());
        return goodList.size();
    }
    
    /**
     * setGoodList method - modifies existing goods list with new goods list
     *
     * @param goods the new list of goods
     */
    public void setGoodList(List<Goods> goods) {
        notifyDataSetChanged();
        goodList = goods;
        notifyDataSetChanged();
    }

    class GoodViewHolder extends RecyclerView.ViewHolder {

        //ImageView image;
        final TextView goodName;
        final TextView goodPrice;

        public GoodViewHolder(@NonNull View itemView) {
            super(itemView);
            //image = itemView.findViewById(R.id.image);
            goodName = itemView.findViewById(R.id.good_name);
            goodPrice = itemView.findViewById(R.id.good_price);
            //parentLayout = itemView.findViewById(R.id.parent_layout);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    notifyDataSetChanged();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        notifyDataSetChanged();
                        listener.onGoodClicked(goodList.get(position));
                    }
                }
            });
        }
    }
    
    /**
     * onGoodClickListener interface - interface for the listener
     *
     */
    public interface OnGoodClickListener {
        void onGoodClicked(Goods good);
    }
    
    /**
     * setOnGoodClickListener method - sets a new listener replacing the
     *                                 existing listener.
     *
     * @param listener the new listener to replace the old listener
     */
    public void setOnGoodClickListener(OnGoodClickListener listener) {
        this.listener = listener;
    }

}
