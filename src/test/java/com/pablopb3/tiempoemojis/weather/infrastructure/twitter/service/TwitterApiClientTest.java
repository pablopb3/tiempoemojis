package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twitter4j.TwitterException;

class TwitterApiClientTest {

    private TwitterApiClient twitterApiClient;

    @BeforeEach
    void setup() {
        this.twitterApiClient = new TwitterApiClient();
    }

    @Test
    void tweet() throws TwitterException {
        //twitterApiClient.tweet("test from java again️");
    }

    @Test
    void tweetWithEmojis() throws TwitterException {
        //twitterApiClient.tweet(WeatherEmoji.getAllEmojiCodes());
    }

}