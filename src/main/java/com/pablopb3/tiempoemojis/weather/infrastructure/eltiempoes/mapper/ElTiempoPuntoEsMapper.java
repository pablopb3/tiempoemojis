package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.mapper;

import com.pablopb3.tiempoemojis.weather.domain.model.Coordinates;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByCity;
import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import com.pablopb3.tiempoemojis.weather.domain.model.MomentOfDay;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsEntity;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsIntensity;

public class ElTiempoPuntoEsMapper {

    public static WeatherByCity map(ElTiempoPuntoEsEntity elTiempo) {
        return new WeatherByCity(
                elTiempo.getName(),
                new Coordinates(elTiempo.getLatLng().get(0), elTiempo.getLatLng().get(1)),
                getWeatherDescritpion(elTiempo.getStatus())
        );
    }

    private static WeatherDescription getWeatherDescritpion(String status) {
        char[] chars = status.toCharArray();
        MomentOfDay momentOfDay = chars[0] == 'd' ? MomentOfDay.DAY : MomentOfDay.NIGHT;
        Intensity cloudsIntensity = ElTiempoPuntoEsIntensity.getIntensityByLevel(chars[1]);
        Intensity rainIntensity = ElTiempoPuntoEsIntensity.getIntensityByLevel(chars[2]);
        Intensity snowIntensity = ElTiempoPuntoEsIntensity.getIntensityByLevel(chars[3]);
        return new WeatherDescription(momentOfDay, cloudsIntensity, rainIntensity, snowIntensity);
    }



}
