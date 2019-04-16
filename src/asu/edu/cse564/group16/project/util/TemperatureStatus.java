package asu.edu.cse564.group16.project.util;

public enum TemperatureStatus {

    VALID(1, "valid", true),
    INVALID(0, "invalid", false);

    private int index;
    private String label;
    private boolean boolValue;

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

    public boolean isBoolValue() {
        return boolValue;
    }

    public void setBoolValue(boolean boolValue) {
        this.boolValue = boolValue;
    }

    TemperatureStatus(int index, String label, boolean boolValue){
        this.index = index;
        this.label = label;
        this.boolValue = boolValue;
    }

}
