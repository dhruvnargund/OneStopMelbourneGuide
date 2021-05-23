package com.dhruvdevapp.onestop;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivityBudget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        openUrlMethod();
    }

    public void openUrlMethod() {
        WebView webView = (WebView) findViewById(R.id.web_view_tips);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.traveldudes.com/tips-for-seeing-melbourne-on-a-budget/");
    }
}