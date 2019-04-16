package asu.edu.cse564.group16.project.human;

import asu.edu.cse564.group16.project.util.Condition;
import asu.edu.cse564.group16.project.util.Temperature;





public class Infant {

    private Temperature infantTemperature;
    private Condition condition = Condition.SAFE;


    public Infant(Temperature infantTemperature) {
        this.infantTemperature = infantTemperature;
    }

    public Temperature getInfantTemperature() {
        return infantTemperature;
    }

    public void setInfantTemperature(Temperature infantTemperature) {
        this.infantTemperature = infantTemperature;
    }
}
