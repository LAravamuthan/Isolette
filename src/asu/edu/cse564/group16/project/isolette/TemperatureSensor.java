/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project Isolette
 */



package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.human.Infant;
import asu.edu.cse564.group16.project.util.Temperature;
import asu.edu.cse564.group16.project.util.TemperatureStatus;

public class TemperatureSensor {

    public Temperature getCurrentTemperature(Air air, Infant infant) {

        Float currentTemperature = (air.getAirTemperature().getValue() + infant.getInfantTemperature().getValue()) / 2;
        TemperatureStatus status = air.getAirTemperature().getStatus() == TemperatureStatus.VALID &&
                infant.getInfantTemperature().getStatus() == TemperatureStatus.VALID ? TemperatureStatus.VALID:TemperatureStatus.INVALID;
        Temperature currentTemperatureObject = new Temperature(currentTemperature, status);
        return currentTemperatureObject;
    }

}
