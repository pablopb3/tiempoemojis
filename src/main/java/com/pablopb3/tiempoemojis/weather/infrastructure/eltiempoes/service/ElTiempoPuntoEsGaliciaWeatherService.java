package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;

import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByLocation;
import com.pablopb3.tiempoemojis.weather.domain.service.WeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.mapper.ElTiempoPuntoEsMapper;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsMunicipality;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsMunicipalityWithWeather;
import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ElTiempoPuntoEsGaliciaWeatherService implements WeatherService {

    private static Logger log = LoggerFactory.getLogger(ElTiempoPuntoEsGaliciaWeatherService.class);

    private final static List<Integer> GALICIA_PROVINCES_CODES = Arrays.asList(15,27,32,36);

    private ElTiempoPuntoEsMunicipalitiesService elTiempoPuntoEsMunicipalitiesService;
    private ElTiempoPuntoEsWeatherService elTiempoPuntoEsWeatherService;
    private TemplateReader templateReader;

    public ElTiempoPuntoEsGaliciaWeatherService(
            ElTiempoPuntoEsMunicipalitiesService elTiempoPuntoEsMunicipalitiesService,
            ElTiempoPuntoEsWeatherService elTiempoPuntoEsWeatherService,
            TemplateReader templateReader
    ) {
        this.elTiempoPuntoEsMunicipalitiesService = elTiempoPuntoEsMunicipalitiesService;
        this.elTiempoPuntoEsWeatherService = elTiempoPuntoEsWeatherService;
        this.templateReader = templateReader;
    }

    public List<WeatherByLocation> getWeather() {
        List<ElTiempoPuntoEsMunicipality> galicianMunicipalitiesRetrieved = getGalicianMunicipalitiesNeeded();
        List<ElTiempoPuntoEsMunicipalityWithWeather> galicianMunicipalitiesWithWeather = elTiempoPuntoEsWeatherService.getGaliciaWeather(galicianMunicipalitiesRetrieved);
        return galicianMunicipalitiesWithWeather.stream().map(e -> ElTiempoPuntoEsMapper.map(e)).collect(Collectors.toList());
    }

    public List<ElTiempoPuntoEsMunicipality> getGalicianMunicipalitiesNeeded() {
        List<String> galicianMunicipalitiesInOurMap = getAllGalicianMunicipalitiesInOurMap();
        List<ElTiempoPuntoEsMunicipality> allGalicianMunicipalities = getAllGalicianMunicipalities();
        List<ElTiempoPuntoEsMunicipality> galicianMunicipalitiesNeeded = allGalicianMunicipalities.stream().filter(m -> galicianMunicipalitiesInOurMap.contains(m.getNOMBRE().toLowerCase(Locale.ROOT))).collect(Collectors.toList());
        return galicianMunicipalitiesNeeded;
    }

    public List<String> getAllGalicianMunicipalitiesInOurMap() {
        return templateReader.getAllGalicianMunicipalities();
    }


    private List<ElTiempoPuntoEsMunicipality> getAllGalicianMunicipalities() {
        List<ElTiempoPuntoEsMunicipality> galicianMunicipalities = new ArrayList<>();
        GALICIA_PROVINCES_CODES.forEach(code -> {
            galicianMunicipalities.addAll(elTiempoPuntoEsMunicipalitiesService.getMunicipalitiesForProvince(code));
        });
        return galicianMunicipalities;
    }

}
