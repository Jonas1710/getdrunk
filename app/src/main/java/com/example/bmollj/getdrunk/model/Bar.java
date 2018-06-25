package com.example.bmollj.getdrunk.model;

public class Bar {
    private String id;
    private String name;
    private boolean isOpen;
    private int oeffnungszeit;
    private int schliessungsZeit;
    private float bewertung;
    private int entfernung;
    private String placeId;
    private String photoreference;
    private double lat;
    private double lng;

    //TODO
    //Standort und Bild hinzufügen


    public Bar() {
    }

    public Bar(String id, String name, boolean isOpen,int oeffnungszeit, int schliessungsZeit, float bewertung, int entfernung) {
        this.id = id;
        this.name = name;
        this.isOpen = isOpen;
        this.oeffnungszeit = oeffnungszeit;
        this.schliessungsZeit = schliessungsZeit;
        this.bewertung = bewertung;
        this.entfernung = entfernung;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isOpen=" + isOpen +
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

    public String isOpen() {
        if(isOpen){
            return "open";
        }
        else{
            return "closed";
        }

    }

    public void setOpen(boolean open) {
        isOpen = open;
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

    public int getOeffnungszeit() {
        return oeffnungszeit;
    }

    public void setOeffnungszeit(int oeffnungszeit){this.oeffnungszeit = oeffnungszeit;}
}
