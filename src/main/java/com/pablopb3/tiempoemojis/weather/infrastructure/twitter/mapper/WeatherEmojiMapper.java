package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.mapper;

import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;
import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.model.WeatherEmoji;
import org.springframework.stereotype.Service;

import static com.pablopb3.tiempoemojis.weather.infrastructure.twitter.model.WeatherEmoji.*;

public class WeatherEmojiMapper {

    public static WeatherEmoji getEmojiFromDescription(WeatherDescription weather) {

        if (weather.isSkyClear()) {
            if (weather.isItDay()) { return SUN; } else { return MOON; }
        }
        if (weather.isSnowing()) { return SNOWY_CLOUD; }
        if (weather.isStorming()) {
            if (weather.isItRainy()) { return RAINY_STORMY_CLOUDS; } else { return STORMY_CLOUDS; }
        }
        if (weather.isItRainy()) {
            if (Intensity.LOW.equals(weather.getCloudsLevel())) { return SUN_WITH_BIG_CLOUD_AND_RAIN; }
            if (Intensity.MEDIUM.equals(weather.getCloudsLevel()) || Intensity.HIGH.equals(weather.getCloudsLevel())) { return RAINY_CLOUDS; }

            return RAINY_CLOUDS;
        }
        if (weather.isItCloudy()) {
            if (Intensity.LOW.equals(weather.getCloudsLevel())) { return SUN_WITH_SMALL_CLOUD; }
            if (Intensity.MEDIUM.equals(weather.getCloudsLevel())) { return SUN_WITH_MEDIUM_CLOUD; }
            if (Intensity.HIGH.equals(weather.getCloudsLevel())) { return SUN_WITH_BIG_CLOUD; }
            if (Intensity.VERY_HIGH.equals(weather.getCloudsLevel())) { return GREY_CLOUDS; }
        }
        return QUESTION_MARK;
    }
}
