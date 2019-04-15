package asu.edu.cse564.group16.project.util;

public enum Condition {

    INDANGER(0, "In Danger"),
    SAFE(1, "Safe");


    private int index;
    private String label;

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

    Condition(int index, String label) {
        this.index = index;
        this.label = label;
    }
}
