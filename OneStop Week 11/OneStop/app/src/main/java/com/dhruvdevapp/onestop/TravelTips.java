package com.dhruvdevapp.onestop;

import androidx.annotation.DrawableRes;

public class TravelTips {
    int image;
    String title;
    String author;

    public TravelTips(@DrawableRes int image, String title, String author) {
        this.image = image;
        this.title = title;
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

}
