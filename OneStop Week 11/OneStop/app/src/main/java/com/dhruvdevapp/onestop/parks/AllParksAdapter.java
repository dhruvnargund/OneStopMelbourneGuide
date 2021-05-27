package com.dhruvdevapp.onestop.parks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvdevapp.onestop.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AllParksAdapter extends RecyclerView.Adapter<AllParksAdapter.AllParksViewHolder> {

    ParksClickInterface parksClickInterface;
    ArrayList<Park> parkArrayList;

    public AllParksAdapter(ArrayList<Park> parkArrayList, ParksClickInterface parksClickInterface) {
        this.parkArrayList = parkArrayList;
        this.parksClickInterface = parksClickInterface;
    }

    @NonNull
    @NotNull
    @Override
    public AllParksViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_general_list_item, parent, false);
        return new AllParksAdapter.AllParksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AllParksAdapter.AllParksViewHolder holder, int position) {
        Park park = parkArrayList.get(position);
        holder.image.setImageResource(park.getImage());
        holder.title.setText(park.getTitle());
        holder.description.setText(park.getDescription());
        holder.rating.setRating(park.getRating());
    }

    @Override
    public int getItemCount() {
        return parkArrayList.size();
    }

    public class AllParksViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView description;
        RatingBar rating;

        public AllParksViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_view_spot_item);
            title = itemView.findViewById(R.id.text_view_spot_item_title);
            description = itemView.findViewById(R.id.text_view_spot_item_description);
            rating = itemView.findViewById(R.id.rating_bar_spot_item);

            itemView.setOnClickListener(v -> parksClickInterface.onItemClickPark(getAdapterPosition()));
        }
    }
}
