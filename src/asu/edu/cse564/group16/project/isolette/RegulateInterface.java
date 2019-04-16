/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project Isolette
 */



package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Status;
import asu.edu.cse564.group16.project.util.TemperatureRange;

public interface RegulateInterface {

    public void regulateTemperature(TemperatureRange desiredTemperatureRange);

    public Status getRegulatorStatusMethod();
}
