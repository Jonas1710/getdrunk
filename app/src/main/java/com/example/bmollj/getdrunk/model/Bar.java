package com.example.bmollj.getdrunk.model;

public class Bar {
    private String id;
    private String name;
    private boolean isOpen;
    private int oeffnungZeit;
    private int schliessungsZeit;
    private float bewertung;
    private int entfernung;
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

    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isOpen=" + isOpen +
                ", oeffnungZeit=" + oeffnungZeit +
                ", schliessungsZeit=" + schliessungsZeit +
                ", bewertung=" + bewertung +
                ", entfernung=" + entfernung +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


}
