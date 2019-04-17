/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */



package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.human.Infant;
import asu.edu.cse564.group16.project.util.Status;
import asu.edu.cse564.group16.project.util.Switch;
import asu.edu.cse564.group16.project.util.Temperature;
import asu.edu.cse564.group16.project.util.TemperatureRange;

public class IsoletteOperator implements OperatorInterface {

    private TemperatureRange desiredTemperatureRange;
    private TemperatureRange alarmTemperatureRange;
    private RegulateInterface regulatorSystem;
    private MonitorInterface monitorSystem;
    private ThermoStat thermoStat;
    private Air air;
    private Infant infant;

    public IsoletteOperator(TemperatureRange desiredTemperatureRange, TemperatureRange alarmTemperatureRange,
                            RegulateInterface regulatorSystem,
                            MonitorInterface monitorSystem, ThermoStat thermoStat, Air air, Infant infant) {
        this.desiredTemperatureRange = desiredTemperatureRange;
        this.alarmTemperatureRange = alarmTemperatureRange;
        this.regulatorSystem = regulatorSystem;
        this.monitorSystem = monitorSystem;
        this.thermoStat = thermoStat;
        this.air = air;
        this.infant = infant;
    }

    public RegulateInterface getRegulatorSystem() {
        return regulatorSystem;
    }

    public void setRegulatorSystem(RegulateInterface regulatorSystem) {
        this.regulatorSystem = regulatorSystem;
    }

    public MonitorInterface getMonitorSystem() {
        return monitorSystem;
    }

    public void setMonitorSystem(MonitorInterface monitorSystem) {
        this.monitorSystem = monitorSystem;
    }

    public Air getAir() {
        return air;
    }

    public void setAir(Air air) {
        this.air = air;
    }

    public Infant getInfant() {
        return infant;
    }

    public void setInfant(Infant infant) {
        this.infant = infant;
    }

    public TemperatureRange getDesiredTemperatureRange() {
        return desiredTemperatureRange;
    }

    public void setDesiredTemperatureRange(TemperatureRange desiredTemperatureRange) {
        this.desiredTemperatureRange = desiredTemperatureRange;
    }

    public TemperatureRange getAlarmTemperatureRange() {
        return alarmTemperatureRange;
    }

    public void setAlarmTemperatureRange(TemperatureRange alarmTemperatureRange) {
        this.alarmTemperatureRange = alarmTemperatureRange;
    }


    public void setMonitorSystem(MonitorSystem monitorSystem) {
        this.monitorSystem = monitorSystem;
    }

    public ThermoStat getThermoStat() {
        return thermoStat;
    }

    public void setThermoStat(ThermoStat thermoStat) {
        this.thermoStat = thermoStat;
    }

    @Override
    public Status getRegulatorStatus() {
        return getRegulatorSystem().getRegulatorStatusMethod();
    }

    @Override
    public Status getMonitorStatus() {
        return getMonitorSystem().getMonitorStatusMethod();
    }

    @Override
    public IsoletteTemperatureRangeConfig getIsoletteConfig() {
        return getThermoStat().getIsoletteTemperatureRangeConfig();
    }

    @Override
    public void setIsoletteConfig(IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig) {
        getDesiredTemperatureRange().setHigherTemperature(isoletteTemperatureRangeConfig.getUdTemp());
        getDesiredTemperatureRange().setLowerTemperature(isoletteTemperatureRangeConfig.getLdTemp());
        getAlarmTemperatureRange().setLowerTemperature(isoletteTemperatureRangeConfig.getLaTemp());
        getAlarmTemperatureRange().setHigherTemperature(isoletteTemperatureRangeConfig.getUaTemp());
    }

    @Override
    public Temperature getCurrentTemperature() {
        return getThermoStat().getTemperatureSensor().getCurrentTemperature(air, infant);
    }

    @Override
    public Switch switchOffAlarm() {
        getMonitorSystem().switchOffAlarm();
        return getMonitorSystem().getAlarmStatus();
    }

    @Override
    public void putInfant(Infant infant) {
        setInfant(infant);
    }

}
