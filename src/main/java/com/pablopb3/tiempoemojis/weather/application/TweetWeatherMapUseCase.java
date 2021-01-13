package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByLocation;
import com.pablopb3.tiempoemojis.weather.domain.service.MapService;
import com.pablopb3.tiempoemojis.weather.domain.service.WeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service.TwitterApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class TweetWeatherMapUseCase {

    private Logger log = LoggerFactory.getLogger(TweetWeatherMapUseCase.class);

    private WeatherService weatherService;
    private TemplateReader templateReader;
    private MapService mapService;
    private TwitterApiClient twitterApiClient;

    public TweetWeatherMapUseCase(
            TemplateReader templateReader,
            MapService mapService,
            WeatherService weatherService,
            TwitterApiClient twitterApiClient
    ) {
        this.templateReader = templateReader;
        this.mapService = mapService;
        this.weatherService = weatherService;
        this.twitterApiClient = twitterApiClient;
    }

    public void tweetWeather() throws Exception {

        List<WeatherByLocation> weatherByLocation = weatherService.getWeather();
        String citiesMap = templateReader.readSpainTemplate();
        String weatherMap = mapService.replaceLocationsCodeByWeatherEmoji(citiesMap, weatherByLocation, " ");
        log.info("let's tweet the weather map for Spain: \n" + weatherMap);
        twitterApiClient.tweet(weatherMap);
    }

}
