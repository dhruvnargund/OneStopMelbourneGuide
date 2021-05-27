package com.dhruvdevapp.onestop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvdevapp.onestop.parks.ParksClickInterface;

import java.util.ArrayList;

public class ParksAdapter extends RecyclerView.Adapter<ParksAdapter.ParkViewHolder> {

    ParksClickInterface parksClickInterface;
    ArrayList<ParksItem> parkItemArrayList;

    public ParksAdapter(ArrayList<ParksItem> parkItemArrayList, ParksClickInterface parksClickInterface) {
        this.parkItemArrayList = parkItemArrayList;
        this.parksClickInterface = parksClickInterface;
    }

    @NonNull
    @Override
    public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.museums_card_design, parent, false);
        return new ParkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParksAdapter.ParkViewHolder holder, int position) {
        ParksItem parkItem = parkItemArrayList.get(position);
        holder.image.setImageResource(parkItem.getImage());
        holder.title.setText(parkItem.getTitle());
        holder.description.setText(parkItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return parkItemArrayList.size();
    }

    public class ParkViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView description;

        public ParkViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view_museum);
            title = itemView.findViewById(R.id.text_view_museum_title);
            description = itemView.findViewById(R.id.text_view_museum_description);

            itemView.setOnClickListener(v -> parksClickInterface.onItemClickPark(getAdapterPosition()));
        }
    }
}
