package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByCity;
import com.pablopb3.tiempoemojis.weather.domain.service.WeatherService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetWeatherUseCase {

    private WeatherService weatherService;

    public GetWeatherUseCase(@Qualifier("elTiempoPuntoEsWeatherService") WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public List<WeatherByCity> getWeather() {
        return weatherService.getWeather();
    }
}
