package com.example.bmollj.getdrunk.model;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResponse;
import com.google.android.gms.location.places.PlacePhotoResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Bar {
    private String id;
    private String name;
    private boolean isOpen;
    private int oeffnungZeit;
    private int schliessungsZeit;
    private float bewertung;
    private int entfernung;
    private String placeId;
    private String photoreference;
    private float lat;
    private float lng;

    //TODO
    //Standort und Bild hinzufügen


    public Bar() {
    }

    public Bar(String id, String name, boolean isOpen, int oeffnungZeit, int schliessungsZeit, float bewertung, int entfernung) {
        this.id = id;
        this.name = name;
        this.isOpen = isOpen;
        this.oeffnungZeit = oeffnungZeit;
        this.schliessungsZeit = schliessungsZeit;
        this.bewertung = bewertung;
        this.entfernung = entfernung;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isOpen=" + isOpen +
                ", oeffnungZeit=" + oeffnungZeit +
                ", schliessungsZeit=" + schliessungsZeit +
                ", bewertung=" + bewertung +
                ", entfernung=" + entfernung +
                ", placeId='" + placeId + '\'' +
                ", photoreference='" + photoreference + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotoreference() {
        return photoreference;
    }

    public void setPhotoreference(String photoreference) {
        this.photoreference = photoreference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getOeffnungZeit() {
        return oeffnungZeit;
    }

    public void setOeffnungZeit(int oeffnungZeit) {
        this.oeffnungZeit = oeffnungZeit;
    }

    public int getSchliessungsZeit() {
        return schliessungsZeit;
    }

    public void setSchliessungsZeit(int schliessungsZeit) {
        this.schliessungsZeit = schliessungsZeit;
    }

    public float getBewertung() {
        return bewertung;
    }

    public void setBewertung(float bewertung) {
        this.bewertung = bewertung;
    }

    public int getEntfernung() {
        return entfernung;
    }

    public void setEntfernung(int entfernung) {
        this.entfernung = entfernung;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }




}
