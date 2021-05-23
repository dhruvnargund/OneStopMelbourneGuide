package com.dhruvdevapp.onestop.parks.parkpages;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvdevapp.onestop.R;
import com.dhruvdevapp.onestop.parks.AllParksAdapter;
import com.dhruvdevapp.onestop.parks.Park;
import com.dhruvdevapp.onestop.parks.ParksClickInterface;

import java.util.ArrayList;

public class AlexandraGarden extends AppCompatActivity implements ParksClickInterface {
    RecyclerView recyclerView;
    AllParksAdapter allParksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alexandragarden);

        recyclerView = findViewById(R.id.recycler_view_all_parks_alex_page);
        museumsArrayMethod();

    }

    private void museumsArrayMethod() {
        ArrayList<Park> parkArrayList = new ArrayList<>();
        parkArrayList.add(new Park("Royal Botanic Gardens Victoria", "These beautiful Gardens are home to amazing and diverse plant collections such as camellias, rainforest flora, succulents and cacti, roses and many more.", 5f, R.drawable.rbg_wallpaper));
        parkArrayList.add(new Park("Fitzroy Gardens", "The Fitzroy Gardens are 64 acres located on the southeastern edge of the Melbourne Central Business District. The gardens are one of the major Victorian era landscaped gardens in Australia.", 5f, R.drawable.fitzroy_wallpaper));
        parkArrayList.add(new Park("Flagstaff Gardens", "Flagstaff Gardens is the oldest park in Melbourne, Victoria, Australia, first established in 1862. Today it is one of the most visited and widely used parks in the city.", 4.5f, R.drawable.flagstaff_wallpaper));
        parkArrayList.add(new Park("Carlton Gardens", "This 64-acre World Heritage Site contains the Royal Exhibition Building, Melbourne Museum and Imax Cinema, tennis courts and an award-winning children's playground. ", 4.5f, R.drawable.carlton_garden));
        parkArrayList.add(new Park("Treasury Gardens", "The Gardens are a short walk from Victoria’s Parliament House and are overlooked by the old Treasury buildings, and State Offices. They create a landscaped setting for office workers to enjoy during lunch with large areas of lawn and walking paths.", 4f, R.drawable.treasury_wallpaper));

        allParksAdapter = new AllParksAdapter(parkArrayList, this);
        recyclerView.setAdapter(allParksAdapter);
    }

    @Override
    public void onItemClickPark(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(AlexandraGarden.this, RoyalBotanicalGarden.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(AlexandraGarden.this, FitzroyGarden.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(AlexandraGarden.this, Flagstaffgarden.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(AlexandraGarden.this, CarltonGarden.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(AlexandraGarden.this, TreasuryGardens.class);
                startActivity(intent);
                break;
        }
    }
}