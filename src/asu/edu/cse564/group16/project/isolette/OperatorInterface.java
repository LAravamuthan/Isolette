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

public interface OperatorInterface {

    public Status getRegulatorStatus();

    public Status getMonitorStatus();

    public IsoletteTemperatureRangeConfig getIsoletteConfig();

    public void setIsoletteConfig(IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig);

    public Temperature getCurrentTemperature();

    public Switch switchOffAlarm();

    public TemperatureRange getDesiredTemperatureRange();

    public TemperatureRange getAlarmTemperatureRange();

    public ThermoStat getThermoStat();

    public void setThermoStat(ThermoStat thermoStat);

}
