package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.model;

import com.pablopb3.tiempoemojis.emoji.domain.model.LunarPhase;
import com.pablopb3.tiempoemojis.emoji.domain.model.WeatherEmoji;
import com.pablopb3.tiempoemojis.emoji.domain.service.LunarPhasesService;
import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import com.pablopb3.tiempoemojis.weather.domain.model.MomentOfDay;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeatherEmojiMapperLunarPhasesFlagTest {

    LunarPhasesService lunarPhasesService;

    @BeforeEach
    void setup() {
        this.lunarPhasesService = new LunarPhasesService();
    }

    @Test
    void clearNightWithoutLunarPhasesFlagReturnsFullMoon() {
        WeatherDescription clearNight = new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(clearNight, false).equals(WeatherEmoji.FULL_MOON));
    }

    @Test
    void clearNightWithLunarPhasesFlagReturnsCurrentPhaseMoon() {
        LunarPhase lunarPhase = lunarPhasesService.getCurrentMoonPhase();
        WeatherDescription clearNight = new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(clearNight, true).getLunarPhase().equals(lunarPhase));
    }


}