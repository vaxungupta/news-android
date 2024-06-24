package com.example.newsapp2;

import static com.example.newsapp2.MainActivity.list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.squareup.picasso.Picasso;

import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class NewsDetailsPage extends AppCompatActivity {

    int itemPosition;
    ImageView imageView;
    private TextView tvSourceName, tvtime, tvTitle, tvDesc, tvcontent;
    private Object Picasso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details_page);

        itemPosition = getIntent().getIntExtra("key", 0);
        DateFormat formater = new SimpleDateFormat("dd-MM-yy");

        tvSourceName = findViewById(R.id.tvSourceName);
        tvtime = findViewById(R.id.tvtime);
        tvTitle = findViewById(R.id.tvTitle);
        tvDesc = findViewById(R.id.tvDesc);
        tvcontent = findViewById(R.id.tvcontent);

        tvSourceName.setText(list.get(itemPosition).getSource().getName());
        tvtime.setText(formater.format(list.get(itemPosition).publishedAt));
        tvTitle.setText(list.get(itemPosition).getTitle());
        tvDesc.setText(list.get(itemPosition).getDescription());
        tvcontent.setText(list.get(itemPosition).getContent());

        imageView = findViewById(R.id.newsDetailImageView);
        imageView = findViewById(R.id.newsDetailImageView);

        imageView = findViewById(R.id.newsDetailImageView);
        com.squareup.picasso.Picasso.get().load(list.get(itemPosition).getUrlToImage()).placeholder(R.mipmap.ic_launcher).into(imageView);

        Button urlBtn=findViewById(R.id.appCompatButton);
        urlBtn.setOnClickListener(v -> {
            Intent intent=new Intent(v.getContext(), WebViewActivity.class);
            intent.putExtra("url",list.get(itemPosition).getUrl());
            v.getContext().startActivity(intent);
        });

    }
}
