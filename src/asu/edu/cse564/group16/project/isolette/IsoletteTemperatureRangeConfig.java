/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @author Namratha
 * @project Isolette
 */



package asu.edu.cse564.group16.project.isolette;

import asu.edu.cse564.group16.project.util.Temperature;

import java.util.Objects;


public class IsoletteTemperatureRangeConfig {

    private Temperature ldTemp;
    private Temperature udTemp;
    private Temperature laTemp;
    private Temperature uaTemp;


    public IsoletteTemperatureRangeConfig(Temperature ldTemp, Temperature udTemp, Temperature laTemp, Temperature uaTemp) {
        this.ldTemp = ldTemp;
        this.udTemp = udTemp;
        this.laTemp = laTemp;
        this.uaTemp = uaTemp;
    }


    @Override
    public String toString() {
        return "IsoletteTemperatureRangeConfig{" +
                "ldTemp=" + ldTemp +
                ", udTemp=" + udTemp +
                ", laTemp=" + laTemp +
                ", uaTemp=" + uaTemp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsoletteTemperatureRangeConfig that = (IsoletteTemperatureRangeConfig) o;
        return ldTemp.equals(that.ldTemp) &&
                udTemp.equals(that.udTemp) &&
                laTemp.equals(that.laTemp) &&
                uaTemp.equals(that.uaTemp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ldTemp, udTemp, laTemp, uaTemp);
    }

    public Temperature getLdTemp() {
        return ldTemp;
    }

    public void setLdTemp(Temperature ldTemp) {
        this.ldTemp = ldTemp;
    }

    public Temperature getUdTemp() {
        return udTemp;
    }

    public void setUdTemp(Temperature udTemp) {
        this.udTemp = udTemp;
    }

    public Temperature getLaTemp() {
        return laTemp;
    }

    public void setLaTemp(Temperature laTemp) {
        this.laTemp = laTemp;
    }

    public Temperature getUaTemp() {
        return uaTemp;
    }

    public void setUaTemp(Temperature uaTemp) {
        this.uaTemp = uaTemp;
    }
}
