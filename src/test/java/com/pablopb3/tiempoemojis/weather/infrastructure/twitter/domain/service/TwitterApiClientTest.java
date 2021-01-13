package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service;

import com.pablopb3.tiempoemojis.emoji.domain.model.WeatherEmoji;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twitter4j.TwitterException;

class TwitterApiClientTest {

    private TwitterApiClient twitterApiClient;

    @BeforeEach
    void setup() {
        this.twitterApiClient = new TwitterApiClientGalicia();
    }

    @Test
    void tweet() throws TwitterException {
        twitterApiClient.tweet(".                      ☁☁☁\n" +
                "                   ☁☁☁☁☁\n" +
                "       ☁☁☁☁☁☁☁☁\n" +
                " ☁☁☁☁☁☁☁☁☁☁\n" +
                "☁☁☁☁☁☁☁☁☁☁\n" +
                "   ☁☁☁☁☁☁☁☁☁☁\n" +
                "    ☁☁☁☁☁☁☁☁☁\n" +
                "        ☁☁☁☁☁☁☁☁☁\n" +
                "        ☁☁☁☁☁☁☁☁☁\n" +
                "      ☁☁☁☁☁☁☁☁☁\n" +
                "      ☁           ☁☁☁☁");
    }

    @Test
    void tweetWithEmojis() throws TwitterException {
        twitterApiClient.tweet(WeatherEmoji.getAllEmojiCodes());
    }

}