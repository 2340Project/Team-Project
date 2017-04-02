package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Markers class used to create serializable Marker objects for the Google Maps
 * object. This is necessary due to Google Markers and MarkerOptions being
 * non-serializable
 * Created by Austin on 3/26/17.
 */

public class Markers implements Serializable {
    private final String title;
    private final String snippet;
    private final double lattitude;
    private final double longitude;
    /**
     * This is a constructor to initialize and instantiate all fields for a
     * marker
     * @param title the title of the marker
     * @param ll the latitude and longitude of the marker
     * @param snippet the snippet that hold the title where the title is the
     * location, the type of water, and the status of the water.
     */
    public Markers(String title, LatLng ll, String snippet) {
        this.title = title;
        this.snippet = snippet;
        lattitude = ll.latitude;
        longitude = ll.longitude;

    }
    /**
     * getter for the latitude and longitude for a specific marker
     * @return the latitude and longitude for a specific marker
     */
    public LatLng getLatLong() {
        LatLng latLong;
        latLong = new LatLng(lattitude, longitude);
        return latLong;
    }
    /**
     * getter for the title of a specific marker.
     * @return the title for a specific marker.
     */
    public String getTitle() {
        return title;
    }

    /**
     * getter for the snippet of a specific marker which contains the title
     * of the marker (title = location of marker), the type of water, and the
     * status of the water.
     * @return the snippet for the specific marker.
     */
    public String getSnippet() {
        return snippet;
    }
}


