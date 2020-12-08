package com.pablopb3.tiempoemojis.weather.domain.service;

import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByCity;

import java.util.List;

public interface WeatherService {

    List<WeatherByCity> getWeather();

}
