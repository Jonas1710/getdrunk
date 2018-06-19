package com.example.bmollj.getdrunk;


import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.ArrayAdapter;
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
import com.example.bmollj.getdrunk.model.Bar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ProgressBar progressBar;
    private List<Bar> bars = new ArrayList<>();
    private String GOOGLE_PLACES_API_RADIUS = "&radius=";
    private static final String GOOGLE_PLACES_API_TYPE ="&type=bar";
    private static final String GOOGLE_PLACES_API_LOCATION = "&location=46.939667,7.398639";
    private static final String GOOGLE_PLACES_API_KEY = "?key=AIzaSyAxVuj47QokNKnGvKIkDDVxdodqAIr52Rs";
    private static final String GOOGLE_PLACES_API_NEARBYSEARCH = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.loading_bars_overview_progress);
        progressBar.setVisibility(View.VISIBLE);
        String radius = "2000";
        GOOGLE_PLACES_API_RADIUS += radius;
        getBarInfo(GOOGLE_PLACES_API_NEARBYSEARCH + GOOGLE_PLACES_API_KEY + GOOGLE_PLACES_API_LOCATION +GOOGLE_PLACES_API_RADIUS + GOOGLE_PLACES_API_TYPE);



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


    private void addBarsToList(){
        ListView bar = findViewById(R.id.bars_overview_list);
        ArrayAdapter<Bar> barAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        barAdapter.addAll();
        bar.setAdapter(barAdapter);
    }


    private void getBarInfo(String url) {
        //Infos Adapter Initialisieren
        final ArrayAdapter<Bar> barInfosAdapter = new ArrayAdapter<Bar>(getApplicationContext(), android.R.layout.simple_list_item_1){
            //Farbe der Schrift auf Weiss setzen
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView bar = view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                bar.setTextColor(Color.WHITE);

                // Generate ListView Item using TextView
                return view;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        final ListView barInfoList = findViewById(R.id.bars_overview_list);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            List<Bar> bars = BarJsonParser.createBarFromJsonString(response);
                            barInfosAdapter.addAll(bars);
                            barInfoList.setAdapter(barInfosAdapter);
                            progressBar.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            generateAlertDialog();
                        }

                    }             }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                generateAlertDialog();         }     });

        queue.add(stringRequest);

        AdapterView.OnItemClickListener mListClickedHandler = new
                AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Detail.class);
                        Bar selected = (Bar) parent.getItemAtPosition(position);
                        intent.putExtra("id", selected.getId());
                        intent.putExtra("name", selected.getName());
                        intent.putExtra("bewertung", selected.getBewertung());

                        startActivity(intent);
                    }
                };

        barInfoList.setOnItemClickListener(mListClickedHandler);
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
