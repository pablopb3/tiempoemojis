package com.pablopb3.tiempoemojis.emoji.domain.model;

public enum WeatherEmoji {

    //todo add test to check emojis lenght
    MOON("\uD83C\uDF15"),
    SUN("\u2600️"),
    SUN_WITH_SMALL_CLOUD("\uD83C\uDF24"),
    SUN_WITH_MEDIUM_CLOUD("\u26c5"),
    SUN_WITH_BIG_CLOUD("\uD83C\uDF25"),
    SUN_WITH_BIG_CLOUD_AND_RAIN("\uD83C\uDF26️"),
    GREY_CLOUDS("️☁"),
    RAINY_CLOUDS("\uD83C\uDF27"),
    STORMY_CLOUDS("\uD83C\uDF29️️"),
    RAINY_STORMY_CLOUDS("\u26c8"),
    SNOWY_CLOUD("\uD83C\uDF28"),
    QUESTION_MARK("❓");

    private String emojiCode;

    WeatherEmoji(String emojiCode) {
        this.emojiCode = emojiCode;
    }

    public String getEmojiCode() { return emojiCode; }

    public static String getAllEmojiCodes() {
        String emojiCodes = "";
        for (WeatherEmoji icon : values()) {
            emojiCodes += icon.emojiCode;
        }
        return emojiCodes;
    }


}
