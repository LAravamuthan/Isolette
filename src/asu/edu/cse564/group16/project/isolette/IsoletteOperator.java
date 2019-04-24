/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */

package asu.edu.cse564.group16.project.isolette;


import asu.edu.cse564.group16.project.util.Status;
import asu.edu.cse564.group16.project.util.Switch;
import asu.edu.cse564.group16.project.util.Temperature;
import asu.edu.cse564.group16.project.util.TemperatureRange;

public class IsoletteOperator implements OperatorInterface {

    private TemperatureRange desiredTemperatureRange;
    private TemperatureRange alarmTemperatureRange;
    private ThermoStat thermoStat;

    public IsoletteOperator(ThermoStat thermoStat) {
        this.thermoStat = thermoStat;
    }

    public ThermoStat getThermoStat() {
        return thermoStat;
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

    public void setThermoStat(ThermoStat thermoStat) {
        this.thermoStat = thermoStat;
    }

    @Override
    public Status getRegulatorStatus() {
        return getThermoStat().getRegulatorSystem().getRegulatorStatusMethod();
    }

    @Override
    public Status getMonitorStatus() {
        return getThermoStat().getMonitorSystem().getMonitorStatusMethod();
    }

    @Override
    public IsoletteTemperatureRangeConfig getIsoletteConfig() {
        return getThermoStat().getIsoletteTemperatureRangeConfig();
    }

    @Override
    public void setIsoletteConfig(IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig) {
        TemperatureRange desireTemperatureRange = new TemperatureRange(isoletteTemperatureRangeConfig.getLdTemp(),
                isoletteTemperatureRangeConfig.getUdTemp());
        TemperatureRange alarmTemperatureRange = new TemperatureRange(isoletteTemperatureRangeConfig.getLaTemp(),
                isoletteTemperatureRangeConfig.getUaTemp());
        setDesiredTemperatureRange(desireTemperatureRange);
        setAlarmTemperatureRange(alarmTemperatureRange);
    }

    @Override
    public Temperature getCurrentTemperature() {
        return getThermoStat().getMonitorSystem().getTemperatureSensor().getCurrentTemperature();
    }

    @Override
    public Switch switchOffAlarm() {
        getThermoStat().getMonitorSystem().switchOffAlarm();
        return getThermoStat().getMonitorSystem().getAlarmStatus();
    }
}
