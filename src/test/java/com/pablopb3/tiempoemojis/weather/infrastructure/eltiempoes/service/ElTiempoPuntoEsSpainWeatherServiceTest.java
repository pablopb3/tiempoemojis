package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

class ElTiempoPuntoEsSpainWeatherServiceTest {

    private static Logger log = Logger.getLogger(ElTiempoPuntoEsSpainWeatherServiceTest.class.getName());
    private ElTiempoPuntoEsSpainWeatherService elTiempoPuntoEsSpainWeatherService;

    @BeforeEach
    void setUp() {
        RestTemplate restTemplate = new RestTemplate();
        this.elTiempoPuntoEsSpainWeatherService = new ElTiempoPuntoEsSpainWeatherService(new ElTiempoPuntoEsWeatherService(new ElTiempoPuntoEsDownloadService(restTemplate)));
    }

    @Test
    public void downloadWeatherInfo() {
        log.info(elTiempoPuntoEsSpainWeatherService.getWeather().toString());
    }
}