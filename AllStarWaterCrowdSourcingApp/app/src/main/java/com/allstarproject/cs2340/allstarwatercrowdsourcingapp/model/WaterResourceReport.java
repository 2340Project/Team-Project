package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

/**
 * Created by Austin on 2/26/17.
 */

public class WaterResourceReport {
    private int reportNumber;
    private String location;
    private String waterType;
    private String waterCondition;

    /**
     * Constructor to instantiate the fields for the water resource report
     * @param location The location of the water source
     * @param waterType the type of the water source
     * @param waterCondition the conition of the water source
     */

    public WaterResourceReport(String location, String waterType,
                                String waterCondition, int reportNumber) {
        this.location = location;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.reportNumber = reportNumber;
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
