package com.dhruvdevapp.onestop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TravelTipsAdapter extends RecyclerView.Adapter<TravelTipsAdapter.TravelTipsViewHolder> {

    ArrayList<TravelTips> travelTipsArrayList = new ArrayList<>();

    //  This is to implement clickable recycler view
    private TravelTipsClickInterface travelTipsClickInterface;

    public TravelTipsAdapter(ArrayList<TravelTips> travelTipsArrayList, TravelTipsClickInterface travelTipsClickInterface) {
        this.travelTipsArrayList = travelTipsArrayList;
        this.travelTipsClickInterface = travelTipsClickInterface;
    }

    @NonNull
    @Override
    public TravelTipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.travel_tips_card_design, parent, false);
        TravelTipsViewHolder travelTipsViewHolder = new TravelTipsViewHolder(view);
        return travelTipsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TravelTipsAdapter.TravelTipsViewHolder holder, int position) {
        TravelTips travelTips = travelTipsArrayList.get(position);

        holder.image.setImageResource(travelTips.getImage());
        holder.title.setText(travelTips.getTitle());
        holder.author.setText(travelTips.getAuthor());

    }

    @Override
    public int getItemCount() {
        return travelTipsArrayList.size();
    }

    public class TravelTipsViewHolder extends RecyclerView.ViewHolder { //  We need to make it non-static since we are creating an object for interface here

        ImageView image;
        TextView title;
        TextView author;

        public TravelTipsViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view_travel_tips);
            title = itemView.findViewById(R.id.text_view_tips_title);
            author = itemView.findViewById(R.id.text_view_tips_author);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    travelTipsClickInterface.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
