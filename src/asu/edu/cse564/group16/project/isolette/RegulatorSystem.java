/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project Isolette
 */



package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Status;
import asu.edu.cse564.group16.project.util.TemperatureRange;

public class RegulatorSystem implements RegulateInterface{
    private Status regulatorStatus = Status.FAILURE;
    private HeatSource heatSource;


    public RegulatorSystem(Status regulatorStatus, HeatSource heatSource) {
        this.regulatorStatus = regulatorStatus;
        this.heatSource = heatSource;
    }

    public Status getRegulatorStatus() {
        return regulatorStatus;
    }

    public void setRegulatorStatus(Status regulatorStatus) {
        this.regulatorStatus = regulatorStatus;
    }

    @Override
    public void regulateTemperature(TemperatureRange desiredTemperatureRange) {
        //TODO
        // regulate Isolette Temperature using Heat Source, Desired TemperatureRange and Air Temperature
    }

    @Override
    public Status getRegulatorStatusMethod() {
        return getRegulatorStatus();
    }

}




