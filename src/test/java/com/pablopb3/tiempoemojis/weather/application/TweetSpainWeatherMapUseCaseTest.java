package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.domain.service.MapService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsDownloadService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsSpainWeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsWeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service.TwitterApiClient;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service.TwitterApiClientTesting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class TweetSpainWeatherMapUseCaseTest {

    TweetSpainWeatherMapUseCase tweetSpainWeatherMapUseCase;

    @BeforeEach
    void setup() {
        RestTemplate restTemplate = new RestTemplate();
        ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService = new ElTiempoPuntoEsDownloadService(restTemplate);
        ElTiempoPuntoEsWeatherService elTiempoPuntoEsWeatherService = new ElTiempoPuntoEsWeatherService(elTiempoPuntoEsDownloadService);
        ElTiempoPuntoEsSpainWeatherService elTiempoPuntoEsSpainWeatherService = new ElTiempoPuntoEsSpainWeatherService(elTiempoPuntoEsWeatherService);
        TemplateReader templateReader = new TemplateReader();
        MapService mapService = new MapService();
        TwitterApiClient twitterApiClientTesting = new TwitterApiClientTesting();
        tweetSpainWeatherMapUseCase = new TweetSpainWeatherMapUseCase(templateReader, mapService, elTiempoPuntoEsSpainWeatherService, twitterApiClientTesting);
    }

    @Test
    void getWeather() throws Exception {
        tweetSpainWeatherMapUseCase.tweetWeather();
    }

}