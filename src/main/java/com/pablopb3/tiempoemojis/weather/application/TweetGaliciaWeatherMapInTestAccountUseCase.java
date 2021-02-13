package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByLocation;
import com.pablopb3.tiempoemojis.weather.domain.service.MapService;
import com.pablopb3.tiempoemojis.weather.domain.service.WeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service.TwitterApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetGaliciaWeatherMapInTestAccountUseCase extends TweetWeatherMapUseCase {

    private Logger log = LoggerFactory.getLogger(TweetGaliciaWeatherMapInTestAccountUseCase.class);

    public TweetGaliciaWeatherMapInTestAccountUseCase(
            TemplateReader templateReader,
            MapService mapService,
            @Qualifier("elTiempoPuntoEsGaliciaWeatherService") WeatherService weatherService,
            @Qualifier("twitterApiClientTesting") TwitterApiClient twitterApiClient
    ) {
        super(templateReader, mapService, weatherService, twitterApiClient);
    }

    @Scheduled(cron = "0 3 2,6,10,14,18,22 * * ?")
    public void tweetWeather() throws Exception {

        List<WeatherByLocation> weatherByLocation = weatherService.getWeather();
        String citiesMap = templateReader.readGaliciaTemplate();
        String weatherMap = mapService.replaceLocationsCodeByWeatherEmoji(citiesMap, weatherByLocation, ";", true);
        log.info("let's tweet the weather map for Galicia: \n" + weatherMap);
        twitterApiClient.tweet(weatherMap);
    }
}
