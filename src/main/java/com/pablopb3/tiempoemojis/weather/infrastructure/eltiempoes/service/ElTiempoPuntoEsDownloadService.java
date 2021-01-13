package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;

import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsMunicipalitiesForProvinceResponse;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsMunicipality;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsMunicipalityWithWeather;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsCityWeather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ElTiempoPuntoEsDownloadService {

    private static String elTiempoPuntoEsSpainMainCitiesUrl = "https://www.eltiempo.es/ajax-maps-v2?principal=es&navigator=desktop&day=&hour=";
    private static String elTiempoPuntoEsMunicpalitiesForProvinceUrl = "https://www.el-tiempo.net/api/json/v2/provincias/{PROVINCE_CODE}/municipios";
    private static String elTiempoPuntoEsMunicpalityUrl = "https://www.el-tiempo.net/api/json/v2/provincias/{PROVINCE_CODE}/municipios/{MUNICIPALITY_CODE}";

    private RestTemplate restTemplate;

    public ElTiempoPuntoEsDownloadService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ElTiempoPuntoEsCityWeather> downloadSpainWeather() {
        return Arrays.asList(restTemplate.getForEntity(elTiempoPuntoEsSpainMainCitiesUrl, ElTiempoPuntoEsCityWeather[].class).getBody());
    }

    public List<ElTiempoPuntoEsMunicipality> downloadMunicipalitiesForProvince(Integer provinceCode) {
        return restTemplate.getForEntity(elTiempoPuntoEsMunicpalitiesForProvinceUrl
                .replace("{PROVINCE_CODE}", provinceCode.toString()
            ), ElTiempoPuntoEsMunicipalitiesForProvinceResponse.class).getBody().getMunicipios();
    }

    public ElTiempoPuntoEsMunicipalityWithWeather downloadMunicipalityWeatherInfo(Integer provinceCode, Integer municipalityCode) {
        return restTemplate.getForEntity(elTiempoPuntoEsMunicpalityUrl
                .replace("{PROVINCE_CODE}", provinceCode.toString())
                .replace("{MUNICIPALITY_CODE}", municipalityCode.toString()),
            ElTiempoPuntoEsMunicipalityWithWeather.class).getBody();
    }




}
