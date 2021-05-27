package com.dhruvdevapp.onestop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MostAdapter extends RecyclerView.Adapter<MostAdapter.MostViewHolder> {

    //  Creating an ArrayList of MostViewedItems to put in the RecyclerView
    ArrayList<MostViewedItems> mostViewedItemsArray;
    MostViewedClick mostViewedClick;

    //  The Constructor is so that java can actually take some input
    public MostAdapter(ArrayList<MostViewedItems> mostViewedItemsArray, MostViewedClick mostViewedClick) {
        this.mostViewedItemsArray = mostViewedItemsArray;
        this.mostViewedClick = mostViewedClick;
    }

    @NonNull

    @Override
    public MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_card_design, parent, false);
        return new MostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MostAdapter.MostViewHolder holder, int position) {
        MostViewedItems mostViewedItems = mostViewedItemsArray.get(position);
        // Here we bring the images to this class to set them
        holder.mostImage.setImageResource(mostViewedItems.getMostImage());
        holder.mostTitle.setText(mostViewedItems.getMostName());
        holder.mostDescription.setText(mostViewedItems.getMostDescription());

    }

    @Override
    public int getItemCount() {

        return mostViewedItemsArray.size();
    }

    //  This will hold the design we designed for the item
    public class MostViewHolder extends RecyclerView.ViewHolder {

        //  Our two views of the item
        ImageView mostImage;
        TextView mostTitle;
        TextView mostDescription;

        public MostViewHolder(@NonNull View itemView) {
            super(itemView);

            //  Initializing the views
            mostImage = itemView.findViewById(R.id.image_view_recycler_most);
            mostTitle = itemView.findViewById(R.id.text_view_recycler_most);
            mostDescription = itemView.findViewById(R.id.text_view_most_description);

            itemView.setOnClickListener(v -> mostViewedClick.onMostViewClick(getAdapterPosition()));
        }
    }
}
