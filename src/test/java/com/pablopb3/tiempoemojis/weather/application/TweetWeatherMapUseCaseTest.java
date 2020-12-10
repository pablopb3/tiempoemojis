package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsDownloadService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsWeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.service.TwitterApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class TweetWeatherMapUseCaseTest {

    TweetWeatherMapUseCase tweetWeatherMapUseCase;

    @BeforeEach
    void setup() {
        RestTemplate restTemplate = new RestTemplate();
        ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService = new ElTiempoPuntoEsDownloadService(restTemplate);
        ElTiempoPuntoEsWeatherService elTiempoPuntoEsWeatherService = new ElTiempoPuntoEsWeatherService(elTiempoPuntoEsDownloadService);
        TemplateReader templateReader = new TemplateReader();
        TwitterApiClient twitterApiClient = new TwitterApiClient();
        tweetWeatherMapUseCase = new TweetWeatherMapUseCase(templateReader, elTiempoPuntoEsWeatherService, twitterApiClient);
    }

    @Test
    void getWeather() throws Exception {
        tweetWeatherMapUseCase.getWeather();
    }

}