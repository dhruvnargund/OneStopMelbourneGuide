package com.dhruvdevapp.onestop.spots;

import androidx.annotation.DrawableRes;

public class Spots {

    String title;
    String description;
    float rating;
    int image;

    public Spots(@DrawableRes int image, String title, String description, float rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
