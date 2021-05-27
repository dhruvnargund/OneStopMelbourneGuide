package com.dhruvdevapp.onestop.museums.museumpages;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvdevapp.onestop.R;
import com.dhruvdevapp.onestop.museums.AllMuseumAdapter;
import com.dhruvdevapp.onestop.museums.MuseumClickInterface;
import com.dhruvdevapp.onestop.museums.Museums;

import java.util.ArrayList;

public class PollyWoodside extends AppCompatActivity implements MuseumClickInterface {

    RecyclerView recyclerView;
    AllMuseumAdapter museumsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polly_woodside);

        recyclerView = findViewById(R.id.recycler_view_all_museums_polly_woodside_page);
        RelativeLayout directionsButton = findViewById(R.id.polly_woodside_directions_button);
        museumsArrayMethod();

        directionsButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=-37.82423907083492, 144.9534791385208&mode=1"));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        });    }

    private void museumsArrayMethod() {
        ArrayList<Museums> museumsArrayList = new ArrayList<>();
        museumsArrayList.add(new Museums(R.drawable.ngv_wallpaper, "National gallery of Victoria", "NGV displays a wide range of furniture, fashion, textile, modern and historic art.", 5f));
        museumsArrayList.add(new Museums(R.drawable.acmi_wallpaper, "Australian Center for the Moving Image", "ACMI has displays, exhibitions, screenings to get entertained.", 5f));
        museumsArrayList.add(new Museums(R.drawable.ian_potter_wallpaper, "The Ian Potter Center", "It is a branch of the National gallery of Victoria.", 5f));
        museumsArrayList.add(new Museums(R.drawable.old_gaol_wallpaper, "Old Melbourne Gaol", "It is an interactive experience in a 1800s gaol", 4.5f));
        museumsArrayList.add(new Museums(R.drawable.melbourne_museum_wallpaper, "Melbourne Museum", "he culture, history and nature of Victoria are the focus of this museum.", 4.5f));
        museumsArrayList.add(new Museums(R.drawable.royal_exhibition_wallpaper, "Royal Exhibition Building", "In 1880 this space was constructed and is now a UNESCO site", 4.5f));
        museumsArrayList.add(new Museums(R.drawable.nsm_wallpapaer, "National Sports Museum", "At the Melbourne Cricket Ground, this museum focuses on all Australian sports", 4f));
        museumsArrayList.add(new Museums(R.drawable.artvo_wallpaper, "ArtVo Immersive Art Gallery", "Over 80 3D, reality-defying artworks-featuring YOU!", 4f));
        museumsArrayList.add(new Museums(R.drawable.scienceworks_wallpaper, "Scienceworks", "A hands-on exciting museum for discovering scientific principles", 4f));

        museumsAdapter = new AllMuseumAdapter(museumsArrayList, this);
        recyclerView.setAdapter(museumsAdapter);
    }

    @Override
    public void onItemClickMuseum(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(PollyWoodside.this, NationalGalleryOfVictoria.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(PollyWoodside.this, AustralianCenterMovingImage.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(PollyWoodside.this, IanPotterCenter.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(PollyWoodside.this, OldMelbourneGaol.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(PollyWoodside.this, MelbourneMuseum.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(PollyWoodside.this, RoyalExhibitionBuilding.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(PollyWoodside.this, NationalSportsMuseum.class);
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(PollyWoodside.this, ArtVoImmersiveArtGallery.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(PollyWoodside.this, Scienceworks.class);
                startActivity(intent);
                break;
        }
    }
}