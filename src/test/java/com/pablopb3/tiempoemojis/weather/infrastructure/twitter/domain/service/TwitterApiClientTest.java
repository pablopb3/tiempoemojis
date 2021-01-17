package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service;

import com.pablopb3.tiempoemojis.emoji.domain.model.WeatherEmoji;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.TwitterException;

class TwitterApiClientTest {

    private Logger log = LoggerFactory.getLogger(TwitterApiClientTesting.class);

    private TwitterApiClient twitterApiClient;

    @BeforeEach
    void setup() {
        this.twitterApiClient = new TwitterApiClientTesting();
    }

    @Test
    void tweetWithEmojis() throws TwitterException {
        String tweet = WeatherEmoji.getAllEmojiCodes();
        log.info(tweet);
        twitterApiClient.tweet(tweet);
    }

}