/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */



package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.human.Infant;
import asu.edu.cse564.group16.project.util.DoorStatus;
import asu.edu.cse564.group16.project.util.Status;
import asu.edu.cse564.group16.project.util.Switch;
import asu.edu.cse564.group16.project.util.Temperature;


public class Isolette {

    private Switch isoletteSwitch;
    private DoorStatus doorStatus;


    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    private OperatorInterface isoletteOperator;

    public Switch getIsoletteSwitch() {
        return isoletteSwitch;
    }

    public void setIsoletteSwitch(Switch isoletteSwitch) {
        this.isoletteSwitch = isoletteSwitch;
    }

    public OperatorInterface getIsoletteOperator() {
        return isoletteOperator;
    }

    public void setIsoletteOperator(OperatorInterface isoletteOperator) {
        this.isoletteOperator = isoletteOperator;
    }


    public Isolette(OperatorInterface isoletteOperator) {
        this.isoletteOperator = isoletteOperator;
        this.isoletteSwitch = Switch.OFF;
        this.doorStatus = DoorStatus.CLOSED;
    }

    public void setTemperatureRangeAndConfig(IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig){
        getIsoletteOperator().setIsoletteConfig(isoletteTemperatureRangeConfig);
    }

    public void switchOnIsolette(){
        isoletteSwitch = Switch.ON;
    }

    public Switch switchOffAlarm(){
        return getIsoletteOperator().switchOffAlarm();
    }

    public void putInfant(Infant infant){
        setDoorStatus(DoorStatus.OPEN);
        getIsoletteOperator().putInfant(infant);
        setDoorStatus(DoorStatus.CLOSED);
    }

    public Infant removeInfant(){
        setDoorStatus(DoorStatus.OPEN);
        Infant infant = getIsoletteOperator().getInfant();
        setDoorStatus(DoorStatus.CLOSED);
        return infant;
    }

    public void openDoor(){
        setDoorStatus(DoorStatus.OPEN);
    }

    public void closeDoor(){
        setDoorStatus(DoorStatus.CLOSED);
    }

    public Temperature getTemperature(){
        return getIsoletteOperator().getCurrentTemperature();
    }

    public Status getRegulatorStatus(){
        return getIsoletteOperator().getRegulatorStatus();
    }

    public Status getMonitorStatus(){
        return getIsoletteOperator().getMonitorStatus();
    }

}
