package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class TwitterApiClient {

    private Logger log = LoggerFactory.getLogger(TwitterApiClient.class);

    private Twitter twitter;

    public TwitterApiClient() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey("xkxrd2CLXZDWtybNWPSUtMZBk")
            .setOAuthConsumerSecret("t41RDLTPjtNWgb8YMLuyWsxk0E6lVXZgTSCjYOAODTEWVHIHHQ")
            .setOAuthAccessToken("1336331662569820162-z3Du6EZMAPsNMl4d4mF0cU0AihjIZV")
            .setOAuthAccessTokenSecret("4nr9IkNaT3k5OvQKdwcTalb9RTNNXtEckYvD4iSPj4Uc4")
            .setTweetModeExtended(true)
        ;
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public void tweet(String message) throws TwitterException {
        twitter.updateStatus(message);
        log.info("Tweet successfully done with the following message: {}", message);
    }
}
