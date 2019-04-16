/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project Isolette
 */


package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Status;
import asu.edu.cse564.group16.project.util.Switch;
import asu.edu.cse564.group16.project.util.TemperatureRange;

public interface MonitorInterface {

    public void monitorTemperature(TemperatureRange alarmTemperatureRange);

    public Status getMonitorStatusMethod();

    public void switchOffAlarm();

    public void switchOnAlarm();

    public Switch getAlarmStatus();

}
