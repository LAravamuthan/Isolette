/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */


package asu.edu.cse564.group16.project.human;

import asu.edu.cse564.group16.project.isolette.*;
import asu.edu.cse564.group16.project.util.*;

import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("Duplicates")
public class Nurse {

    public static int counter = 1;

    public static void main(String[] args) {

        int n;
        int round = 40;
        Scanner input = new Scanner(System.in);
        Isolette isolette = null;

        while (true) { // Condition in while loop is always true here
            try {
                System.out.println("Select from below");
                System.out.println("type 1 for updating temperature ranges");
                System.out.println("type 2 get Temperature ranges");
                System.out.println("type 3 for updating Air temperature");
                System.out.println("type 4 for putting baby inside the isolette");
                System.out.println("type 5 for remove baby from isolette");
                System.out.println("type 6 for running next " + round + " rounds");
                System.out.println("type 7 for setting the Heat Increment or Decrement per round");
                System.out.println("type 8 to set no. of rounds to test");
                System.out.println("type 0 exit");
                n = input.nextInt();
                if (n == 1) {
                    System.out.println("Type the Lower desired Tempereture");
                    Float ldt = input.nextFloat();
                    while (ldt > (float) 98.0 || ldt < (float) 97.0) {
                        System.out.println("Type the Lower desired Tempereture Between 97 to 98 degrees");
                        ldt = input.nextFloat();
                    }


                    System.out.println("Type the Upper desired Tempereture");
                    Float udt = input.nextFloat();

                    while (udt > (float) 99.0 || udt < (float) 98.0) {
                        System.out.println("Type the Upper desired Tempereture Between 98 to 99 degrees");
                        udt = input.nextFloat();
                    }


                    System.out.println("Type the Lower alarm Tempereture");
                    Float lat = input.nextFloat();

                    while (lat > (float) 96.0 || lat < (float) 93.0) {
                        System.out.println("Type the Lower alarm Tempereture Between 93 to 96 degrees");
                        lat = input.nextFloat();
                    }
                    System.out.println("Type the Upper alarm Tempereture");
                    Float uat = input.nextFloat();

                    while (uat > (float) 103.0 || uat < (float) 100.0) {
                        System.out.println("Type the Upper Alarm Tempereture Between 100 to 103 degrees");
                        uat = input.nextFloat();
                    }

                    if (isolette == null) {
                        isolette = Isolette.initialiseIsolette(ldt, udt, lat, uat, null, (float) 70.0, (float) 0.1);
                    } else {
                        Temperature lowerDesiredTemperature = new Temperature(ldt, TemperatureStatus.VALID);
                        Temperature higherDesiredTemperature = new Temperature(udt, TemperatureStatus.VALID);
                        Temperature lowerAlarmTemperature = new Temperature(lat, TemperatureStatus.VALID);
                        Temperature higherAlarmTemperature = new Temperature(uat, TemperatureStatus.VALID);
                        IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig = new IsoletteTemperatureRangeConfig(lowerDesiredTemperature,
                                higherDesiredTemperature, lowerAlarmTemperature, higherAlarmTemperature);
                        isolette.getIsoletteOperator().setIsoletteConfig(isoletteTemperatureRangeConfig);
                        isolette.getIsoletteOperator().getThermoStat().getRegulatorSystem().
                                setDesiredTemperatureRange(isolette.getIsoletteOperator().getDesiredTemperatureRange());
                        isolette.getIsoletteOperator().getThermoStat().getMonitorSystem().
                                setAlarmTemperatureRange(isolette.getIsoletteOperator().getAlarmTemperatureRange());

                    }
                    regulateMonitor(isolette);
                    System.out.println("Current alarm Temperature Range : " + isolette.getIsoletteOperator().getAlarmTemperatureRange());
                    System.out.println("Current desired Temperature Range : " + isolette.getIsoletteOperator().getDesiredTemperatureRange());


                } else if (n == 3) {
                    System.out.println("Type the desired Air Tempereture");
                    Float at = input.nextFloat();
                    Temperature airTemperature = new Temperature(at, TemperatureStatus.VALID);
                    isolette.getIsoletteOperator().getThermoStat().getRegulatorSystem().getHeatSource().
                            getAir().setAirTemperature(airTemperature);

                    isolette.getIsoletteOperator().getThermoStat().getRegulatorSystem().getTemperatureSensor().
                            getAir().setAirTemperature(airTemperature);

                    isolette.getIsoletteOperator().getThermoStat().getMonitorSystem().getTemperatureSensor().
                            getAir().setAirTemperature(airTemperature);

                    System.out.println("Current air Temperature : " + isolette.getIsoletteOperator().getThermoStat().getRegulatorSystem()
                            .getTemperatureSensor().getCurrentTemperature());

                } else if (n == 4) {
                    Infant infant = new Infant(new Temperature((float) 98.0, TemperatureStatus.VALID));
                    isolette.setInfant(infant);
                    System.out.println("Current Infant : " + isolette.getInfant());
                } else if (n == 5) {
                    isolette.setInfant(null);
                    System.out.println("Current Infant : " + isolette.getInfant());
                } else if (n == 6) {

                    for (int i = 0; i < round; i++) {
                        regulateMonitor(isolette);
                        System.out.println("Various Systems after round: " +  ++counter);
                        System.out.println("Air temperature :" +
                                isolette.getIsoletteOperator().getCurrentTemperature(false));
                        System.out.println("Alarm Status :" +
                                isolette.getIsoletteOperator().getThermoStat().getMonitorSystem().getAlarmStatus());
                        System.out.println("Heat Source Rate: " +
                                isolette.getIsoletteOperator().getThermoStat().getRegulatorSystem().getHeatSource().getHeatIncreaseRate());
                        System.out.println("Infant Status: " +
                                isolette.getInfant());
                        System.out.println("Regulator System Status : " + isolette.getIsoletteOperator().getThermoStat()
                        .getRegulatorSystem().getRegulatorStatusMethod());
                        System.out.println("Monitor System Status : " + isolette.getIsoletteOperator().getThermoStat()
                                .getMonitorSystem().getMonitorStatusMethod());
                        System.out.println("Display Temperature : " + isolette.getIsoletteOperator().getCurrentTemperature(true));
                    }

                } else if (n == 7) {
                    System.out.println("Heat rate : ");
                    Float rt = input.nextFloat();
                    isolette.getIsoletteOperator().getThermoStat().getRegulatorSystem().getHeatSource().setHeatIncreaseRate(rt);
                } else if (n == 8) {
                    System.out.println("No. of rounds to run in one go : ");
                    round = input.nextInt();
                }else if (n == 2) {
                    System.out.println("Current alarm Temperature Range : " + isolette.getIsoletteOperator().getAlarmTemperatureRange());
                    System.out.println("Current desired Temperature Range : " + isolette.getIsoletteOperator().getDesiredTemperatureRange());
                }
                if (n == 0) {
                    System.out.println("Bye Bye! " + n);
                    break;
                }
            } catch (Exception e) {
                if (e instanceof NullPointerException) {
                    System.out.println("Kindly set desired and alarm Temperature Range");
                }
            }
        }
    }

    public static void regulateMonitor(Isolette isolette) {
        isolette.getIsoletteOperator().getThermoStat().getRegulatorSystem().
                regulateTemperature();
        isolette.getIsoletteOperator().getThermoStat().getMonitorSystem().monitorTemperature
                ();
    }

    public static void addThreads(Isolette isolette) {
        ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(5);
        threadPool.scheduleAtFixedRate((MonitorSystem) isolette.getIsoletteOperator().getThermoStat().getMonitorSystem(),
                0, 100, TimeUnit.MILLISECONDS);
        threadPool.scheduleAtFixedRate((RegulatorSystem) isolette.getIsoletteOperator().getThermoStat().getRegulatorSystem(),
                0, 100, TimeUnit.SECONDS);
    }
}
