package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.model;

import com.pablopb3.tiempoemojis.emoji.domain.model.WeatherEmoji;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class WeatherEmojiTest {

    private static Logger log = LoggerFactory.getLogger(WeatherEmojiTest.class);

    @Test
    void logEmojisNumberOfCharacters() {
        for(WeatherEmoji emoji : WeatherEmoji.values()) {
            log.info(emoji.name()  + ": " + emoji.getEmojiCode().length());
        }
    }

}