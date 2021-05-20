package com.dhruvdevapp.onestop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllActivitiesAdapter extends RecyclerView.Adapter<AllActivitiesAdapter.AllActivitiesViewHolder> {

    ArrayList<AllActivitiesItem> allActivitiesItemArrayList;

    public AllActivitiesAdapter(ArrayList<AllActivitiesItem> allActivitiesItemArrayList) {
        this.allActivitiesItemArrayList = allActivitiesItemArrayList;
    }

    @NonNull
    @Override
    public AllActivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_activities_card_design, parent, false);
        AllActivitiesViewHolder allActivitiesViewHolder = new AllActivitiesViewHolder(view);
        return allActivitiesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllActivitiesAdapter.AllActivitiesViewHolder holder, int position) {
        AllActivitiesItem allActivitiesItem = allActivitiesItemArrayList.get(position);

        holder.allActivityImage.setImageResource(allActivitiesItem.getImage());
        holder.allActivityTitle.setText(allActivitiesItem.getTitle());
        holder.allActivityDescription.setText(allActivitiesItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return allActivitiesItemArrayList.size();
    }

    public static class AllActivitiesViewHolder extends RecyclerView.ViewHolder {

        ImageView allActivityImage;
        TextView allActivityTitle;
        TextView allActivityDescription;

        public AllActivitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            allActivityImage = itemView.findViewById(R.id.image_view_all_activities);
            allActivityTitle = itemView.findViewById(R.id.text_view_all_activities_title);
            allActivityDescription = itemView.findViewById(R.id.text_view_all_activities_description);
        }
    }
}
