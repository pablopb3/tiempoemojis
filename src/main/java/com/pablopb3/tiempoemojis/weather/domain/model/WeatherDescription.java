package com.pablopb3.tiempoemojis.weather.domain.model;

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

    public boolean isItCloudy() { return !cloudsLevel.equals(Intensity.LOW); }

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
}


