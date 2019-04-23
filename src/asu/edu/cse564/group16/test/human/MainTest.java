package asu.edu.cse564.group16.test.human;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asu.edu.cse564.group16.project.human.Infant;
import asu.edu.cse564.group16.project.isolette.Air;
import asu.edu.cse564.group16.project.isolette.AlarmSystem;
import asu.edu.cse564.group16.project.isolette.HeatSource;
import asu.edu.cse564.group16.project.isolette.Isolette;
import asu.edu.cse564.group16.project.isolette.IsoletteOperator;
import asu.edu.cse564.group16.project.isolette.IsoletteTemperatureRangeConfig;
import asu.edu.cse564.group16.project.isolette.MonitorInterface;
import asu.edu.cse564.group16.project.isolette.MonitorSystem;
import asu.edu.cse564.group16.project.isolette.OperatorInterface;
import asu.edu.cse564.group16.project.isolette.RegulateInterface;
import asu.edu.cse564.group16.project.isolette.RegulatorSystem;
import asu.edu.cse564.group16.project.isolette.TemperatureSensor;
import asu.edu.cse564.group16.project.isolette.ThermoStat;
import asu.edu.cse564.group16.project.util.Status;
import asu.edu.cse564.group16.project.util.Switch;
import asu.edu.cse564.group16.project.util.Temperature;
import asu.edu.cse564.group16.project.util.TemperatureRange;
import asu.edu.cse564.group16.project.util.TemperatureStatus;

public class MainTest {

	Air air;
	HeatSource heatSource;
	TemperatureSensor temperatureSensor;
	Infant infant;
	OperatorInterface operatorInterface;
	Temperature lowerDesiredTemperature;
    Temperature higherDesiredTemperature;
    Temperature lowerAlarmTemperature;
    Temperature higherAlarmTemperature;
    AlarmSystem alarmSystem;
    IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig;
    
	@Before
    public void beforeEach() {
		air = new Air(new Temperature((float) 97.0, TemperatureStatus.VALID));
        heatSource = new HeatSource(Switch.OFF, air, (float) 1.0);
        temperatureSensor = new TemperatureSensor(air);
        infant = null;
        operatorInterface = new IsoletteOperator(null);
        alarmSystem = new AlarmSystem(Switch.OFF);
        
    } 
	
	@Test
	public void testMain_normal() {
		lowerDesiredTemperature = new Temperature((float) 97.0, TemperatureStatus.VALID);
        higherDesiredTemperature = new Temperature((float) 100.0, TemperatureStatus.VALID);
        lowerAlarmTemperature = new Temperature((float) 93.0, TemperatureStatus.VALID);
        higherAlarmTemperature = new Temperature((float) 103.0, TemperatureStatus.VALID);
        isoletteTemperatureRangeConfig = new IsoletteTemperatureRangeConfig(lowerDesiredTemperature,
                higherDesiredTemperature, lowerAlarmTemperature, higherAlarmTemperature);
        operatorInterface.setIsoletteConfig(isoletteTemperatureRangeConfig);
        
        TemperatureRange desiredTemperatureRange = operatorInterface.getDesiredTemperatureRange();
        TemperatureRange alarmTemperatureRange = operatorInterface.getAlarmTemperatureRange();
        MonitorInterface monitorInterface = new MonitorSystem(alarmSystem, alarmTemperatureRange, temperatureSensor);
        RegulateInterface regulateInterface = new RegulatorSystem(heatSource, desiredTemperatureRange, temperatureSensor);
        ThermoStat thermoStat1 = new ThermoStat(temperatureSensor, isoletteTemperatureRangeConfig, regulateInterface, monitorInterface);
        operatorInterface.setThermoStat(thermoStat1);
        
        Isolette isolette1 = new Isolette(operatorInterface, infant);
        float value = isolette1.getTemperature().getValue();
        TemperatureStatus status = isolette1.getTemperature().getStatus();
        System.out.println(status + " " + isolette1.getMonitorStatus() + isolette1.getRegulatorStatus());
        assertEquals(97.0, isolette1.getTemperature().getValue(), 0);
        assertEquals(TemperatureStatus.VALID, isolette1.getTemperature().getStatus());
        assertEquals(Status.NORMAL, isolette1.getMonitorStatus());
        assertEquals(Status.NORMAL, isolette1.getRegulatorStatus());
	}
	
	@Test
	public void testMain_invalidAlarm() {
		Temperature lowerDesiredTemperature = new Temperature((float) 92.0, TemperatureStatus.VALID);
        Temperature higherDesiredTemperature = new Temperature((float) 104.0, TemperatureStatus.VALID);
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
        float value = isolette1.getTemperature().getValue();
        TemperatureStatus status = isolette1.getTemperature().getStatus();
        
        System.out.println(status + " " + isolette1.getMonitorStatus() + isolette1.getRegulatorStatus());
//        assertEquals(97.0, value, 0);
//        assertEquals(TemperatureStatus.VALID, status);
	}
}
