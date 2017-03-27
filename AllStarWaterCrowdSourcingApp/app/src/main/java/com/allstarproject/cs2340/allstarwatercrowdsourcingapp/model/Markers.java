package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by Austin on 3/26/17.
 */

public class Markers implements Serializable {
    private String title;
    private transient LatLng latLong;
    private String snippet;
    private double lattitude;
    private double longitude;
    public Markers(String title, LatLng ll, String snippet) {
        this.title = title;
        this.snippet = snippet;
        lattitude = ll.latitude;
        longitude = ll.longitude;

    }

    public LatLng getLatLong() {
        latLong = new LatLng(lattitude, longitude);
        return latLong;
    }
    public String getTitle() {
        return title;
    }
    public String getSnippet() {
        return snippet;
    }
}
