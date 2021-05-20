package com.dhruvdevapp.onestop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MuseumsAdapter extends RecyclerView.Adapter<MuseumsAdapter.MuseumViewHolder> {
    ArrayList<MuseumItem> museumItemArrayList = new ArrayList<>();

    public MuseumsAdapter(ArrayList<MuseumItem> museumItemArrayList) {
        this.museumItemArrayList = museumItemArrayList;
    }

    @NonNull
    @Override
    public MuseumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.museums_card_design, parent, false);
        MuseumViewHolder museumViewHolder = new MuseumViewHolder(view);
        return museumViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MuseumsAdapter.MuseumViewHolder holder, int position) {
        MuseumItem museumItem = museumItemArrayList.get(position);
        holder.museumImage.setImageResource(museumItem.getImage());
        holder.museumTitle.setText(museumItem.getTitle());
        holder.museumDescription.setText(museumItem.getDescription());

    }

    @Override
    public int getItemCount() {
        return museumItemArrayList.size();
    }

    public static class MuseumViewHolder extends RecyclerView.ViewHolder {
        ImageView museumImage;
        TextView museumTitle;
        TextView museumDescription;

        public MuseumViewHolder(@NonNull View itemView) {
            super(itemView);
            museumImage = itemView.findViewById(R.id.image_view_museum);
            museumTitle = itemView.findViewById(R.id.text_view_museum_title);
            museumDescription = itemView.findViewById(R.id.text_view_museum_description);
        }
    }
}
