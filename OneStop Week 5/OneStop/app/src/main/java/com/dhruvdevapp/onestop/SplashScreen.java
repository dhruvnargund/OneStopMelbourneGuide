package com.dhruvdevapp.onestop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    //  This variable is to determine the duration of the animation
    //  It is static and final so that no other object can change it once it is made
    private static final int animationTimer = 3000;  //  1000 is 1 sec

    //  These are the animation variables
    Animation upAnimation;
    Animation bottomAnimation;

    //  Importing the splashscreen image and the textview to find them by id
    private ImageView splashScreenImage;
    private TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  This is so that the splash screen is in full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //  finding the views by id
        splashScreenImage = findViewById(R.id.image_view_splash_screen);
        nameText = findViewById(R.id.text_view_name);

        //  assigning proper animation files to the variables
        upAnimation = AnimationUtils.loadAnimation(this, R.anim.up_animation);  //  Here this tells Android that the animation is t be performed on this screen
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //  setting animation on elements
        splashScreenImage.setAnimation(upAnimation);
        nameText.setAnimation(bottomAnimation);

        //  This method will delay any method in its brackets
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //  Here we are telling android go from this screen to HomeScreen
                Intent nextScreenIntent = new Intent(SplashScreen.this, HomeScreen.class);
                startActivity(nextScreenIntent);    //  Without this nothing will happen
                finish();   //  If we write the finish line this activity will be destroyed and you can't go back to it

            }
        }, animationTimer); //  Here we are telling the method how long to wait to perform the animation

    }
}