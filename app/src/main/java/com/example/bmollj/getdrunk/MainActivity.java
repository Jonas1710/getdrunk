package com.example.bmollj.getdrunk;


import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bmollj.getdrunk.helper.BarJsonParser;
import com.example.bmollj.getdrunk.helper.BarListAdapter;
import com.example.bmollj.getdrunk.helper.BarListAdapter;
import com.example.bmollj.getdrunk.helper.CustomItemClickListener;
import com.example.bmollj.getdrunk.model.Bar;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlacePhotoMetadata;


import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ProgressBar progressBar;
    private ImageView imageView;
    private GeoDataClient mGeoDataClient;
    private ArrayList<Bar> bars = new ArrayList<>();
    private Bar bar = new Bar();
    private List<PlacePhotoMetadata> photoDataList;
    private BarListAdapter barListAdapter;
    private int currentPotoIndex = 0;
    private String GOOGLE_PLACES_API_RADIUS = "&radius=";
    private static final String GOOGLE_PLACES_API_TYPE = "&type=bar";
    private static final String GOOGLE_PLACES_API_LOCATION = "&location=46.939667,7.398639";
    private static final String GOOGLE_PLACES_API_KEY = "?key=AIzaSyAxVuj47QokNKnGvKIkDDVxdodqAIr52Rs";
    private static final String GOOGLE_PLACES_API_NEARBYSEARCH = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
    private static final String GOOGLE_PLACES_API_PICTURES = "https://maps.googleapis.com/maps/api/place/photo?key=AIzaSyAxVuj47QokNKnGvKIkDDVxdodqAIr52Rs&maxwidth=400&maxheight=400&photoreference=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.loading_bars_overview_progress);
        progressBar.setVisibility(View.VISIBLE);
        String radius = "2000";
        GOOGLE_PLACES_API_RADIUS += radius;
        getBarInfo(GOOGLE_PLACES_API_NEARBYSEARCH + GOOGLE_PLACES_API_KEY + GOOGLE_PLACES_API_LOCATION + GOOGLE_PLACES_API_RADIUS + GOOGLE_PLACES_API_TYPE);
        RecyclerView barInfoList = findViewById(R.id.barList);
        barListAdapter = new BarListAdapter(bars);
        barInfoList.setLayoutManager(new LinearLayoutManager(this));
        barInfoList.setAdapter(barListAdapter);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }


//    private void getPhoto(PlacePhotoMetadata photoMetadata){
//        Task<PlacePhotoResponse> photoResponse = mGeoDataClientl.getPhoto()
//    }


    private void getBarInfo(String url) {
        final Context context = getApplicationContext();
        //Infos Adapter Initialisieren

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            bars = BarJsonParser.createBarFromJsonString(response);
                            barListAdapter.addAll(bars);
                            barListAdapter.notifyDataSetChanged();
                            progressBar.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            generateAlertDialog();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                generateAlertDialog();
            }
        });

        queue.add(stringRequest);
    }

    private void generateAlertDialog() {
        progressBar.setVisibility(View.GONE);
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Closes this activity
                finish();
            }
        });
        dialogBuilder.setMessage("Die Badidetails konnten nicht geladen werden. Versuche es später nochmals.").setTitle("Fehler");
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }


}
