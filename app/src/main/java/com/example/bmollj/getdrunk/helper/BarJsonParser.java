package com.example.bmollj.getdrunk.helper;

import com.example.bmollj.getdrunk.model.Bar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class BarJsonParser {

    public static Bar createBarFromJsonString(String barJsonString) throws JSONException {
        Bar bar = new Bar();
        JSONObject jsonObj = new JSONObject(barJsonString);
        JSONArray results = jsonObj.getJSONArray("results");


        for (int i = 0; i < results.length(); i++) {
            JSONObject obj = results.getJSONObject(i);
            bar.setName(obj.getString("name"));
           /* bar.setId(Integer.parseInt(obj.getString("id")));
            bar.setBewertung(Double.parseDouble(obj.getString("rating")));*/
        }




        return bar;
    }
}
