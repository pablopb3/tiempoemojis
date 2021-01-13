package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.domain.service.MapService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsDownloadService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsGaliciaWeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsMunicipalitiesService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsWeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service.TwitterApiClientGalicia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class TweetGaliciaWeatherMapUseCaseTest {

    TweetGaliciaWeatherMapUseCase tweetGaliciaWeatherMapUseCase;

    @BeforeEach
    void setup() {
        RestTemplate restTemplate = new RestTemplate();
        ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService = new ElTiempoPuntoEsDownloadService(restTemplate);
        ElTiempoPuntoEsMunicipalitiesService elTiempoPuntoEsMunicipalitiesService = new ElTiempoPuntoEsMunicipalitiesService(elTiempoPuntoEsDownloadService);
        ElTiempoPuntoEsWeatherService elTiempoPuntoEsWeatherService = new ElTiempoPuntoEsWeatherService(elTiempoPuntoEsDownloadService);
        TemplateReader templateReader = new TemplateReader();
        MapService mapService = new MapService();
        ElTiempoPuntoEsGaliciaWeatherService elTiempoPuntoEsGaliciaWeatherService = new ElTiempoPuntoEsGaliciaWeatherService(elTiempoPuntoEsMunicipalitiesService, elTiempoPuntoEsWeatherService, templateReader);
        TwitterApiClientGalicia twitterApiClientGalicia = new TwitterApiClientGalicia();
        tweetGaliciaWeatherMapUseCase = new TweetGaliciaWeatherMapUseCase(templateReader, mapService, elTiempoPuntoEsGaliciaWeatherService, twitterApiClientGalicia);
    }

    @Test
    void tweetWeather() throws Exception {
        tweetGaliciaWeatherMapUseCase.tweetWeather();
    }

}