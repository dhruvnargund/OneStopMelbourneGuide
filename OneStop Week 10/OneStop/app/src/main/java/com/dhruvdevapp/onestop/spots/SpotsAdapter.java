package com.dhruvdevapp.onestop.spots;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvdevapp.onestop.R;

import java.util.ArrayList;

public class SpotsAdapter extends RecyclerView.Adapter<SpotsAdapter.SpotsViewHolder> {

    SpotsClickInterface spotsClickInterface;
    ArrayList<Spots> spotsArrayList = new ArrayList<>();

    public SpotsAdapter(ArrayList<Spots> spotsArrayList,SpotsClickInterface spotsClickInterface) {
        this.spotsClickInterface = spotsClickInterface;
        this.spotsArrayList = spotsArrayList;
    }


    @NonNull
    @Override
    public SpotsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_general_list_item, parent, false);
        return new SpotsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpotsAdapter.SpotsViewHolder holder, int position) {
        Spots spots = spotsArrayList.get(position);
        holder.image.setImageResource(spots.getImage());
        holder.title.setText(spots.getTitle());
        holder.description.setText(spots.getDescription());
        holder.rating.setRating(spots.getRating());
    }

    @Override
    public int getItemCount() {
        return spotsArrayList.size();
    }

    public class SpotsViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView description;
        RatingBar rating;

        public SpotsViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_view_spot_item);
            title = itemView.findViewById(R.id.text_view_spot_item_title);
            description = itemView.findViewById(R.id.text_view_spot_item_description);
            rating = itemView.findViewById(R.id.rating_bar_spot_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    spotsClickInterface.onSpotClick(getAdapterPosition());
                }
            });
        }
    }
}
