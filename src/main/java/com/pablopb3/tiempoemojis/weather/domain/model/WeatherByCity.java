package com.pablopb3.tiempoemojis.weather.domain.model;

public class WeatherByCity {

    private String name;
    private Coordinates coordinates;
    private WeatherDescription weatherDescription;

    public WeatherByCity(String name, Coordinates coordinates, WeatherDescription weatherDescription) {
        this.name = name;
        this.coordinates = coordinates;
        this.weatherDescription = weatherDescription;
    }

    @Override
    public String toString() {
        return "WeatherByCity{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", weatherDescription=" + weatherDescription +
                '}';
    }
}
