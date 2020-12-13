package com.pablopb3.tiempoemojis.weather.domain.model;

import java.util.Objects;

public class WeatherDescription {

    private MomentOfDay momentOfDay;
    private Intensity cloudsLevel;
    private Intensity rainLevel;
    private Intensity snowLevel;

    public WeatherDescription(MomentOfDay momentOfDay, Intensity cloudsLevel, Intensity rainLevel, Intensity snowLevel) {
        this.momentOfDay = momentOfDay;
        this.cloudsLevel = cloudsLevel;
        this.rainLevel = rainLevel;
        this.snowLevel = snowLevel;
    }

    public Intensity getCloudsLevel() {
        return cloudsLevel;
    }

    public boolean isSkyClear() { return cloudsLevel.equals(Intensity.NONE); }

    public boolean isItDay() { return momentOfDay.equals(MomentOfDay.DAY); }

    public boolean isItNight() { return !isItDay(); }

    public boolean isItCloudy() { return !cloudsLevel.equals(Intensity.NONE); }

    public boolean isTherePrecipitations() { return isItRainy() || isStorming() || isSnowing(); }

    public boolean isItRainy() { return rainLevel.equals(Intensity.LOW) || rainLevel.equals(Intensity.MEDIUM); }

    public boolean isStorming() { return rainLevel.equals(Intensity.VERY_HIGH); }

    public boolean isSnowing() { return !snowLevel.equals(Intensity.NONE); }

    @Override
    public String toString() {
        return "WeatherDescription{" +
                "momentOfDay=" + momentOfDay +
                ", cloudsLevel=" + cloudsLevel +
                ", rainLevel=" + rainLevel +
                ", snowLevel=" + snowLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherDescription that = (WeatherDescription) o;
        return momentOfDay == that.momentOfDay && cloudsLevel == that.cloudsLevel && rainLevel == that.rainLevel && snowLevel == that.snowLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(momentOfDay, cloudsLevel, rainLevel, snowLevel);
    }
}


