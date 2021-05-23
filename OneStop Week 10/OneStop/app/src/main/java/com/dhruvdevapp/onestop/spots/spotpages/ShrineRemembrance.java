package com.dhruvdevapp.onestop.spots.spotpages;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvdevapp.onestop.R;
import com.dhruvdevapp.onestop.spots.Spots;
import com.dhruvdevapp.onestop.spots.SpotsAdapter;
import com.dhruvdevapp.onestop.spots.SpotsClickInterface;

import java.util.ArrayList;

public class ShrineRemembrance extends AppCompatActivity implements SpotsClickInterface {

    RecyclerView recyclerView;
    SpotsAdapter spotsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shrine_remembrance);

        recyclerView = findViewById(R.id.recycler_view_all_spots_shrine_page);
        spotsArrayMethod();
    }

    private void spotsArrayMethod() {
        ArrayList<Spots> spotsArrayList = new ArrayList<>();
        spotsArrayList.add(new Spots(R.drawable.eureka_wallapper, "Eureka Tower", "A Skyscraper rising almost 300 meters with an observation deck.", 5f));
        spotsArrayList.add(new Spots(R.drawable.st_paul_wallpaper, "St. Pauls Cathedral", "Neo-classical structure completed in 1931 with beautiful interior.", 5f));
        spotsArrayList.add(new Spots(R.drawable.queen_victoria_wallpaper, "Queen Victoria Market", "An historic market selling fresh produce and everything else.", 5f));
        spotsArrayList.add(new Spots(R.drawable.aquarium_wallpaper, "Melbourne Aquarium", "The Sealife Melbourne Aquarium is home to more than 10,000 creatures from all the oceans.", 4.5f));
        spotsArrayList.add(new Spots(R.drawable.crown_wallpaper, "Crown Casino and Entertainment Complex", "Enjoy stores, restaurants, casinos, bowling, spas, hotels, cinema and games.", 5f));
        spotsArrayList.add(new Spots(R.drawable.st_patrik_wallpaper, "St. Patricks Cathedral", "Gothic-Revival church and the tallest and the largest church in Australia.", 4.5f));
        spotsArrayList.add(new Spots(R.drawable.parliament_wallpaper, "Parliament House Victoria", "An 1856 landmark bluestone building.", 4.5f));
        spotsArrayList.add(new Spots(R.drawable.melbourne_museum_wallpaper, "Melbourne Zoo", "More than 300 species of animals from all around the world live in this amazing zoo", 4.7f));
        spotsArrayList.add(new Spots(R.drawable.luna_wallpaper, "Luna Park", "Luna Park is a historic amusement park with 18 rides", 4f));
        spotsArrayList.add(new Spots(R.drawable.a_and_l_wallapaper, "Block Arcade", "A labyrinth of lanes and alleyways around Flinders, Collins, and Bourke Streets reveals a quirky Melbourne at its best", 5f));
        spotsArrayList.add(new Spots(R.drawable.docklands_wallapaper, "Docklands", "Docklands is Melbourne's newest waterfront entertainment precinct.", 4.5f));
        spotsArrayList.add(new Spots(R.drawable.southbank_wallpaper, "Southbank and Arts Centre Melbourne", "On the banks of the Yarra River, a short stroll from Flinders Street Station, this area is packed with cultural attractions", 5f));
        spotsArrayList.add(new Spots(R.drawable.flinders_wallpaper, "Flinders Street Railway Station", "Opened in 1854, the historic station serves the entire metropolitan rail network.", 4.4f));
        spotsArrayList.add(new Spots(R.drawable.puffing_wallpaper, "Puffing Billy Railway", "It is an open-air train for beautiful natural rainforest views", 4.5f));
        spotsArrayList.add(new Spots(R.drawable.star_wallpaper, "Melbourne Star Observation Wheel", "A giant ferris wheel with glass cabins", 4.4f));
        spotsArrayList.add(new Spots(R.drawable.library_wallpaper, "State Library Victoria", "Central hub in 19th century buildings", 4.7f));
        spotsArrayList.add(new Spots(R.drawable.chinatown_wallpaper, "Chinatown Melbourne", "Chinatown is an ethnic enclave in the Central Business District of Melbourne, Victoria, Australia.", 4.2f));
        spotsArrayList.add(new Spots(R.drawable.lane_wallpaper, "Hosier Lane", "From the late 1990s, Hosier Lane is a popular tourist attraction due to its street art.", 4f));

        spotsAdapter = new SpotsAdapter(spotsArrayList, this);
        recyclerView.setAdapter(spotsAdapter);
    }

    @Override
    public void onSpotClick(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(ShrineRemembrance.this, FederationSquare.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(ShrineRemembrance.this, EurekaTower.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(ShrineRemembrance.this, StPaulsWallpaper.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(ShrineRemembrance.this, QueenVictoriaMarket.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(ShrineRemembrance.this, MelbourneAquarium.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(ShrineRemembrance.this, CrownCasino.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(ShrineRemembrance.this, StPatrik.class);
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(ShrineRemembrance.this, Parliament.class);
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(ShrineRemembrance.this, MelbourneZoo.class);
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(ShrineRemembrance.this, LunaPark.class);
                startActivity(intent);
                break;
            case 10:
                intent = new Intent(ShrineRemembrance.this, BlockArcade.class);
                startActivity(intent);
                break;
            case 11:
                intent = new Intent(ShrineRemembrance.this, Docklands.class);
                startActivity(intent);
                break;
            case 12:
                intent = new Intent(ShrineRemembrance.this, SouthBank.class);
                startActivity(intent);
                break;
            case 13:
                intent = new Intent(ShrineRemembrance.this, FlindersRailway.class);
                startActivity(intent);
                break;
            case 14:
                intent = new Intent(ShrineRemembrance.this, PuffingBilly.class);
                startActivity(intent);
                break;
            case 15:
                intent = new Intent(ShrineRemembrance.this, MelbourneStar.class);
                startActivity(intent);
                break;
            case 16:
                intent = new Intent(ShrineRemembrance.this, StateLibrary.class);
                startActivity(intent);
                break;
            case 17:
                intent = new Intent(ShrineRemembrance.this, Chinatown.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(ShrineRemembrance.this, HosierLane.class);
                startActivity(intent);
                break;

        }
    }
}