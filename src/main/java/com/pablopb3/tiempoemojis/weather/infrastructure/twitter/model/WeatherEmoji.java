package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.model;

import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import com.pablopb3.tiempoemojis.weather.domain.model.MomentOfDay;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;

public enum WeatherEmoji {

    MOON("\uD83C\uDF19"),
    SUN("☀️"),
    SUN_WITH_SMALL_CLOUD("\uD83C\uDF24"),
    SUN_WITH_MEDIUM_CLOUD("⛅️"),
    SUN_WITH_BIG_CLOUD("\uD83C\uDF25"),
    SUN_WITH_BIG_CLOUD_AND_RAIN("️️️\uD83C\uDF26"),
    GREY_CLOUDS("️☁️️"),
    RAINY_CLOUDS("\uD83C\uDF27"),
    STORMY_CLOUDS("️\uD83C\uDF29️"),
    RAINY_STORMY_CLOUDS("⛈"),
    SNOWY_CLOUD("\uD83C\uDF28"),
    QUESTION_MARK("❓");

    private String emojiCode;

    WeatherEmoji(String emojiCode) {
        this.emojiCode = emojiCode;
    }

    public static String getAllEmojiCodes() {
        String emojiCodes = "";
        for (WeatherEmoji icon : values()) {
            emojiCodes += icon.emojiCode;
        }
        return emojiCodes;
    }


}
