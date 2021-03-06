package com.pablopb3.tiempoemojis.weather.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class MomentOfDayTest {

    private Logger log = LoggerFactory.getLogger(MomentOfDayTest.class);

    @Test
    void allAreDayBeforeAndAfterProcessing() {
        List<WeatherByLocation> weatherByLocationList = new ArrayList<>();
        weatherByLocationList.add(new WeatherByLocation("city1", "c1", null, new WeatherDescription(MomentOfDay.DAY, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList.add(new WeatherByLocation("city2", "c2", null, new WeatherDescription(MomentOfDay.DAY, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList.add(new WeatherByLocation("city3", "c3", null, new WeatherDescription(MomentOfDay.DAY, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList = MomentOfDay.assureDayTimeConsistency(weatherByLocationList);
        Assertions.assertTrue(weatherByLocationList.stream().allMatch(w -> w.getWeatherDescription().getMomentOfDay().equals(MomentOfDay.DAY)));
    }

    @Test
    void allAreNightBeforeAndAfterProcessing() {
        List<WeatherByLocation> weatherByLocationList = new ArrayList<>();
        weatherByLocationList.add(new WeatherByLocation("city1", "c1", null, new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList.add(new WeatherByLocation("city2", "c2", null, new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList.add(new WeatherByLocation("city3", "c3", null, new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList = MomentOfDay.assureDayTimeConsistency(weatherByLocationList);
        Assertions.assertTrue(weatherByLocationList.stream().allMatch(w -> w.getWeatherDescription().getMomentOfDay().equals(MomentOfDay.NIGHT)));
    }

    @Test
    void mixedBeforeAndDayAfterProcessing() {
        List<WeatherByLocation> weatherByLocationList = new ArrayList<>();
        weatherByLocationList.add(new WeatherByLocation("city1", "c1", null, new WeatherDescription(MomentOfDay.DAY, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList.add(new WeatherByLocation("city2", "c2", null, new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList.add(new WeatherByLocation("city3", "c3", null, new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList = MomentOfDay.assureDayTimeConsistency(weatherByLocationList);
        Assertions.assertTrue(weatherByLocationList.stream().allMatch(w -> w.getWeatherDescription().getMomentOfDay().equals(MomentOfDay.DAY)));
    }

    @Test
    void mixedBeforeAndNightAfterProcessing() {
        List<WeatherByLocation> weatherByLocationList = new ArrayList<>();
        weatherByLocationList.add(new WeatherByLocation("city1", "c1", null, new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList.add(new WeatherByLocation("city2", "c2", null, new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList.add(new WeatherByLocation("city3", "c3", null, new WeatherDescription(MomentOfDay.DAY, Intensity.NONE, Intensity.NONE, Intensity.NONE)));
        weatherByLocationList = MomentOfDay.assureDayTimeConsistency(weatherByLocationList);
        Assertions.assertTrue(weatherByLocationList.stream().allMatch(w -> w.getWeatherDescription().getMomentOfDay().equals(MomentOfDay.NIGHT)));
    }
}