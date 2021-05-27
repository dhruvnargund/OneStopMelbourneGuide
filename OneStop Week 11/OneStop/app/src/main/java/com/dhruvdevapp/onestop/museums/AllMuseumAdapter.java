package com.dhruvdevapp.onestop.museums;

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

public class AllMuseumAdapter extends RecyclerView.Adapter<AllMuseumAdapter.MuseumViewHolder> {

    MuseumClickInterface museumClickInterface;
    ArrayList<Museums> museumsArrayList;

    public AllMuseumAdapter(ArrayList<Museums> museumsArrayList, MuseumClickInterface museumClickInterface) {
        this.museumsArrayList = museumsArrayList;
        this.museumClickInterface = museumClickInterface;
    }

    @NonNull
    @Override
    public MuseumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_general_list_item, parent, false);
        return new AllMuseumAdapter.MuseumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull AllMuseumAdapter.MuseumViewHolder holder, int position) {
        Museums museums = museumsArrayList.get(position);
        holder.image.setImageResource(museums.getImage());
        holder.title.setText(museums.getTitle());
        holder.description.setText(museums.getDescription());
        holder.rating.setRating(museums.getRating());
    }

    @Override
    public int getItemCount() {
        return museumsArrayList.size();
    }

    public class MuseumViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView description;
        RatingBar rating;

        public MuseumViewHolder(@NonNull View itemView) {
            super(itemView);

            //  Rather than creating another recycler view it is better to use the same one as the format or the way it looks does not change
            image = itemView.findViewById(R.id.image_view_spot_item);
            title = itemView.findViewById(R.id.text_view_spot_item_title);
            description = itemView.findViewById(R.id.text_view_spot_item_description);
            rating = itemView.findViewById(R.id.rating_bar_spot_item);

            itemView.setOnClickListener(v -> museumClickInterface.onItemClickMuseum(getAdapterPosition()));
        }
    }
}
