package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

class ElTiempoPuntoEsWeatherServiceTest {

    private static Logger log = Logger.getLogger(ElTiempoPuntoEsWeatherServiceTest.class.getName());
    private ElTiempoPuntoEsWeatherService elTiempoPuntoEsWeatherService;

    @BeforeEach
    void setUp() {
        RestTemplate restTemplate = new RestTemplate();
        this.elTiempoPuntoEsWeatherService = new ElTiempoPuntoEsWeatherService(
                new ElTiempoPuntoEsDownloadService(restTemplate)
        );
    }

    @Test
    public void downloadWeatherInfo() {
        log.info(elTiempoPuntoEsWeatherService.getWeather().toString());
    }
}