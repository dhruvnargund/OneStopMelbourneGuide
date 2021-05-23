package com.dhruvdevapp.onestop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvdevapp.onestop.museums.AllMuseumsActivity;
import com.dhruvdevapp.onestop.museums.MuseumClickInterface;
import com.dhruvdevapp.onestop.museums.museumpages.AustralianCenterMovingImage;
import com.dhruvdevapp.onestop.museums.museumpages.IanPotterCenter;
import com.dhruvdevapp.onestop.museums.museumpages.MelbourneMuseum;
import com.dhruvdevapp.onestop.museums.museumpages.NationalGalleryOfVictoria;
import com.dhruvdevapp.onestop.parks.AllParksActivity;
import com.dhruvdevapp.onestop.parks.ParksClickInterface;
import com.dhruvdevapp.onestop.parks.parkpages.CarltonGarden;
import com.dhruvdevapp.onestop.parks.parkpages.FitzroyGarden;
import com.dhruvdevapp.onestop.parks.parkpages.Flagstaffgarden;
import com.dhruvdevapp.onestop.parks.parkpages.RoyalBotanicalGarden;
import com.dhruvdevapp.onestop.spots.AllSpotsActivity;
import com.dhruvdevapp.onestop.spots.SpotsClickInterface;
import com.dhruvdevapp.onestop.spots.spotpages.EurekaTower;
import com.dhruvdevapp.onestop.spots.spotpages.FederationSquare;
import com.dhruvdevapp.onestop.spots.spotpages.MelbourneStar;
import com.dhruvdevapp.onestop.spots.spotpages.MelbourneZoo;
import com.dhruvdevapp.onestop.spots.spotpages.QueenVictoriaMarket;
import com.dhruvdevapp.onestop.spots.spotpages.ShrineRemembrance;
import com.dhruvdevapp.onestop.spots.spotpages.StPaulsWallpaper;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements TravelTipsClickInterface, ParksClickInterface, MuseumClickInterface, SpotsClickInterface, MostViewedClick {

    //  Recycler for Most viewed
    RecyclerView recycler;
    MostAdapter mostAdapter;

    //  Recycler for All activities
    AllActivitiesAdapter allActivitiesAdapter;

    //  Recycle for Museums
    MuseumsAdapter museumsAdapter;

    //  Recycler for Parks
    ParksAdapter parksAdapter;

    //  Recycler for travel tips
    TravelTipsAdapter travelTipsAdapter;

    //  To go to main pages of other views
    TextView spotsButton;
    TextView museumsButton;
    TextView parksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //  Initializing the variable Most Viewed
        recycler = findViewById(R.id.recycler_view_most_viewed);
        mostViewedArrayMethod();

        //  Initializing for all activities
        recycler = findViewById(R.id.recycler_view_all_activities);
        allActivitiesArrayMethod();

        //  Initializing for museums
        recycler = findViewById(R.id.recycler_view_museums);
        museumsArrayMethod();

        // Initializing for parks
        recycler = findViewById(R.id.recycler_view_parks);
        parksArrayMethod();

        // Initializing for parks
        recycler = findViewById(R.id.recycler_view_tips);
        tipsArrayMethod();

        //  Setting variable for going to main screens of other views
        spotsButton = findViewById(R.id.text_view_all_activities);
        clickListenerSpots(spotsButton);

        museumsButton = findViewById(R.id.text_view_museums);
        clickListenerMuseums(museumsButton);

        parksButton = findViewById(R.id.text_view_parks);
        clickListenerParks(parksButton);

    }

    private void clickListenerParks(TextView parksButton) {
        parksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, AllParksActivity.class);
                startActivity(intent);
            }
        });
    }

    private void clickListenerMuseums(TextView museumsButton) {
        museumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, AllMuseumsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void clickListenerSpots(TextView spotsButton) {
        spotsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, AllSpotsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void tipsArrayMethod() {
        ArrayList<TravelTips> travelTipsArrayList = new ArrayList<>();

        travelTipsArrayList.add(new TravelTips(R.drawable.travel_tips, "Melbourne On A Budget", "By TRAVELDUDES"));
        travelTipsArrayList.add(new TravelTips(R.drawable.melbourne_seasons, "Best Time to Visit", "By Rebecca"));
        travelTipsArrayList.add(new TravelTips(R.drawable.food, "Iconic Dishes of Melbourne", "By Audrey Bourget, Fred Siggins.."));
        travelTipsAdapter = new TravelTipsAdapter(travelTipsArrayList, this);
        recycler.setAdapter(travelTipsAdapter);
    }

    private void parksArrayMethod() {
        ArrayList<ParksItem> parksItemArrayList = new ArrayList<>();
        parksItemArrayList.add(new ParksItem("Royal Botanical Gardens Victoria", R.drawable.rbg_wallpaper, "Established in 1846 to the south of Yarra River the garden is a peaceful area stretching 94acres."));
        parksItemArrayList.add(new ParksItem("Fitzroy Gardens", R.drawable.fitzroy_wallpaper, "The 64acres of land is a victorian era landscape located in East Melbourne."));
        parksItemArrayList.add(new ParksItem("Flagstaff gardens", R.drawable.flagstaff_wallpaper, "It is the oldest park in Melbourne, established in 1862 and is one if the most visited parks in the city."));
        parksItemArrayList.add(new ParksItem("Carlton Gardens", R.drawable.carlton_garden, "Carlton Gardens is a gorgeously landscaped Victorian-era park that sits among impressive company."));

        parksAdapter = new ParksAdapter(parksItemArrayList, this);
        recycler.setAdapter(parksAdapter);
    }

    private void museumsArrayMethod() {
        ArrayList<MuseumItem> museumItemsArray = new ArrayList<>();
        museumItemsArray.add(new MuseumItem("National Gallery of Victoria", R.drawable.ngv_wallpaper, "The NGV founded in 1861 hosts over 70,000 incredible art pieces from across the Globe."));
        museumItemsArray.add(new MuseumItem("Australian Center for the Moving Image", R.drawable.acmi_wallpaper, "At ACMI at Federation Square is Australia's national museum of films, video games, digital culture and art."));
        museumItemsArray.add(new MuseumItem("The Ian Potter Center", R.drawable.ian_potter_wallpaper, "The Ian Potter Centre is an art gallery that houses the Australian part of the art collection of the NGV."));
        museumItemsArray.add(new MuseumItem("Melbourne Museum", R.drawable.melbourne_museum_wallpaper, "The culture, history and nature of Victoria are the focus of this museum."));

        museumsAdapter = new MuseumsAdapter(museumItemsArray, this);
        recycler.setAdapter(museumsAdapter);
    }

    private void allActivitiesArrayMethod() {
        ArrayList<AllActivitiesItem> allActivitiesItemArrayList = new ArrayList<>();
        allActivitiesItemArrayList.add(new AllActivitiesItem("Federation Square", R.drawable.federation_square_wallpaper, "It was built in the mid 19th century. The Melbourne Cricket Ground is the Australian Team's primary stadium."));
        allActivitiesItemArrayList.add(new AllActivitiesItem("Shrine of Remembrance", R.drawable.shrine_wallpaper, "The Shrine of Remembrance is the national War memorial dedicated to the brave contributions of the servicemen of Victoria."));
        allActivitiesItemArrayList.add(new AllActivitiesItem("Melbourne Star Observation Wheel", R.drawable.star_wallpaper, "A giant ferris wheel with glass cabins"));
        allActivitiesItemArrayList.add(new AllActivitiesItem("Melbourne Zoo", R.drawable.melbourne_zoo, "The Melbourne Zoo is home to a wide variety of animals with more than 300 species from all over the world, and a wide variety of exhibits."));

        allActivitiesAdapter = new AllActivitiesAdapter(allActivitiesItemArrayList, this);
        recycler.setAdapter(allActivitiesAdapter);
    }

    private void mostViewedArrayMethod() {
        ArrayList<MostViewedItems> mostLocations = new ArrayList<>();
        mostLocations.add(new MostViewedItems(R.drawable.federation_square_wallpaper, "Federation Square", "Two connecting central squares, surrounded by important buildings."));
        mostLocations.add(new MostViewedItems(R.drawable.eureka_wallapper, "Eureka Tower", "A skyscraper rising 297.3 meters with observation deck."));
        mostLocations.add(new MostViewedItems(R.drawable.st_paul_wallpaper, "St. Paul's Cathedral", "Neo-classical structure completed in 1931."));
        mostLocations.add(new MostViewedItems(R.drawable.queen_victoria_wallpaper, "Queen Victoria Market", "A historic market selling fresh produce and everything else."));

        mostAdapter = new MostAdapter(mostLocations, this);
        recycler.setAdapter(mostAdapter);
    }


    @Override
    public void onItemClick(int position) {
        Intent intent;
        switch (position) {
            case 0:
//                intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.traveldudes.com/tips-for-seeing-melbourne-on-a-budget/"));
//                startActivity(intent);
                intent = new Intent(HomeScreen.this, WebViewActivityBudget.class);
                startActivity(intent);
                break;

            case 1:
//                intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://misformelbourne.com/best-time-to-visit-melbourne-australia/"));
//                startActivity(intent);
                intent = new Intent(HomeScreen.this, WebViewTime.class);
                startActivity(intent);
                break;

            default:
//                intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.eater.com/2019/10/23/20916441/melbourne-iconic-dishes-magic-coffee-hsp-souvlaki"));
//                startActivity(intent);
                intent = new Intent(HomeScreen.this, WebViewFood.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClickPark(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(HomeScreen.this, RoyalBotanicalGarden.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(HomeScreen.this, FitzroyGarden.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(HomeScreen.this, Flagstaffgarden.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(HomeScreen.this, CarltonGarden.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onItemClickMuseum(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(HomeScreen.this, NationalGalleryOfVictoria.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(HomeScreen.this, AustralianCenterMovingImage.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(HomeScreen.this, IanPotterCenter.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(HomeScreen.this, MelbourneMuseum.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onSpotClick(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(HomeScreen.this, FederationSquare.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(HomeScreen.this, ShrineRemembrance.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(HomeScreen.this, MelbourneStar.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(HomeScreen.this, MelbourneZoo.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onMostViewClick(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(HomeScreen.this, FederationSquare.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(HomeScreen.this, EurekaTower.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(HomeScreen.this, StPaulsWallpaper.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(HomeScreen.this, QueenVictoriaMarket.class);
                startActivity(intent);
                break;
        }
    }
}