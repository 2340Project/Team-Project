package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;



import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Austin on 2/26/17.
 */

public class WaterResourceReport {
    private int reportNumber;
    private static String location;
    private String waterType;
    private String waterCondition;
    private static LatLng latLng;

    /**
     * Constructor to instantiate the fields for the water resource report
     * @param location The location of the water source
     * @param waterType the type of the water source
     * @param waterCondition the conition of the water source
     */

    public WaterResourceReport(String location, String waterType,
                               String waterCondition, int reportNumber, LatLng latLng) {
        this.location = location;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.reportNumber = reportNumber;
        this.latLng = latLng;

    }

    public static String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    public String getWaterCondition() {
        return waterCondition;
    }

    public void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }

    public int getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }

    public static LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }


    /**
     * This represents a String representation of all attributes per report
     * @return the String of report number with the Location: water type,
     * water condition per that report
     */
    @Override
    public String toString() {
        return "" + reportNumber + ". " + location + ": " + waterType + ", "
                + waterCondition;
    }

}
