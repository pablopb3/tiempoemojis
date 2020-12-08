package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Service
public class TwitterApiClient {

    private Logger log = LoggerFactory.getLogger(TwitterApiClient.class);

    private Twitter twitter;

    public TwitterApiClient() {
        twitter = TwitterFactory.getSingleton();
    }

    public void tweet(String message) throws TwitterException {
        twitter.updateStatus(message);
        log.info("Tweet successfully done with the following message: {}", message);
    }
}
