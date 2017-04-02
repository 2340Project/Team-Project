package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

import android.support.annotation.NonNull;

/**
 * Data class that creates (x,y) coordinate pairs that are used for graphing
 * Created by Austin on 3/27/17.
 */

public class Data implements Comparable {
    public final double x;
    public final int y;

    /**
     * user-defined constructor to initialize the coordinates for each point
     * on the graph
     * @param px the x-coordinate on the graph
     * @param py the y-coordinate on the graph
     */
    public Data(double px, int py) {
        x = px;
        y = py;
    }

    @Override
    /**
     * overide compareTo method that compares based on x coordinates
     * @return where the x-coordinate of a specific data point should be
     * plotted relative another x-coordinate on the graph
     */
    public int compareTo(@NonNull Object o) {
        Data d = (Data) o;
        int toReturn = 0;
        if (x - d.x > 0) {
            toReturn = 1;
        }
        if (x - d.x < 0) {
            toReturn = -1;
        }
        if (x - d.x == 0) {
            toReturn = 0;
        }
        return toReturn;
    }
}