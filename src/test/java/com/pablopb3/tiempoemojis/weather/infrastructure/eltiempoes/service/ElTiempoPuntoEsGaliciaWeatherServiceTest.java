package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;


import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.stream.Collectors;

class ElTiempoPuntoEsGaliciaWeatherServiceTest {

    private static Logger log = Logger.getLogger(ElTiempoPuntoEsGaliciaWeatherServiceTest.class.getName());
    private ElTiempoPuntoEsGaliciaWeatherService elTiempoPuntoEsGaliciaWeatherService;

    @BeforeEach
    void setUp() {
        RestTemplate restTemplate = new RestTemplate();
        ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService = new ElTiempoPuntoEsDownloadService(restTemplate);
        this.elTiempoPuntoEsGaliciaWeatherService = new ElTiempoPuntoEsGaliciaWeatherService(
                new ElTiempoPuntoEsMunicipalitiesService(elTiempoPuntoEsDownloadService),
                new ElTiempoPuntoEsWeatherService(elTiempoPuntoEsDownloadService),
                new TemplateReader()
        );
    }

    @Test
    public void downloadWeatherInfo() {
        log.info(elTiempoPuntoEsGaliciaWeatherService.getWeather().toString());
    }

    @Test
    public void isThereAnyMunicipalityMissing() {
        List<String> municipalitiesNeeded = elTiempoPuntoEsGaliciaWeatherService.getAllGalicianMunicipalitiesInOurMap();
        List<String> municipalitiesRetrieved = elTiempoPuntoEsGaliciaWeatherService.getGalicianMunicipalitiesNeeded().stream().map(m -> m.getNOMBRE().toLowerCase(Locale.ROOT)).collect(Collectors.toList());
        List<String> municipalitiesMissing = municipalitiesNeeded.stream().filter(m -> !municipalitiesRetrieved.contains(m)).collect(Collectors.toList());
        log.info(municipalitiesMissing.size() + " municipalities missing : " + municipalitiesMissing.toString());
        Assert.isTrue(municipalitiesMissing.size() == 0);
    }

}