package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.domain.service.MapService;
import com.pablopb3.tiempoemojis.weather.domain.service.WeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service.TwitterApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TweetGaliciaWeatherMapUseCase extends TweetWeatherMapUseCase {

    private Logger log = LoggerFactory.getLogger(TweetGaliciaWeatherMapUseCase.class);

    public TweetGaliciaWeatherMapUseCase(
            TemplateReader templateReader,
            MapService mapService,
            @Qualifier("elTiempoPuntoEsGaliciaWeatherService") WeatherService weatherService,
            @Qualifier("twitterApiClientGalicia") TwitterApiClient twitterApiClient
    ) {
        super(templateReader, mapService, weatherService, twitterApiClient);
    }

    @Scheduled(cron = "0 3 2,6,10,14,18,22 * * ?")
    public void tweetWeather() throws Exception {
        super.tweetWeather();
    }
}
