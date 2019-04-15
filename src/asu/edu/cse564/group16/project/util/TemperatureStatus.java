package asu.edu.cse564.group16.project.util;

public enum TemperatureStatus {

    VALID(0, "valid"),
    INVALID(1, "invalid");

    private int index;
    private String label;

    TemperatureStatus(int index, String label){
        this.index = index;
        this.label = label;
    }






}
