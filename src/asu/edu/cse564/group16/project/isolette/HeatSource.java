package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Switch;

public class HeatSource {

    private Switch heatControlSwtich;

    public Switch getHeatControlSwtich() {
        return heatControlSwtich;
    }

    public void setHeatControlSwtich(Switch heatControlSwtich) {
        this.heatControlSwtich = heatControlSwtich;
    }

    public HeatSource(Switch heatControlSwtich) {
        this.heatControlSwtich = heatControlSwtich;
    }

    public void heatAir(Air air){
        //TODO write heat Air logic
    }




}
