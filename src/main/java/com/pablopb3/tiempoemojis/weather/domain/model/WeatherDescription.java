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
