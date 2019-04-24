/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */


package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Status;
import asu.edu.cse564.group16.project.util.TemperatureRange;

public interface RegulateInterface {

    public void regulateTemperature();

    public Status getRegulatorStatusMethod();

    public TemperatureRange getDesiredTemperatureRange();

    public void setDesiredTemperatureRange(TemperatureRange desiredTemperatureRange);

    public HeatSource getHeatSource();

    public void setHeatSource(HeatSource heatSource);

    public TemperatureSensor getTemperatureSensor();

    public void setTemperatureSensor(TemperatureSensor temperatureSensor);
}
