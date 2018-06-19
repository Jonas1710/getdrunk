package com.example.bmollj.getdrunk.helper;

import com.example.bmollj.getdrunk.model.Bar;

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
            bar.setId(0);

            try{
                bar.setOpen(obj.getBoolean("open_now"));
                bar.setBewertung(obj.getDouble("rating"));

            }
            catch (Exception e){

            }

            //bar.setEntfernung(obj.getInt("entfernung"));
            //bar.setOeffnungZeit(obj.getInt("opening_hours"));



           /* bar.setId(Integer.parseInt(obj.getString("id")));
            bar.setBewertung(Double.parseDouble(obj.getString("rating")));*/
           bars.add(bar);
        }




        return bars;
    }
}
