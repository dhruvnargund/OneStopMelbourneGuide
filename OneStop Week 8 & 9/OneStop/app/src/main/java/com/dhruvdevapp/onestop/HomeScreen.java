package com.dhruvdevapp.onestop;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements TravelTipsClickInterface {

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
        parksItemArrayList.add(new ParksItem("Royal Botanical Gardens Victoria", R.drawable.royal_botanical_garden, "Established in 1846 to the south of Yarra River the garden is a peaceful area stretching 94acres."));
        parksItemArrayList.add(new ParksItem("Fitzroy Gardens", R.drawable.fitzroy_garden, "The 64acres of land is a victorian era landscape located in East Melbourne."));
        parksItemArrayList.add(new ParksItem("Flagstaff gardens", R.drawable.flagstaff_garden, "It is the oldest park in Melbourne, established in 1862 and is one if the most visited parks in the city."));
        parksItemArrayList.add(new ParksItem("Carlton Gardens", R.drawable.carlton_garden, "Carlton Gardens is a gorgeously landscaped Victorian-era park that sits among impressive company."));

        parksAdapter = new ParksAdapter(parksItemArrayList);
        recycler.setAdapter(parksAdapter);
    }

    private void museumsArrayMethod() {
        ArrayList<MuseumItem> museumItemsArray = new ArrayList<>();
        museumItemsArray.add(new MuseumItem("National Gallery of Victoria", R.drawable.national_gallery_victoira, "The NGV founded in 1861 hosts over 70,000 incredible art pieces from across the Globe."));
        museumItemsArray.add(new MuseumItem("Australian Center for the Moving Image", R.drawable.australian_centre_for_the_moving_image, "At ACMI at Federation Square is Australia's national museum of films, video games, digital culture and art."));
        museumItemsArray.add(new MuseumItem("The Ian Potter Center", R.drawable.ian_potter_centre, "The Ian Potter Centre is an art gallery that houses the Australian part of the art collection of the NGV."));
        museumItemsArray.add(new MuseumItem("Melbourne Museum", R.drawable.melbourne_museum, "The culture, history and nature of Victoria are the focus of this museum."));

        museumsAdapter = new MuseumsAdapter(museumItemsArray);
        recycler.setAdapter(museumsAdapter);
    }

    private void allActivitiesArrayMethod() {
        ArrayList<AllActivitiesItem> allActivitiesItemArrayList = new ArrayList<>();
        allActivitiesItemArrayList.add(new AllActivitiesItem("Melbourne Cricket Ground", R.drawable.melbourne_cricket_ground, "It was built in the mid 19th century. The Melbourne Cricket Ground is the Australian Team's primary stadium."));
        allActivitiesItemArrayList.add(new AllActivitiesItem("Shrine of Remembrance", R.drawable.shrine_of_rememberance, "The Shrine of Remembrance is the national War memorial dedicated to the brave contributions of the servicemen of Victoria."));
        allActivitiesItemArrayList.add(new AllActivitiesItem("Royal Botanical Gardens", R.drawable.royal_botanical_garden, "The garden houses a collection of different plants contained in the various different lawns of the gardens."));
        allActivitiesItemArrayList.add(new AllActivitiesItem("Melbourne Zoo", R.drawable.melbourne_zoo, "The Melbourne Zoo is home to a wide variety of animals with more than 300 species from all over the world, and a wide variety of exhibits."));

        allActivitiesAdapter = new AllActivitiesAdapter(allActivitiesItemArrayList);
        recycler.setAdapter(allActivitiesAdapter);
    }

    private void mostViewedArrayMethod() {
        ArrayList<MostViewedItems> mostLocations = new ArrayList<>();
        mostLocations.add(new MostViewedItems(R.drawable.federation_square, "Federation Square", "Two connecting central squares, surrounded by important buildings."));
        mostLocations.add(new MostViewedItems(R.drawable.eureka_tower, "Eureka Tower", "A skyscraper rising 297.3 meters with observation deck."));
        mostLocations.add(new MostViewedItems(R.drawable.st_pauls_cathedral, "St. Paul's Cathedral", "Neo-classical structure completed in 1931."));
        mostLocations.add(new MostViewedItems(R.drawable.queen_victoria_market, "Queen Victoria Market", "A historic market selling fresh produce and everything else."));

        mostAdapter = new MostAdapter(mostLocations);
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
}