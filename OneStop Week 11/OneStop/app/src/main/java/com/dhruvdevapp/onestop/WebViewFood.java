package com.dhruvdevapp.onestop;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_food);
        openUrlMethod();
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void openUrlMethod() {
        WebView webView = (WebView) findViewById(R.id.web_view_tips_food);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.eater.com/2019/10/23/20916441/melbourne-iconic-dishes-magic-coffee-hsp-souvlaki");
    }
}