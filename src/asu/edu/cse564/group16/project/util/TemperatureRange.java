package asu.edu.cse564.group16.project.util;

import java.util.Objects;

public class TemperatureRange {

    private Temperature lowerTemperature;
    private Temperature higherTemperature;
    private TemperatureStatus status;

    @Override
    public String toString() {
        return "TemperatureRange{" +
                "lowerTemperature=" + lowerTemperature +
                ", higherTemperature=" + higherTemperature +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureRange that = (TemperatureRange) o;
        return lowerTemperature.equals(that.lowerTemperature) &&
                higherTemperature.equals(that.higherTemperature) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerTemperature, higherTemperature, status);
    }

    public TemperatureRange(Temperature lowerTemperature, Temperature higherTemperature) {
        this.lowerTemperature = lowerTemperature;
        this.higherTemperature = higherTemperature;
        if(this.lowerTemperature.getStatus().isBoolValue() && this.higherTemperature.getStatus().isBoolValue()){
            this.status = TemperatureStatus.VALID;
        }else{
            this.status = TemperatureStatus.INVALID;
        }
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

    public TemperatureStatus getStatus() {
        return status;
    }

    public void setStatus(TemperatureStatus status) {
        this.status = status;
    }
}
