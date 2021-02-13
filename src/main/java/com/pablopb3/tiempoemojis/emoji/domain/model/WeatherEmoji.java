package com.pablopb3.tiempoemojis.emoji.domain.model;

import com.pablopb3.tiempoemojis.emoji.domain.service.LunarPhasesService;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;

public enum WeatherEmoji {

    SUN("\u2600️") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isSun(w);
        }
    },
    SUN_WITH_SMALL_CLOUD("\uD83C\uDF24") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isSunWithSmallCloud(w);
        }
    },
    SUN_WITH_MEDIUM_CLOUD("\u26c5") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isSunWithMediumCloud(w);
        }
    },
    SUN_WITH_BIG_CLOUD("\uD83C\uDF25") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isSunWithBigCloud(w);
        }
    },
    SUN_WITH_BIG_CLOUD_AND_RAIN("\uD83C\uDF26️") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isSunWithBigCloudAndRain(w);
        }
    },
    GREY_CLOUDS("\u2601") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isGreyClouds(w);
        }
    },
    RAINY_CLOUDS("\uD83C\uDF27") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isRainyCloud(w);
        }
    },
    //emojis occupies lots of chars STORMY_CLOUDS("\uD83C\uDF29") { public boolean isEmojiForWeather(WeatherDescription w) { return w.isStorming() && !w.isItRainy() && !w.isSnowing(); }},
    RAINY_STORMY_CLOUDS("\u26c8") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isStormCloud(w);
        }
    },
    SNOWY_CLOUD("\uD83C\uDF28") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isSnowCloud(w);
        }
    },

    NEW_MOON("\uD83C\uDF11", LunarPhase.NEW_MOON) { //LUNA NUEVA
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isThisMoon(w, this.getLunarPhase());
        }
    },
    WAXING_CRESCENT_MOON("\uD83C\uDF12", LunarPhase.WAXING_CRESCENT_MOON) { //CRECIENTE CASI NUEVA
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isThisMoon(w, this.getLunarPhase());
        }
    },
    FIRST_QUARTER_MOON("\uD83C\uDF13", LunarPhase.FIRST_QUARTER_MOON) { //CUARTO CRECIENTE
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isThisMoon(w, this.getLunarPhase());        }
    },
    WAXING_GIBBOUS_MOON("\uD83C\uDF14", LunarPhase.WAXING_GIBBOUS_MOON) { //CRECIENTE CASI LLENA
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isThisMoon(w, this.getLunarPhase());        }
    },
    FULL_MOON("\uD83C\uDF15", LunarPhase.FULL_MOON) { //LUNA LLENA
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isThisMoon(w, this.getLunarPhase());        }
    },
    WANING_GIBBOUS_MOUN("\uD83C\uDF16", LunarPhase.WANING_GIBBOUS_MOUN) { //MENGUANTE CASI LLENA
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isThisMoon(w, this.getLunarPhase());        }
    },
    LAST_QUARTER_MOON("\uD83C\uDF17", LunarPhase.LAST_QUARTER_MOON) { //CUARTO MENGUANTE
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isThisMoon(w, this.getLunarPhase());        }
    },
    WANING_CRESCENT_MOON("\uD83C\uDF18", LunarPhase.WANING_CRESCENT_MOON) { //MENGUANTE CASI NUEVA
        public boolean isEmojiForWeather(WeatherDescription w) {
            return weatherEmojiMapper.isThisMoon(w, this.getLunarPhase());        }
    },

    QUESTION_MARK("❓") {
        public boolean isEmojiForWeather(WeatherDescription w) {
            return false;
        }
    };


    private static WeatherEmojiMapper weatherEmojiMapper = new WeatherEmojiMapper(new LunarPhasesService());
    
    private String emojiCode;
    private LunarPhase lunarPhase;

    WeatherEmoji(String emojiCode) {
        this.emojiCode = emojiCode;
    }

    WeatherEmoji(String emojiCode, LunarPhase lunarPhase) {
        this.emojiCode = emojiCode;
        this.lunarPhase = lunarPhase;
    }

    public String getEmojiCode() { return emojiCode; }

    public LunarPhase getLunarPhase() { return lunarPhase; }

    public abstract boolean isEmojiForWeather(WeatherDescription weather);

    public static WeatherEmoji getEmojiForWeather(WeatherDescription weather, boolean includeLunarPhases) {
        for(WeatherEmoji emoji : values()) {
            if(emoji.isEmojiForWeather(weather)) {
                return getEmojiDependingOnLunarPhasesFlag(emoji, includeLunarPhases);
            }
        }
        return QUESTION_MARK;
    }

    public static WeatherEmoji getEmojiDependingOnLunarPhasesFlag(WeatherEmoji emoji, boolean includeLunarPhases) {
        if(!includeLunarPhases) {
            if(emoji.isMoonEmoji()) {
                return FULL_MOON;
            }
        }
        return emoji;
    }

    public boolean isMoonEmoji() {
        return lunarPhase != null;
    }

    public static String getAllEmojiCodes() {
        String emojiCodes = "";
        for (WeatherEmoji icon : values()) {
            emojiCodes += icon.emojiCode;
        }
        return emojiCodes;
    }


}
