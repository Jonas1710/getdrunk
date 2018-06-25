package com.example.bmollj.getdrunk;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import com.example.bmollj.getdrunk.model.Bar;

public class Detail extends AppCompatActivity {

    private ProgressBar progressBar;
    private RatingBar ratingBar;
    private FloatingActionButton openMapButton;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        progressBar = findViewById(R.id.DetailProgress);
        ratingBar = findViewById(R.id.Bewertung);
        openMapButton = findViewById(R.id.floatingActionButton);





        progressBar.setVisibility(View.INVISIBLE);







        openMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bar bar = new Bar();

               // Create a Uri from an intent string. Use the result to create an Intent.


// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
Intent mapIntent = new Intent(Detail.this, Map.class);

mapIntent.putExtra("lat",bar.getLat());
mapIntent.putExtra("lng", bar.getLng());
// Make the Intent explicit by setting the Google Maps package


// Attempt to start an activity that can handle the Intent
startActivity(mapIntent);
            }
        });
    }
}
