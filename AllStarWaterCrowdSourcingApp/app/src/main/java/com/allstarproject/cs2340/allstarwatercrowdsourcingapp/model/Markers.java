package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Markers class used to create serializable Marker objects for the Google Maps object
 * This is necessary due to Google Markers and MarkerOptions being non-serializable
 * Created by Austin on 3/26/17.
 */

public class Markers implements Serializable {
    private final String title;
    private final String snippet;
    private final double lattitude;
    private final double longitude;
    public Markers(String title, LatLng ll, String snippet) {
        this.title = title;
        this.snippet = snippet;
        lattitude = ll.latitude;
        longitude = ll.longitude;

    }

    public LatLng getLatLong() {
        LatLng latLong;
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
