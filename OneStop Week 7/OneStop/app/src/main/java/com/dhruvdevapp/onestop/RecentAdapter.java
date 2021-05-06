package com.dhruvdevapp.onestop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.RecentViewHolder> {

    //  Creating an ArrayList of RecentlyViewedItems to put in the RecyclerView
    ArrayList<RecentlyViewedItems> recentlyViewedItemsArray;

    //  The Constructor is so that java can actually take some input
    public RecentAdapter(ArrayList<RecentlyViewedItems> recentlyViewedItemsArray) {
        this.recentlyViewedItemsArray = recentlyViewedItemsArray;
    }

    @NonNull

    @Override
    public RecentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_card_design, parent, false);
        RecentViewHolder recentViewHolder = new RecentViewHolder(view);
        return recentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentAdapter.RecentViewHolder holder, int position) {
        RecentlyViewedItems recentlyViewedItems = recentlyViewedItemsArray.get(position);
        // Here we bring the images to this class to set them
        holder.recentImage.setImageResource(recentlyViewedItems.getRecentImage());
        holder.recentTitle.setText(recentlyViewedItems.getRecentName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //  This will hold the design we designed for the item
    public static class RecentViewHolder extends RecyclerView.ViewHolder {

        //  Our two views of the item
        ImageView recentImage;
        TextView recentTitle;

        public RecentViewHolder(@NonNull View itemView) {
            super(itemView);

            //  Initializing the views
            recentImage = itemView.findViewById(R.id.image_view_recycler_recent);
            recentTitle = itemView.findViewById(R.id.text_view_recycler_recent);

        }
    }
}
