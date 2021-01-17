package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.mapper;

import com.pablopb3.tiempoemojis.weather.domain.model.Coordinates;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherByLocation;
import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import com.pablopb3.tiempoemojis.weather.domain.model.MomentOfDay;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsCityWeather;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsIntensity;
import com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model.ElTiempoPuntoEsMunicipalityWithWeather;

public class ElTiempoPuntoEsMapper {

    public static WeatherByLocation map(ElTiempoPuntoEsCityWeather cityWeather) {
        return new WeatherByLocation(
                cityWeather.getName(),
                cityWeather.getUrl(),
                new Coordinates(cityWeather.getLatLng().get(0), cityWeather.getLatLng().get(1)),
                getWeatherDescritpionForCity(cityWeather.getStatus())
        );
    }

    public static WeatherByLocation map(ElTiempoPuntoEsMunicipalityWithWeather municipalityWeather) {
        return new WeatherByLocation(
                municipalityWeather.getMunicipio().getNOMBRE(),
                municipalityWeather.getMunicipio().getNOMBRE(),
                new Coordinates(municipalityWeather.getMunicipio().getLATITUDETRS89REGCAN95(), municipalityWeather.getMunicipio().getLONGITUDETRS89REGCAN95()),
                getWeatherDescritpionForMunicipality(municipalityWeather.getStateSky().getId())
        );
    }

    private static WeatherDescription getWeatherDescritpionForCity(String status) {
        char[] chars = status.toCharArray();
        MomentOfDay momentOfDay = chars[0] == 'd' ? MomentOfDay.DAY : MomentOfDay.NIGHT;
        Intensity cloudsIntensity = ElTiempoPuntoEsIntensity.getIntensityByLevel(Character.getNumericValue(chars[1]));
        Intensity rainIntensity = ElTiempoPuntoEsIntensity.getIntensityByLevel(Character.getNumericValue(chars[2]));
        Intensity snowIntensity = ElTiempoPuntoEsIntensity.getIntensityByLevel(Character.getNumericValue(chars[3]));
        return new WeatherDescription(momentOfDay, cloudsIntensity, rainIntensity, snowIntensity);
    }

    public static WeatherDescription getWeatherDescritpionForMunicipality(String status) {
        MomentOfDay momentOfDay = status.contains("n") ? MomentOfDay.NIGHT : MomentOfDay.DAY;
        char[] chars = status.toCharArray();
        if(chars[0] == '8') { chars = "16".toCharArray(); }
        Intensity cloudsIntensity = ElTiempoPuntoEsIntensity.getCloudsIntensityForMunicipality(Character.getNumericValue(chars[1]));
        Intensity rainIntensity = ElTiempoPuntoEsIntensity.getRainIntensityForMunicipality(Character.getNumericValue(chars[0]));
        Intensity snowIntensity = ElTiempoPuntoEsIntensity.getSnowIntensityForMunicipality(Character.getNumericValue(chars[0]));
        return new WeatherDescription(momentOfDay, cloudsIntensity, rainIntensity, snowIntensity);
    }






}
