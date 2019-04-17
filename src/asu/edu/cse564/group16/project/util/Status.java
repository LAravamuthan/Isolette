/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */




package asu.edu.cse564.group16.project.util;

public enum Status {

    INIT(0, "Init"),
    NORMAL(1, "Normal"),
    FAILURE(2, "Failure");

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

    Status(int index, String label){
        this.index = index;
        this.label = label;
    }
}
