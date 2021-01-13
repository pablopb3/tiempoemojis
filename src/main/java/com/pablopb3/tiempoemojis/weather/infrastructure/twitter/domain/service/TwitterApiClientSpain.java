package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service;

import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.model.TwitterApiCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TwitterApiClientSpain extends TwitterApiClient {

    private Logger log = LoggerFactory.getLogger(TwitterApiClientSpain.class);

    private final static TwitterApiCredentials credentials = new TwitterApiCredentials(
        "xkxrd2CLXZDWtybNWPSUtMZBk",
                "t41RDLTPjtNWgb8YMLuyWsxk0E6lVXZgTSCjYOAODTEWVHIHHQ",
                "1336331662569820162-z3Du6EZMAPsNMl4d4mF0cU0AihjIZV",
                "4nr9IkNaT3k5OvQKdwcTalb9RTNNXtEckYvD4iSPj4Uc4"
    );

    public TwitterApiClientSpain() {
        super();
        init(credentials);
    }

}
