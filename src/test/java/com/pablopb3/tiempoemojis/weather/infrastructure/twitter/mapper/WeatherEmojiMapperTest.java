package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.mapper;

import com.pablopb3.tiempoemojis.emoji.domain.model.WeatherEmoji;
import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import com.pablopb3.tiempoemojis.weather.domain.model.MomentOfDay;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeatherEmojiMapperTest {

    @Test
    void emojiMapperSunnyDay() {
        WeatherDescription sunnyWeather = new WeatherDescription(MomentOfDay.DAY, Intensity.NONE, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(sunnyWeather).equals(WeatherEmoji.SUN));
    }

    @Test
    void emojiMapperClearNight() {
        WeatherDescription clearNight = new WeatherDescription(MomentOfDay.NIGHT, Intensity.NONE, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(clearNight).equals(WeatherEmoji.MOON));
    }

    @Test
    void emojiMapperRainyNight() {
        WeatherDescription rainyNight = new WeatherDescription(MomentOfDay.NIGHT, Intensity.LOW, Intensity.LOW, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(rainyNight).equals(WeatherEmoji.RAINY_CLOUDS));
    }

    @Test
    void emojiMapperStormySky() {
        WeatherDescription stormySky = new WeatherDescription(MomentOfDay.NIGHT, Intensity.VERY_HIGH, Intensity.VERY_HIGH, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(stormySky).equals(WeatherEmoji.RAINY_STORMY_CLOUDS));
    }

    @Test
    void emojiMapperSnowyDay() {
        WeatherDescription stormySky = new WeatherDescription(MomentOfDay.DAY, Intensity.VERY_HIGH, Intensity.VERY_HIGH, Intensity.LOW);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(stormySky).equals(WeatherEmoji.SNOWY_CLOUD));
    }

    @Test
    void emojiMapperSunAndSmallClouds() {
        WeatherDescription stormySky = new WeatherDescription(MomentOfDay.DAY, Intensity.LOW, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(stormySky).equals(WeatherEmoji.SUN_WITH_SMALL_CLOUD));
    }

    @Test
    void emojiMapperSunAndMediumClouds() {
        WeatherDescription stormySky = new WeatherDescription(MomentOfDay.DAY, Intensity.MEDIUM, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(stormySky).equals(WeatherEmoji.SUN_WITH_MEDIUM_CLOUD));
    }

    @Test
    void emojiMapperSunAndBigClouds() {
        WeatherDescription stormySky = new WeatherDescription(MomentOfDay.DAY, Intensity.HIGH, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(stormySky).equals(WeatherEmoji.SUN_WITH_BIG_CLOUD));
    }

    @Test
    void emojiMapperGreyClouds() {
        WeatherDescription veryCloudyDaySky = new WeatherDescription(MomentOfDay.DAY, Intensity.VERY_HIGH, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(veryCloudyDaySky).equals(WeatherEmoji.GREY_CLOUDS));
        WeatherDescription cloudyNightSky = new WeatherDescription(MomentOfDay.NIGHT, Intensity.MEDIUM, Intensity.NONE, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(cloudyNightSky).equals(WeatherEmoji.GREY_CLOUDS));
    }

    @Test
    void emojiMapperSunWithCloudsAndRain() {
        WeatherDescription stormySky = new WeatherDescription(MomentOfDay.DAY, Intensity.LOW, Intensity.LOW, Intensity.NONE);
        Assertions.assertTrue(WeatherEmoji.getEmojiForWeather(stormySky).equals(WeatherEmoji.SUN_WITH_BIG_CLOUD_AND_RAIN));
    }

}