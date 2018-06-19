package com.example.bmollj.getdrunk;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;

public class Detail extends AppCompatActivity {

    private ProgressBar progressBar;
    private RatingBar ratingBar;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        progressBar = findViewById(R.id.DetailProgress);
        ratingBar = findViewById(R.id.Bewertung);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        String name = intent.getStringExtra("name");
        float bewertung = intent.getFloatExtra("bewertung", 0);
        ratingBar.setRating(bewertung);

        setTitle(name);  progressBar.setVisibility(View.INVISIBLE);
    }
}
