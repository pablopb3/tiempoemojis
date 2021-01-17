package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.domain.service.MapService;
import com.pablopb3.tiempoemojis.weather.domain.service.WeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service.TwitterApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TweetWeatherMapUseCase {

    private Logger log = LoggerFactory.getLogger(TweetWeatherMapUseCase.class);

    protected WeatherService weatherService;
    protected TemplateReader templateReader;
    protected MapService mapService;
    protected TwitterApiClient twitterApiClient;

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

}
