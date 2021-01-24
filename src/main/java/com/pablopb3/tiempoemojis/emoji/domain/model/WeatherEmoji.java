package com.pablopb3.tiempoemojis.emoji.domain.model;

import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;

public enum WeatherEmoji {

    //todo add test to check emojis lenght
    MOON("\uD83C\uDF15") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return w.isItNight() && !w.isTherePrecipitations() && w.getCloudsLevel().isNoneOrLow();
        }
    },
    SUN("\u2600️") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return w.isItDay() && !w.isTherePrecipitations() && w.isSkyClear();
        }
    },
    SUN_WITH_SMALL_CLOUD("\uD83C\uDF24") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return w.isItDay() && !w.isTherePrecipitations() && w.getCloudsLevel().isLow();
        }
    },
    SUN_WITH_MEDIUM_CLOUD("\u26c5") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return w.isItDay() && !w.isTherePrecipitations() && w.getCloudsLevel().isMedium();
        }
    },
    SUN_WITH_BIG_CLOUD("\uD83C\uDF25") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return w.isItDay() && !w.isTherePrecipitations() && w.getCloudsLevel().isHigh();
        }
    },
    SUN_WITH_BIG_CLOUD_AND_RAIN("\uD83C\uDF26️") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return w.isItDay() && w.isItRainy() && w.getCloudsLevel().isLow() && !w.isStorming() && !w.isSnowing();
        }
    },
    GREY_CLOUDS("\u2601") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return !w.isTherePrecipitations() && (
                        (w.isItNight() && w.getCloudsLevel().isMediumOrHigher()) ||
                        (w.isItDay() && w.getCloudsLevel().isVeryHigh())
            );
        }
    },
    RAINY_CLOUDS("\uD83C\uDF27") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return w.isItRainy() && !SUN_WITH_BIG_CLOUD_AND_RAIN.isEmojiForWeather(w) &&
                    !w.isStorming() && !w.isSnowing();
        }
    },
    //emojis occupies lots of chars STORMY_CLOUDS("\uD83C\uDF29") { public boolean isEmojiForWeather(WeatherDescription w) { return w.isStorming() && !w.isItRainy() && !w.isSnowing(); }},
    RAINY_STORMY_CLOUDS("\u26c8") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return w.isStorming() && !w.isSnowing();
        }
    },
    SNOWY_CLOUD("\uD83C\uDF28") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return w.isSnowing();
        }
    },
    QUESTION_MARK("❓") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return false;
        }
    };

    private String emojiCode;

    WeatherEmoji(String emojiCode) {
        this.emojiCode = emojiCode;
    }

    public String getEmojiCode() { return emojiCode; }

    public abstract boolean isEmojiForWeather(WeatherDescription weather);

    public static WeatherEmoji getEmojiForWeather(WeatherDescription weather) {
        for(WeatherEmoji emoji : values()) {
            if(emoji.isEmojiForWeather(weather)) {
                return emoji;
            }
        }
        return QUESTION_MARK;
    }

    public static String getAllEmojiCodes() {
        String emojiCodes = "";
        for (WeatherEmoji icon : values()) {
            emojiCodes += icon.emojiCode;
        }
        return emojiCodes;
    }


}
