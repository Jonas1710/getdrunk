package com.example.bmollj.getdrunk.helper;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.example.bmollj.getdrunk.model.Bar;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResponse;
import com.google.android.gms.location.places.PlacePhotoResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BarJsonParser {

    public static ArrayList<Bar> createBarFromJsonString(String barJsonString) throws JSONException {
        ArrayList<Bar> bars = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(barJsonString);
        JSONArray results = jsonObj.getJSONArray("results");


        for (int i = 0; i < results.length(); i++) {
            Bar bar = new Bar();
            JSONObject obj = results.getJSONObject(i);
            bar.setName(obj.getString("name"));
//            bar.setPlaceId(obj.getString("place_id"));
//            bar.setPhotoreference(obj.getString("photo_reference"));


            bar.setId(obj.getString("id"));
            if(obj.has("rating")) {
                bar.setBewertung(Float.parseFloat(obj.getString("rating")));
            }
            bar.setOpen(Boolean.parseBoolean("open_now"));
            //bar.setSchliessungsZeit(Integer.parseInt(""));
            //bar.setOeffnungszeit(Integer.parseInt(""));
           bars.add(bar);
        }




        return bars;
    }
}
