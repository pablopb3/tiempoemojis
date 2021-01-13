package com.pablopb3.tiempoemojis.weather.domain.model;

public class WeatherByLocation {

    private String name;
    private String locationCode;
    private Coordinates coordinates;
    private WeatherDescription weatherDescription;

    public WeatherByLocation(String name, String locationCode, Coordinates coordinates, WeatherDescription weatherDescription) {
        this.name = name;
        this.locationCode = locationCode;
        this.coordinates = coordinates;
        this.weatherDescription = weatherDescription;
    }

    public String getName() {
        return name;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public WeatherDescription getWeatherDescription() {
        return weatherDescription;
    }

    @Override
    public String toString() {
        return "WeatherByCity{" +
                "name='" + name + '\'' +
                "cityCode='" + locationCode + '\'' +
                ", coordinates=" + coordinates +
                ", weatherDescription=" + weatherDescription +
                '}';
    }
}
