package com.example.bmollj.getdrunk.helper;

import com.example.bmollj.getdrunk.model.Bar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BarJsonParser {

    public static List<Bar> createBarFromJsonString(String barJsonString) throws JSONException {
        List<Bar> bars = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(barJsonString);
        JSONArray results = jsonObj.getJSONArray("results");


        for (int i = 0; i < results.length(); i++) {
            Bar bar = new Bar();
            JSONObject obj = results.getJSONObject(i);
            bar.setName(obj.getString("name"));
//            bar.setId(obj.getString("id"));
//            bar.setBewertung(Float.parseFloat(obj.getString("rating")));
           bars.add(bar);
        }




        return bars;
    }
}
