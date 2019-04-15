package asu.edu.cse564.group16.project.isolette;

public class ThermoStat {
    private TemperatureSensor temperatureSensor;
    private IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig;


    public ThermoStat(TemperatureSensor temperatureSensor,
                      IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig) {

        this.temperatureSensor = temperatureSensor;
        this.isoletteTemperatureRangeConfig = isoletteTemperatureRangeConfig;
    }

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    public void setTemperatureSensor(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }



    public IsoletteTemperatureRangeConfig getIsoletteTemperatureRangeConfig() {
        return isoletteTemperatureRangeConfig;
    }

    public void setIsoletteTemperatureRangeConfig(IsoletteTemperatureRangeConfig isoletteTemperatureRangeConfig) {
        this.isoletteTemperatureRangeConfig = isoletteTemperatureRangeConfig;
    }
}
