package com.pablopb3.tiempoemojis.weather.domain.model;

import java.util.List;

public enum MomentOfDay {
    DAY, NIGHT;

    public static List<WeatherByLocation> assureDayTimeConsistency(List<WeatherByLocation> weatherByLocation) {
        return isMomentOfDayEqualForAll(weatherByLocation) ? weatherByLocation : forceSameMomentOfDayForAll(weatherByLocation);
    }

    private static boolean isMomentOfDayEqualForAll(List<WeatherByLocation> weatherByLocation) {
        return weatherByLocation.stream().map(w -> w.getWeatherDescription().isItDay()).distinct().count() <= 1;
    }

    private static List<WeatherByLocation> forceSameMomentOfDayForAll(List<WeatherByLocation> weatherByLocation) {
        MomentOfDay momentOfDayForFirstElement = weatherByLocation.get(0).getWeatherDescription().getMomentOfDay();
        weatherByLocation.stream().forEach(w -> w.getWeatherDescription().setMomentOfDay(momentOfDayForFirstElement));
        return weatherByLocation;
    }
}
