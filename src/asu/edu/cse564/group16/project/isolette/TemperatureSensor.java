/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */


package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Temperature;
import asu.edu.cse564.group16.project.util.TemperatureStatus;

public class TemperatureSensor {

    private Air air;

    public TemperatureSensor(Air air) {
        this.air = air;
    }

    public Air getAir() {
        return air;
    }

    public void setAir(Air air) {
        this.air = air;
    }

    public Temperature getCurrentTemperature() {
        Float currentTemperature = (getAir().getAirTemperature().getValue());
        TemperatureStatus status = getAir().getAirTemperature().getStatus() == TemperatureStatus.VALID ?
                TemperatureStatus.VALID : TemperatureStatus.INVALID;
        Temperature currentTemperatureObject = new Temperature(currentTemperature, status);
        return currentTemperatureObject;
    }

}
