package com.pablopb3.tiempoemojis.weather.domain.model;

public class WeatherByCity {

    private String name;
    private String cityCode;
    private Coordinates coordinates;
    private WeatherDescription weatherDescription;

    public WeatherByCity(String name, String cityCode, Coordinates coordinates, WeatherDescription weatherDescription) {
        this.name = name;
        this.cityCode = cityCode;
        this.coordinates = coordinates;
        this.weatherDescription = weatherDescription;
    }

    public String getName() {
        return name;
    }

    public String getCityCode() {
        return cityCode;
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
                "cityCode='" + cityCode + '\'' +
                ", coordinates=" + coordinates +
                ", weatherDescription=" + weatherDescription +
                '}';
    }
}
