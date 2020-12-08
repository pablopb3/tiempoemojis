package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByCity;
import com.pablopb3.tiempoemojis.weather.domain.service.WeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.mapper.WeatherEmojiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetWeatherUseCase {

    private Logger log = LoggerFactory.getLogger(GetWeatherUseCase.class);

    private WeatherService weatherService;

    public GetWeatherUseCase(@Qualifier("elTiempoPuntoEsWeatherService") WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void getWeather() {

        List<WeatherByCity> weatherByCity = weatherService.getWeather();
        weatherByCity.stream().forEach(c -> {
            log.info("CITY: {}", c.getName());
            log.info("coordinates: {}", c.getCoordinates());
            log.info("weather description: {}", c.getWeatherDescription());
            log.info("emoji: {}", WeatherEmojiMapper.getEmojiFromDescription(c.getWeatherDescription()));
            log.info("\n");
        });
    }
}
