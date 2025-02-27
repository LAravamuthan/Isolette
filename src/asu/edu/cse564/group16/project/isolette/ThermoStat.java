/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */


package asu.edu.cse564.group16.project.isolette;

public class ThermoStat {

    private IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig;
    private RegulateInterface regulatorSystem;
    private MonitorInterface monitorSystem;

    public ThermoStat(TemperatureSensor temperatureSensor,
                      IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig,
                      RegulateInterface regulatorSystem, MonitorInterface monitorSystem) {
        this.isoletteTemperatureRangeConfig = isoletteTemperatureRangeConfig;
        this.regulatorSystem = regulatorSystem;
        this.monitorSystem = monitorSystem;
    }

    public RegulateInterface getRegulatorSystem() {
        return regulatorSystem;
    }

    public void setRegulatorSystem(RegulateInterface regulatorSystem) {
        this.regulatorSystem = regulatorSystem;
    }

    public MonitorInterface getMonitorSystem() {
        return monitorSystem;
    }

    public void setMonitorSystem(MonitorInterface monitorSystem) {
        this.monitorSystem = monitorSystem;
    }

    public IsoletteTemperatureRangeConfig getIsoletteTemperatureRangeConfig() {
        return isoletteTemperatureRangeConfig;
    }

    public void setIsoletteTemperatureRangeConfig(IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig) {
        this.isoletteTemperatureRangeConfig = isoletteTemperatureRangeConfig;
    }
}
