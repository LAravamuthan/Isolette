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
        this.regulatorStatus = Status.INIT;
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
    public void regulateTemperature() {

        if (getTemperatureSensor().getCurrentTemperature().getValue() <=
                (getDesiredTemperatureRange().getHigherTemperature().getValue() - 0.1) &&
                getTemperatureSensor().getCurrentTemperature().getValue() >=
                        (getDesiredTemperatureRange().getLowerTemperature().getValue() + 0.1)) {
            getHeatSource().setHeatControlSwtich(getHeatSource().getHeatControlSwtich());
        } else if (getTemperatureSensor().getCurrentTemperature().getValue() >=
                getDesiredTemperatureRange().getHigherTemperature().getValue()) {
            getHeatSource().setHeatControlSwtich(Switch.OFF);
        } else if (getTemperatureSensor().getCurrentTemperature().getValue() <=
                getDesiredTemperatureRange().getLowerTemperature().getValue()) {
            getHeatSource().setHeatControlSwtich(Switch.ON);
        }
        setRegulatorStatus(Status.NORMAL);

        if (getHeatSource().getHeatControlSwtich().isBoolValue()) {
            getHeatSource().heatAir();
        } else {
            getHeatSource().coolAir();
        }


    }


    @Override
    public Status getRegulatorStatusMethod() {
        return getRegulatorStatus();
    }

    @Override
    public void run() {
        while (getRegulatorStatus() != Status.FAILURE) {
            regulateTemperature();
        }
    }
}




