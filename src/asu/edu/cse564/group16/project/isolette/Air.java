package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Temperature;

public class Air {

    private Temperature airTemperature;

    public Air(Temperature airTemperature) {
        this.airTemperature = airTemperature;
    }

    public Temperature getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(Temperature airTemperature) {
        this.airTemperature = airTemperature;
    }
}
