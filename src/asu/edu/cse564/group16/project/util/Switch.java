/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */



package asu.edu.cse564.group16.project.util;

public enum Switch {
    ON(1, "On", true),
    OFF(0, "Off", false);

    private int index;
    private String label;
    private boolean boolValue;

    public boolean isBoolValue() {
        return boolValue;
    }

    public void setBoolValue(boolean boolValue) {
        this.boolValue = boolValue;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    Switch(int index, String label, boolean boolValue) {
        this.index = index;
        this.label = label;
        this.boolValue = boolValue;
    }
}
