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

public class MonitorSystem implements MonitorInterface, Runnable {

    private Status monitorStatus = Status.FAILURE;
    private AlarmSystem alarmSystem;
    private TemperatureRange alarmTemperatureRange;
    private TemperatureSensor temperatureSensor;

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    public void setTemperatureSensor(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    public TemperatureRange getAlarmTemperatureRange() {
        return alarmTemperatureRange;
    }

    public void setAlarmTemperatureRange(TemperatureRange alarmTemperatureRange) {
        this.alarmTemperatureRange = alarmTemperatureRange;
    }

    public AlarmSystem getAlarmSystem() {
        return alarmSystem;
    }

    public void setAlarmSystem(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    public MonitorSystem(AlarmSystem alarmSystem, TemperatureRange alarmTemperatureRange, TemperatureSensor temperatureSensor) {
        this.alarmSystem = alarmSystem;
        this.alarmTemperatureRange = alarmTemperatureRange;
        this.temperatureSensor = temperatureSensor;
    }

    public Status getMonitorStatus() {
        return monitorStatus;
    }

    public void setMonitorStatus(Status monitorStatus) {
        this.monitorStatus = monitorStatus;
    }

    @Override
    public void monitorTemperature() {

        if (getTemperatureSensor().getCurrentTemperature().getValue() >=
                getAlarmTemperatureRange().getHigherTemperature().getValue()) {
            getAlarmSystem().switchOnAlarm();
        } else if (getTemperatureSensor().getCurrentTemperature().getValue() <=
                getAlarmTemperatureRange().getLowerTemperature().getValue()) {
            getAlarmSystem().switchOnAlarm();
        } else {
            if (getAlarmSystem().getAlarmSwtich().isBoolValue()) {
                getAlarmSystem().switchOffAlarm();
            }
        }
    }

    @Override
    public Status getMonitorStatusMethod() {
        return getMonitorStatus();
    }

    @Override
    public void switchOffAlarm() {
        getAlarmSystem().switchOffAlarm();
    }

    @Override
    public void switchOnAlarm() {
        getAlarmSystem().switchOffAlarm();
    }

    @Override
    public Switch getAlarmStatus() {
        return getAlarmSystem().getAlarmSwtich();
    }


    @Override
    public void run() {
        while (getMonitorStatus() != Status.FAILURE) {
            monitorTemperature();
        }

    }
}
