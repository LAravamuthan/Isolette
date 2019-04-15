package asu.edu.cse564.group16.project.isolette;

public class Isolette {

    private ThermoStat thermoStat;
    private OperatorInterface isoletteOperator = new IsoletteOperator();
    private HeatSource heatSource;


    public Isolette(ThermoStat thermoStat, OperatorInterface isoletteOperator, HeatSource heatSource) {
        this.thermoStat = thermoStat;
        this.isoletteOperator = isoletteOperator;
        this.heatSource = heatSource;
    }


}
