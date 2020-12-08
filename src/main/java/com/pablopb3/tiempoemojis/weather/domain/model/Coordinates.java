package com.pablopb3.tiempoemojis.weather.domain.model;

public class Coordinates {

    private Double latitude;
    private Double longitude;

    public Coordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
