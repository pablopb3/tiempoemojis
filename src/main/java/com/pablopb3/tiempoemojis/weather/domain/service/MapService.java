package com.pablopb3.tiempoemojis.weather.domain.service;

import com.pablopb3.tiempoemojis.emoji.domain.service.mapper.WeatherEmojiMapper;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByLocation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class MapService {

    public String replaceLocationsCodeByWeatherEmoji(String map, List<WeatherByLocation> weatherByLocation, String locationsSeparator) {
        var replacedMap = new Object() { String value = map; };
        weatherByLocation.forEach(c -> {
            if (map.contains(c.getLocationCode().toLowerCase(Locale.ROOT))) {
                replacedMap.value = replacedMap.value.replace(locationsSeparator + c.getLocationCode().toLowerCase(Locale.ROOT), WeatherEmojiMapper.getEmojiFromDescription(c.getWeatherDescription()).getEmojiCode());
            }
        });
        return replacedMap.value;
    }
}
