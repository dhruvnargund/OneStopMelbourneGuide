package com.dhruvdevapp.onestop;

import androidx.annotation.DrawableRes;

public class MostViewedItems {

    //  This class will be used to store the images and the name for the most viewed items
    //  All resources such as images are int in java
    int mostImage;
    String mostName;
    String mostDescription;

    //  Creating the constructor
    //  Giving mostImage Drawable annotation will make sure we can only put images and not some random int
    public MostViewedItems(@DrawableRes int mostImage, String mostName, String mostDescription) {
        this.mostImage = mostImage;
        this.mostName = mostName;
        this.mostDescription = mostDescription;
    }

    public String getMostDescription() {
        return mostDescription;
    }

    public int getMostImage() {

        return mostImage;
    }

    public void setMostImage(int mostImage) {

        this.mostImage = mostImage;
    }

    public String getMostName() {

        return mostName;
    }

}
