/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */


package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Status;
import asu.edu.cse564.group16.project.util.Switch;
import asu.edu.cse564.group16.project.util.TemperatureRange;

public class RegulatorSystem implements RegulateInterface, Runnable {
    private Status regulatorStatus = Status.FAILURE;
    private HeatSource heatSource;
    private TemperatureRange desiredTemperatureRange;
    private TemperatureSensor temperatureSensor;

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    public void setTemperatureSensor(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    public RegulatorSystem(HeatSource heatSource, TemperatureRange desiredTemperatureRange, TemperatureSensor temperatureSensor) {
        this.heatSource = heatSource;
        this.desiredTemperatureRange = desiredTemperatureRange;
        this.temperatureSensor = temperatureSensor;
    }

    public HeatSource getHeatSource() {
        return heatSource;
    }

    public void setHeatSource(HeatSource heatSource) {
        this.heatSource = heatSource;
    }

    public TemperatureRange getDesiredTemperatureRange() {
        return desiredTemperatureRange;
    }

    public void setDesiredTemperatureRange(TemperatureRange desiredTemperatureRange) {
        this.desiredTemperatureRange = desiredTemperatureRange;
    }


    public Status getRegulatorStatus() {
        return regulatorStatus;
    }

    public void setRegulatorStatus(Status regulatorStatus) {
        this.regulatorStatus = regulatorStatus;
    }

    @Override
    public void regulateTemperature(TemperatureRange desiredTemperatureRange, HeatSource heatSource,
                                    TemperatureSensor temperatureSensor) {
        if(temperatureSensor.getCurrentTemperature().getValue() >=
                desiredTemperatureRange.getHigherTemperature().getValue()){
            heatSource.setHeatControlSwtich(Switch.OFF);
        }else if(temperatureSensor.getCurrentTemperature().getValue() <=
                desiredTemperatureRange.getLowerTemperature().getValue()){
            heatSource.setHeatControlSwtich(Switch.ON);
        }
        if(heatSource.getHeatControlSwtich().isBoolValue()){
            heatSource.heatAir();
        }else{
            heatSource.coolAir();
        }
    }



    @Override
    public Status getRegulatorStatusMethod() {
        return getRegulatorStatus();
    }

    @Override
    public void run() {
        while (getRegulatorStatus() != Status.FAILURE){
            regulateTemperature(getDesiredTemperatureRange(), getHeatSource(), getTemperatureSensor());
        }
    }
}




