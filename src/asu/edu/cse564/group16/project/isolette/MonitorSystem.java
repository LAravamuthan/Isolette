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

public class MonitorSystem implements MonitorInterface {

    private Status monitorStatus = Status.FAILURE;
    private AlarmSystem alarmSystem;

    public AlarmSystem getAlarmSystem() {
        return alarmSystem;
    }

    public void setAlarmSystem(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    public MonitorSystem(Status monitorStatus, AlarmSystem alarmSystem) {
        this.monitorStatus = monitorStatus;
        this.alarmSystem = alarmSystem;
    }

    public Status getMonitorStatus() {
        return monitorStatus;
    }

    public void setMonitorStatus(Status monitorStatus) {
        this.monitorStatus = monitorStatus;
    }

    @Override
    public void monitorTemperature(TemperatureRange alarmTemperatureRange) {
        //TODO
        // regulate Isolette Temperature using Heat Source, Desired TemperatureRange and Air Temperature
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


}
