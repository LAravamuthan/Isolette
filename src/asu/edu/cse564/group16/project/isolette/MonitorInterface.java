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

public interface MonitorInterface {

    public void monitorTemperature();

    public Status getMonitorStatusMethod();

    public void switchOffAlarm();

    public void switchOnAlarm();

    public Switch getAlarmStatus();

    public TemperatureRange getAlarmTemperatureRange();

    public void setAlarmTemperatureRange(TemperatureRange alarmTemperatureRange);

    public TemperatureSensor getTemperatureSensor();

    public void setTemperatureSensor(TemperatureSensor temperatureSensor);

    public AlarmSystem getAlarmSystem();

    public void setAlarmSystem(AlarmSystem alarmSystem);
}
