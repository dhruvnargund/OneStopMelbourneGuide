package com.dhruvdevapp.onestop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    RecyclerView recentlyViewedRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //  Initializing the variable
        recentlyViewedRecycler = findViewById(R.id.relative_layout_recently_viewed);
        recentRecycler();

    }

    private void recentRecycler() {
        //  Since our recycler view is not spanning the entire screen, by using this method we will only load those views that are visible
        recentlyViewedRecycler.setHasFixedSize(true);
        ArrayList<RecentlyViewedItems> recentLocations = new ArrayList<>();
        recentLocations.add(new RecentlyViewedItems());
    }
}