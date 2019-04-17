/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */




package asu.edu.cse564.group16.project.util;

import java.text.NumberFormat;
import java.util.Objects;

public class Temperature {

    private Float value;
    private TemperatureStatus status = TemperatureStatus.INVALID;

    public Temperature(Float value, TemperatureStatus status) {
        this.value = value;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "value=" + value +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        return value.equals(that.value) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, status);
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public TemperatureStatus getStatus() {
        return status;
    }

    public void setStatus(TemperatureStatus status) {
        this.status = status;
    }

    public Float getValue() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(1);
        formatter.setMaximumFractionDigits(1);
        String output = formatter.format(value);
        return Float.parseFloat(output);
    }


}
