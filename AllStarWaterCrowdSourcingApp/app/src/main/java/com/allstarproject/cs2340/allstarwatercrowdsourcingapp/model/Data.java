package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

/**
 * Created by Austin on 3/27/17.
 */

public class Data implements Comparable {
    public double x;
    public int y;

    public Data(double px, int py) {
        x = px;
        y = py;
    }

    @Override
    public int compareTo(Object o) {
        Data d = (Data) o;
        int toReturn = 0;
        if (x - d.x > 0) { toReturn = 1; }
        if (x - d.x < 0) { toReturn = -1; }
        if (x - d.x == 0) { toReturn = 0; }
        return toReturn;

    }
}