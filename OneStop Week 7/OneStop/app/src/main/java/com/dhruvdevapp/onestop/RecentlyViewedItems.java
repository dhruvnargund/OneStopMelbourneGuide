package com.dhruvdevapp.onestop;

import androidx.annotation.DrawableRes;

public class RecentlyViewedItems {

    //  This class will be used to store the images and the name for the recently viewed items
    //  All resources such as images are int in java
    int recentImage;
    String recentName;

    //  Creating the constructor
    //  Giving recentImage Drawable annotation will make sure we can only put images and not some random int
    public RecentlyViewedItems(@DrawableRes int recentImage, String recentName) {
        this.recentImage = recentImage;
        this.recentName = recentName;
    }

    public int getRecentImage() {
        return recentImage;
    }

    public void setRecentImage(int recentImage) {
        this.recentImage = recentImage;
    }

    public String getRecentName() {
        return recentName;
    }

    public void setRecentName(String recentName) {
        this.recentName = recentName;
    }
}
