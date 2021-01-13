package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.mapper;

import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import com.pablopb3.tiempoemojis.weather.domain.model.MomentOfDay;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;
import org.junit.jupiter.api.Test;

import static org.springframework.util.Assert.isTrue;

class ElTiempoPuntoEsMunicipalityMapperTest {

    @Test
    public void mapClearDay() {
        isTrue(
            ElTiempoPuntoEsMapper.getWeatherDescritpionForMunicipality("11")
                .equals(new WeatherDescription(MomentOfDay.DAY, Intensity.NONE, Intensity.NONE, Intensity.NONE))
        );
    }

    @Test
    public void mapVeryCloudyNight() {
        isTrue(
                ElTiempoPuntoEsMapper.getWeatherDescritpionForMunicipality("16n")
                        .equals(new WeatherDescription(MomentOfDay.NIGHT, Intensity.VERY_HIGH, Intensity.NONE, Intensity.NONE))
        );
    }

    @Test
    public void mapCloudyNightWithLittleRain() {
        isTrue(
                ElTiempoPuntoEsMapper.getWeatherDescritpionForMunicipality("45n")
                        .equals(new WeatherDescription(MomentOfDay.NIGHT, Intensity.HIGH, Intensity.LOW, Intensity.NONE))
        );
    }

    @Test
    public void mapStormyDay() {
        isTrue(
                ElTiempoPuntoEsMapper.getWeatherDescritpionForMunicipality("56")
                        .equals(new WeatherDescription(MomentOfDay.DAY, Intensity.VERY_HIGH, Intensity.VERY_HIGH, Intensity.NONE))
        );
    }

    @Test
    public void mapLittleSnowyButNotCoverDay() {
        isTrue(
                ElTiempoPuntoEsMapper.getWeatherDescritpionForMunicipality("43")
                        .equals(new WeatherDescription(MomentOfDay.DAY, Intensity.LOW, Intensity.LOW, Intensity.NONE))
        );
    }

    @Test
    public void mapStormyVeryCloudyLittleRainDay() {
        isTrue(
                ElTiempoPuntoEsMapper.getWeatherDescritpionForMunicipality("64")
                        .equals(new WeatherDescription(MomentOfDay.DAY, Intensity.MEDIUM, Intensity.HIGH, Intensity.NONE))
        );
    }

}