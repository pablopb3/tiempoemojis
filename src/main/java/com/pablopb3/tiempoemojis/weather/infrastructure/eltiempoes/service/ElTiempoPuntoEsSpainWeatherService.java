package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;

import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByLocation;
import com.pablopb3.tiempoemojis.weather.domain.service.WeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.mapper.ElTiempoPuntoEsMapper;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsCityWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElTiempoPuntoEsSpainWeatherService implements WeatherService {

    private static Logger log = LoggerFactory.getLogger(ElTiempoPuntoEsSpainWeatherService.class);

    private ElTiempoPuntoEsWeatherService elTiempoPuntoEsWeatherService;

    public ElTiempoPuntoEsSpainWeatherService(ElTiempoPuntoEsWeatherService elTiempoPuntoEsWeatherService) {
        this.elTiempoPuntoEsWeatherService = elTiempoPuntoEsWeatherService;
    }

    public List<WeatherByLocation> getWeather() {
        List<ElTiempoPuntoEsCityWeather> elTiempoWeather = elTiempoPuntoEsWeatherService.getSpainWeather();
        return elTiempoWeather.stream().map(e -> ElTiempoPuntoEsMapper.map(e)).collect(Collectors.toList());
    }

}
