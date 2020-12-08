package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;

import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ElTiempoPuntoEsDownloadService {

    private static String elTiempoPuntoEsUrl = "https://www.eltiempo.es/ajax-maps-v2?principal=es&navigator=desktop&day=&hour=";

    private RestTemplate restTemplate;

    public ElTiempoPuntoEsDownloadService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ElTiempoPuntoEsEntity> download() {
        return Arrays.asList(restTemplate.getForEntity(elTiempoPuntoEsUrl, ElTiempoPuntoEsEntity[].class).getBody());
    }

}
