/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */



package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Switch;

public class HeatSource {

    private Switch heatControlSwtich;
    private Air air;
    private Float heatIncreaseRate;

    public Air getAir() {
        return air;
    }

    public void setAir(Air air) {
        this.air = air;
    }

    public HeatSource(Switch heatControlSwtich, Air air, Float heatIncreaseRate) {
        this.heatControlSwtich = heatControlSwtich;
        this.air = air;
        this.heatIncreaseRate = heatIncreaseRate;
    }

    public Switch getHeatControlSwtich() {
        return heatControlSwtich;
    }

    public void setHeatControlSwtich(Switch heatControlSwtich) {
        this.heatControlSwtich = heatControlSwtich;
    }

    public Float getHeatIncreaseRate() {
        return heatIncreaseRate;
    }

    public void setHeatIncreaseRate(Float heatIncreaseRate) {
        this.heatIncreaseRate = heatIncreaseRate;
    }

    public void heatAir(){
        getAir().getAirTemperature().setValue(getAir().getAirTemperature().getValue() + getHeatIncreaseRate());
    }

    public void coolAir(){
        getAir().getAirTemperature().setValue(getAir().getAirTemperature().getValue() - getHeatIncreaseRate());
    }




}
