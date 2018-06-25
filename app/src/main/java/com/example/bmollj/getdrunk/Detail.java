package com.example.bmollj.getdrunk;

import android.content.Intent;
import android.media.Rating;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.bmollj.getdrunk.model.Bar;

public class Detail extends AppCompatActivity {

    private ProgressBar progressBar;
    private RatingBar ratingBar;
    private FloatingActionButton openMapButton;
    private int id;
    private String offen;
    private String geschlossen;

    private CheckBox isOpen;
    private String schliessungsZeit;
    private TextView entfernung;
    private TextView oeffnungszeiten;
    private String placeId;
    private String photoreference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        setContentView(R.layout.activity_detail);
        progressBar = findViewById(R.id.DetailProgress);
        ratingBar = findViewById(R.id.Bewertung);
        float bewertung = intent.getFloatExtra("bewertung", 0);
        openMapButton = findViewById(R.id.floatingActionButton);
        isOpen = findViewById(R.id.isOpen);
        entfernung = findViewById(R.id.txtEntfernung);
        oeffnungszeiten = findViewById(R.id.txtOefnungszeiten);
        offen = intent.getStringExtra("oeffnungszeit");
        geschlossen = intent.getStringExtra("schliessungszeit");


        id = intent.getIntExtra("id", 0);
        ratingBar.setRating(bewertung);
        isOpen.setChecked(intent.getBooleanExtra("isOpen", false));
        oeffnungszeiten.setText(offen+"-"+geschlossen);
        entfernung.setText(intent.getStringExtra("entfernung"));

        String name = intent.getStringExtra("name");

        ratingBar.setRating(bewertung);


        setTitle(name);


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
