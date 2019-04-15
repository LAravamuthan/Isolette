package asu.edu.cse564.group16.project.util;

import java.util.Objects;

public class TemperatureRange {

    private Temperature lowerTemperature;
    private Temperature higherTemperature;

    public TemperatureRange(Temperature lowerTemperature, Temperature higherTemperature) {
        this.lowerTemperature = lowerTemperature;
        this.higherTemperature = higherTemperature;
    }

    public Temperature getLowerTemperature() {
        return lowerTemperature;
    }

    public void setLowerTemperature(Temperature lowerTemperature) {
        this.lowerTemperature = lowerTemperature;
    }

    public Temperature getHigherTemperature() {
        return higherTemperature;
    }

    public void setHigherTemperature(Temperature higherTemperature) {
        this.higherTemperature = higherTemperature;
    }

    @Override
    public String toString() {
        return "TemperatureRange{" +
                "lowerTemperature=" + lowerTemperature +
                ", higherTemperature=" + higherTemperature +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureRange that = (TemperatureRange) o;
        return lowerTemperature.equals(that.lowerTemperature) &&
                higherTemperature.equals(that.higherTemperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerTemperature, higherTemperature);
    }
}
