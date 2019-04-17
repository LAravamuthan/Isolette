/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */


package asu.edu.cse564.group16.project.human;

import asu.edu.cse564.group16.project.isolette.*;
import asu.edu.cse564.group16.project.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Temperature lowerDesiredTemperature = new Temperature((float) 97.0, TemperatureStatus.VALID);
        Temperature higherDesiredTemperature = new Temperature((float) 98.0, TemperatureStatus.VALID);
        Temperature lowerAlarmTemperature = new Temperature((float) 93.0, TemperatureStatus.VALID);
        Temperature higherAlarmTemperature = new Temperature((float) 103.0, TemperatureStatus.VALID);
        AlarmSystem alarmSystem = new AlarmSystem(Switch.OFF);
        IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig = new IsoletteTemperatureRangeConfig(lowerDesiredTemperature,
                higherDesiredTemperature, lowerAlarmTemperature, higherAlarmTemperature);
        Air air = new Air(new Temperature((float) 97.0, TemperatureStatus.VALID));
        HeatSource heatSource = new HeatSource(Switch.OFF, air, (float) 1.0);
        TemperatureSensor temperatureSensor = new TemperatureSensor(air);
        Infant infant = null;
        OperatorInterface operatorInterface = new IsoletteOperator(null);
        operatorInterface.setIsoletteConfig(isoletteTemperatureRangeConfig);
        TemperatureRange desiredTemperatureRange = operatorInterface.getDesiredTemperatureRange();
        TemperatureRange alarmTemperatureRange = operatorInterface.getAlarmTemperatureRange();
        MonitorInterface monitorInterface = new MonitorSystem(alarmSystem, alarmTemperatureRange, temperatureSensor);
        RegulateInterface regulateInterface = new RegulatorSystem(heatSource, desiredTemperatureRange, temperatureSensor);
        ThermoStat thermoStat1 = new ThermoStat(temperatureSensor, isoletteTemperatureRangeConfig, regulateInterface, monitorInterface);
        operatorInterface.setThermoStat(thermoStat1);
        Isolette isolette1 = new Isolette(operatorInterface, infant);

    }

    public static void addThreads(Isolette isolette1){
        ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(5);
        threadPool.scheduleAtFixedRate((MonitorSystem)isolette1.getIsoletteOperator().getThermoStat().getMonitorSystem(),
                0, 5, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate((RegulatorSystem)isolette1.getIsoletteOperator().getThermoStat().getRegulatorSystem(),
                0, 5, TimeUnit.SECONDS);
    }
}
