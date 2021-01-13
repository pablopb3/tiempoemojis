package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service;

import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.model.TwitterApiCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterApiClient {

    private Logger log = LoggerFactory.getLogger(TwitterApiClient.class);

    private Twitter twitter;

    public TwitterApiClient() {}

    public void init(TwitterApiCredentials credentials) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(credentials.getConsumerKey())
                .setOAuthConsumerSecret(credentials.getConsumerSecret())
                .setOAuthAccessToken(credentials.getAccessToken())
                .setOAuthAccessTokenSecret(credentials.getAccessTokenSecret())
                .setTweetModeExtended(true);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public void tweet(String message) throws TwitterException {
        twitter.updateStatus(message);
        log.info("Tweet successfully done with the following message: {}", message);
    }
}
