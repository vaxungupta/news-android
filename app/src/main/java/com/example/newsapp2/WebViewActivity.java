package com.example.newsapp2;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_web_view);

        String url=getIntent().getStringExtra("url");

        WebView webView=findViewById(R.id.webview);
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);


    }
}
