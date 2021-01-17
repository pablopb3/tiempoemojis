package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service;

import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.model.TwitterApiCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TwitterApiClientTesting extends TwitterApiClient {

    private Logger log = LoggerFactory.getLogger(TwitterApiClientTesting.class);

    private final static TwitterApiCredentials credentials = new TwitterApiCredentials(
            "B8wegOpIVT44iuswWetvz3Bcb",
            "Niz0wQGZJs2NGqPIuXvXLxid0FZeypthNAnEBFIwQYISHAfngg",
            "1350784471646220290-97YOTBUIuWBuQGWLT07YaqugO2y8gN",
            "YL3FPJZNIhLm1CLstuF7TDZk9EaWEdQFc4w5r8uxBoY3S"
    );

    public TwitterApiClientTesting() {
        super();
        init(credentials);
    }

}
