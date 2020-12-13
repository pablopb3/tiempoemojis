package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.mapper;

import com.pablopb3.tiempoemojis.emoji.domain.service.mapper.WeatherEmojiMapper;
import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import com.pablopb3.tiempoemojis.weather.domain.model.MomentOfDay;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;
import com.pablopb3.tiempoemojis.emoji.domain.model.WeatherEmoji;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeatherEmojiMapperTest {

    @Test
    void emojiMapperSunnyDay() {
        WeatherDescription sunnyWeather = new WeatherDescription(MomentOfDay.DAY, Intensity.NONE, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmojiMapper.getEmojiFromDescription(sunnyWeather).equals(WeatherEmoji.SUN));
    }

    @Test
    void emojiMapperClearNight() {
        WeatherDescription clearNight = new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmojiMapper.getEmojiFromDescription(clearNight).equals(WeatherEmoji.MOON));
    }

    @Test
    void emojiMapperStormySky() {
        WeatherDescription stormySky = new WeatherDescription(MomentOfDay.NIGHT, Intensity.VERY_HIGH, Intensity.VERY_HIGH, Intensity.NONE);
        Assertions.assertTrue(WeatherEmojiMapper.getEmojiFromDescription(stormySky).equals(WeatherEmoji.STORMY_CLOUDS));
    }

    @Test
    void emojiMapperSnowyDay() {
        WeatherDescription stormySky = new WeatherDescription(MomentOfDay.DAY, Intensity.VERY_HIGH, Intensity.VERY_HIGH, Intensity.LOW);
        Assertions.assertTrue(WeatherEmojiMapper.getEmojiFromDescription(stormySky).equals(WeatherEmoji.SNOWY_CLOUD));
    }

    @Test
    void emojiMapperSunAndSmallClouds() {
        WeatherDescription stormySky = new WeatherDescription(MomentOfDay.DAY, Intensity.LOW, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmojiMapper.getEmojiFromDescription(stormySky).equals(WeatherEmoji.SUN_WITH_SMALL_CLOUD));
    }

    @Test
    void emojiMapperSunWithCloudsAndRain() {
        WeatherDescription stormySky = new WeatherDescription(MomentOfDay.DAY, Intensity.LOW, Intensity.LOW, Intensity.NONE);
        Assertions.assertTrue(WeatherEmojiMapper.getEmojiFromDescription(stormySky).equals(WeatherEmoji.SUN_WITH_BIG_CLOUD_AND_RAIN));
    }
}