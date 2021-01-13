package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.mapper;

import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import com.pablopb3.tiempoemojis.weather.domain.model.MomentOfDay;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsCityWeather;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ElTiempoPuntoEsCityMapperTest {

    @Test
    public void mapperTest() {
        ElTiempoPuntoEsCityWeather tiempo = new ElTiempoPuntoEsCityWeather(Arrays.asList(0.0,0.0), "city", "d100");
        assertTrue(
                ElTiempoPuntoEsMapper.map(tiempo).getWeatherDescription()
                .equals(new WeatherDescription(MomentOfDay.DAY, Intensity.LOW, Intensity.NONE, Intensity.NONE))
        );
    }

}