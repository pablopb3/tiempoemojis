package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;

import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsMunicipality;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsMunicipalityWithWeather;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsCityWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElTiempoPuntoEsWeatherService {

    private static Logger log = LoggerFactory.getLogger(ElTiempoPuntoEsWeatherService.class);

    private ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService;

    public ElTiempoPuntoEsWeatherService(ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService) {
        this.elTiempoPuntoEsDownloadService = elTiempoPuntoEsDownloadService;
    }

    public List<ElTiempoPuntoEsCityWeather> getSpainWeather() {
        return elTiempoPuntoEsDownloadService.downloadSpainWeather();
    }

    public List<ElTiempoPuntoEsMunicipalityWithWeather> getGaliciaWeather(List<ElTiempoPuntoEsMunicipality> municipalitiesNeeded) {
        List<ElTiempoPuntoEsMunicipalityWithWeather> municipalitiesWithWeather = new ArrayList<>();
        municipalitiesNeeded.forEach(m -> {
            municipalitiesWithWeather.add(elTiempoPuntoEsDownloadService.downloadMunicipalityWeatherInfo(m.getProvinceCode(), m.getMunicipalityCode()));
        });
        return municipalitiesWithWeather;
    }

}
