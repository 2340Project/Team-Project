package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * WaterPurityReport class is used to create Water Purity Report objects created
 * by workers and managers.  These reports represent the amount of toxins in
 * water (virus or contaminant) and will be used to display a graph of the
 * levels of toxins over a certain time period
 * Created by Austin on 3/12/17.
 */


public class WaterPurityReport implements Serializable{

    private final int reportNumber;
    private final String location;
    private final double virusPPM;
    private final String waterCondition;
    private final java.util.Date date;
    private final String dateAndTime;
    private final String creator;
    private final String vType;


    /**
     * Constructor to instantiate the fields for the water resource report
     * @param location The location of the water source
     * @param virusPPM the amount of the virusPPM
     * @param waterCondition the water condition of the water purity report
     * @param vType the virus type of whether its a contaminant or virus
     * @param reportNumber the number associated with the water purity report
     * @param name the name of the workers || managers who created the water
     * purity report
     */

    public WaterPurityReport(String location, String waterCondition,
                               double virusPPM, String vType,
                             int reportNumber, String name) {
        this.location = location;
        this.virusPPM = virusPPM;
        this.vType = vType;
        this.waterCondition = waterCondition;
        this.reportNumber = reportNumber;
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        date = new java.util.Date();
        dateAndTime = dateFormat.format(date);
        creator = name;
    }

    /**
     * getter method to get the virus type that was submitted in this
     * Purity Report
     * @return a string representation of the virus type
     */
    public String getVirusType() {
        return this.vType;
    }

    /**
     * getter Method for getting the creation date of a Purity Report
     * @return the date object for which a PurityReport Instance was created
     */
    public java.util.Date getDate() {
        return date;
    }

    /**
     * getter method for the water condition of the water resource report
     * @return a String of the locations water condition
     */
    public String getWaterCondition() {
        return waterCondition;
    }

    /**
     * A getter for the virusPPM
     * @return the amount of the virus PPM corresponding to a particular
     * water purity report
     */
    public double getVirusPPM() {
        return virusPPM;
    }

    /**
     * This represents a String representation of all attributes per report
     * @return the String of report number with the Location: water type,
     * water condition per that report
     */
    @Override
    public String toString() {
        return "" + reportNumber + ". " + dateAndTime + " , "
                + "Submitted by: " + "" + creator + " , " + location + ": "
                + virusPPM + " Virus/Contaminant PPM , "  + waterCondition
                + "\n";
    }
    @Override
    public boolean equals(Object wpr) {
        if (this.getVirusType().equals(((WaterPurityReport) wpr)
                .getVirusType()) && this.dateAndTime
                .equals(((WaterPurityReport) wpr).dateAndTime) && this.creator
                .equals(((WaterPurityReport) wpr).creator)
                && this.location.equals(((WaterPurityReport) wpr).location)
                && this.virusPPM == (((WaterPurityReport) wpr).virusPPM)
                && this.waterCondition.equals(((WaterPurityReport)
                wpr).waterCondition)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to get the date and time for this report. *Only for testing*
     * @return the water purity reports date and time
     */
    public String getDateAndTime() {
        return dateAndTime;
    }
}
