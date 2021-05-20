package com.dhruvdevapp.onestop;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_time);
        openUrlMethod();
    }

    public void openUrlMethod() {
        WebView webView = (WebView) findViewById(R.id.web_view_tips_time);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://misformelbourne.com/best-time-to-visit-melbourne-australia/");
    }
}