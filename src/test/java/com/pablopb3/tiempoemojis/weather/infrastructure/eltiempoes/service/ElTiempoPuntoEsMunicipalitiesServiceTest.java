package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

class ElTiempoPuntoEsMunicipalitiesServiceTest {

    private static Logger log = Logger.getLogger(ElTiempoPuntoEsMunicipalitiesServiceTest.class.getName());

    ElTiempoPuntoEsMunicipalitiesService elTiempoPuntoEsMunicipalitiesService;

    @BeforeEach
    void setUp() {
        RestTemplate restTemplate = new RestTemplate();
        this.elTiempoPuntoEsMunicipalitiesService = new ElTiempoPuntoEsMunicipalitiesService(new ElTiempoPuntoEsDownloadService(restTemplate));
    }

    @Test
    public void getAllMunicipalitiesInACoruna() {
        Integer A_CORUNA_PROVINCE_CODE = 15;
        log.info(elTiempoPuntoEsMunicipalitiesService.getMunicipalitiesForProvince(A_CORUNA_PROVINCE_CODE).toString());
    }
}