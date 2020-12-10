package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.service;

import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByCity;
import com.pablopb3.tiempoemojis.weather.domain.service.WeatherService;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.mapper.ElTiempoPuntoEsMapper;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsEntity;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.model.WeatherEmoji;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElTiempoPuntoEsWeatherService implements WeatherService {

    private static Logger log = LoggerFactory.getLogger(ElTiempoPuntoEsWeatherService.class);

    private ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService;

    public ElTiempoPuntoEsWeatherService(ElTiempoPuntoEsDownloadService elTiempoPuntoEsDownloadService) {
        this.elTiempoPuntoEsDownloadService = elTiempoPuntoEsDownloadService;
    }

    public List<WeatherByCity> getWeather() {
        List<ElTiempoPuntoEsEntity> elTiempoWeather = elTiempoPuntoEsDownloadService.download();
        return elTiempoWeather
                .stream()
                .map(e -> ElTiempoPuntoEsMapper.map(e))
                .collect(Collectors.toList());
    }

    @Override
    public String replaceCityCodeByWeatherEmoji(String map, List<WeatherByCity> weatherByCity) {


        var replacedMap = new Object(){ String value = map; };
        weatherByCity.forEach(c -> {
            if (map.contains(c.getCityCode())) {
                //replacedMap.value = replacedMap.value.replace("$" + c.getCityCode(), WeatherEmojiMapper.getEmojiFromDescription(c.getWeatherDescription()).getEmojiCode());
                replacedMap.value = replacedMap.value.replace("$" + c.getCityCode(), WeatherEmoji.STORMY_CLOUDS.getEmojiCode());
            }
        });
        replacedMap.value = replacedMap.value.replace("$", " ");
        return replacedMap.value;
    }
}
