package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByCity;
import com.pablopb3.tiempoemojis.weather.domain.service.WeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.service.TwitterApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetWeatherMapUseCase {

    private Logger log = LoggerFactory.getLogger(TweetWeatherMapUseCase.class);

    private WeatherService weatherService;
    private TemplateReader templateReader;
    private TwitterApiClient twitterApiClient;

    public TweetWeatherMapUseCase(
            TemplateReader templateReader,
            @Qualifier("elTiempoPuntoEsWeatherService") WeatherService weatherService,
            TwitterApiClient twitterApiClient
    ) {
        this.templateReader = templateReader;
        this.weatherService = weatherService;
        this.twitterApiClient = twitterApiClient;
    }

    @Scheduled(cron = "0 0 3,7,11,15,19,23 * * ?")
    public void tweetWeather() throws Exception {

        List<WeatherByCity> weatherByCity = weatherService.getWeather();
        String citiesMap = templateReader.readTemplate();
        String weatherMap = weatherService.replaceCityCodeByWeatherEmoji(citiesMap, weatherByCity);
        log.info("let's tweet the weather map: \n" + weatherMap);
        twitterApiClient.tweet(weatherMap);
    }

}
