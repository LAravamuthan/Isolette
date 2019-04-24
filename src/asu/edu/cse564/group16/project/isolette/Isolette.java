/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */


package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.human.Infant;
import asu.edu.cse564.group16.project.util.*;


public class Isolette {

    private Switch isoletteSwitch;
    private DoorStatus doorStatus;
    private Infant infant;
    private OperatorInterface isoletteOperator;

    public Switch getIsoletteSwitch() {
        return isoletteSwitch;
    }

    public void setIsoletteSwitch(Switch isoletteSwitch) {
        this.isoletteSwitch = isoletteSwitch;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public Infant getInfant() {
        return infant;
    }

    public void setInfant(Infant infant) {
        this.infant = infant;
    }

    public OperatorInterface getIsoletteOperator() {
        return isoletteOperator;
    }

    public void setIsoletteOperator(OperatorInterface isoletteOperator) {
        this.isoletteOperator = isoletteOperator;
    }

    public Isolette(OperatorInterface isoletteOperator, Infant infant) {
        this.isoletteOperator = isoletteOperator;
        this.isoletteSwitch = Switch.OFF;
        this.doorStatus = DoorStatus.CLOSED;
        this.infant = infant;
    }

    public void setTemperatureRangeAndConfig(IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig) {
        getIsoletteOperator().setIsoletteConfig(isoletteTemperatureRangeConfig);
    }

    public void switchOnIsolette() {
        isoletteSwitch = Switch.ON;
    }

    public Switch switchOffAlarm() {
        return getIsoletteOperator().switchOffAlarm();
    }

    public void putInfant(Infant infant) {
        setDoorStatus(DoorStatus.OPEN);
        setInfant(infant);
        setDoorStatus(DoorStatus.CLOSED);
    }

    public Infant removeInfant() {
        setDoorStatus(DoorStatus.OPEN);
        Infant infant = getInfant();
        setDoorStatus(DoorStatus.CLOSED);
        return infant;
    }

    public void openDoor() {
        setDoorStatus(DoorStatus.OPEN);
    }

    public void closeDoor() {
        setDoorStatus(DoorStatus.CLOSED);
    }

    public Status getRegulatorStatus() {
        return getIsoletteOperator().getRegulatorStatus();
    }

    public Status getMonitorStatus() {
        return getIsoletteOperator().getMonitorStatus();
    }

    public static Isolette initialiseIsolette(Float ldt, Float hdt, Float lat, Float hat, Infant infant, Float initialAirTemp,
                                   Float haatSourceCoefficient){
        Temperature lowerDesiredTemperature = new Temperature(ldt, TemperatureStatus.VALID);
        Temperature higherDesiredTemperature = new Temperature(hdt, TemperatureStatus.VALID);
        Temperature lowerAlarmTemperature = new Temperature(lat, TemperatureStatus.VALID);
        Temperature higherAlarmTemperature = new Temperature(hat, TemperatureStatus.VALID);
        AlarmSystem alarmSystem = new AlarmSystem(Switch.OFF);
        IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig = new IsoletteTemperatureRangeConfig(lowerDesiredTemperature,
                higherDesiredTemperature, lowerAlarmTemperature, higherAlarmTemperature);
        Air air = new Air(new Temperature(initialAirTemp, TemperatureStatus.VALID));
        HeatSource heatSource = new HeatSource(Switch.OFF, air, haatSourceCoefficient);
        TemperatureSensor temperatureSensor = new TemperatureSensor(air);
        OperatorInterface operatorInterface = new IsoletteOperator(null);
        operatorInterface.setIsoletteConfig(isoletteTemperatureRangeConfig);
        TemperatureRange desiredTemperatureRange = operatorInterface.getDesiredTemperatureRange();
        TemperatureRange alarmTemperatureRange = operatorInterface.getAlarmTemperatureRange();
        MonitorInterface monitorInterface = new MonitorSystem(alarmSystem, alarmTemperatureRange, temperatureSensor);
        RegulateInterface regulateInterface = new RegulatorSystem(heatSource, desiredTemperatureRange, temperatureSensor);
        ThermoStat thermoStat1 = new ThermoStat(temperatureSensor, isoletteTemperatureRangeConfig, regulateInterface, monitorInterface);
        operatorInterface.setThermoStat(thermoStat1);
        Isolette isoletteInitialised = new Isolette(operatorInterface, infant);
        return isoletteInitialised;
    }





}
