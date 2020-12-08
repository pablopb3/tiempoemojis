package com.pablopb3.tiempoemojis.weather.application;

import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsDownloadService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service.ElTiempoPuntoEsWeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class GetWeatherUseCaseTest {

    GetWeatherUseCase getWeatherUseCase;

    @BeforeEach
    void setup() {
        RestTemplate restTemplate = new RestTemplate();
        ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService = new ElTiempoPuntoEsDownloadService(restTemplate);
        ElTiempoPuntoEsWeatherService elTiempoPuntoEsWeatherService = new ElTiempoPuntoEsWeatherService(elTiempoPuntoEsDownloadService);
        getWeatherUseCase = new GetWeatherUseCase(elTiempoPuntoEsWeatherService);
    }

    @Test
    void getWeather() {
        getWeatherUseCase.getWeather();
    }

}