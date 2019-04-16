package asu.edu.cse564.group16.project.human;

import asu.edu.cse564.group16.project.isolette.*;
import asu.edu.cse564.group16.project.util.*;

public class Main {

    public static void main(String[] args) {


        Temperature lowerDesiredTemperature = new Temperature((float) 97.0, TemperatureStatus.VALID);
        Temperature higherDesiredTemperature = new Temperature((float) 98.0, TemperatureStatus.VALID);
        Temperature lowerAlarmTemperature = new Temperature((float) 93.0, TemperatureStatus.VALID);
        Temperature higherAlarmTemperature = new Temperature((float) 103.0, TemperatureStatus.VALID);
        HeatSource heatSource = new HeatSource(Switch.OFF);
        AlarmSystem alarmSystem = new AlarmSystem(Switch.OFF);

        TemperatureRange desiredTemperatureRange = new TemperatureRange(lowerDesiredTemperature, higherDesiredTemperature);
        TemperatureRange alarmTemperatureRange = new TemperatureRange(lowerAlarmTemperature, higherAlarmTemperature);

        RegulateInterface regulateInterface = new RegulatorSystem(Status.INIT, heatSource);
        MonitorInterface monitorInterface = new MonitorSystem(Status.INIT, alarmSystem);
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig = new IsoletteTemperatureRangeConfig(lowerDesiredTemperature,
                higherDesiredTemperature, lowerAlarmTemperature, higherAlarmTemperature);

        ThermoStat thermoStat1 = new ThermoStat(temperatureSensor, isoletteTemperatureRangeConfig);
        Air air = new Air(new Temperature((float) 97.0, TemperatureStatus.VALID));
        Infant infant = new Infant(new Temperature((float) 80.0, TemperatureStatus.VALID));
        OperatorInterface operatorInterface = new IsoletteOperator(desiredTemperatureRange, alarmTemperatureRange,
                regulateInterface, monitorInterface, thermoStat1, air, infant);
        Isolette isolette1 = new Isolette(operatorInterface);
    }
}
