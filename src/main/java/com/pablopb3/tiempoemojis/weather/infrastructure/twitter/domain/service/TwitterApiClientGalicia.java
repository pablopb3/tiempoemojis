package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service;

import com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.model.TwitterApiCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TwitterApiClientGalicia extends TwitterApiClient {

    private Logger log = LoggerFactory.getLogger(TwitterApiClientGalicia.class);

    private final static TwitterApiCredentials credentials = new TwitterApiCredentials(
            "JpYMPCvwLPqLHmSQcwPsbJ7TC",
            "0S4EmehfFfLB6vRWiojgRGQcV3w8RkjsyGrXIhIZprLZvZRWyg",
            "1346180889580101632-0OA94idm0sBbHP0E0XrbTAZ2kQ1VQF",
            "6vNFdnvRd1N73OW0cH6iUjqpbdxIThCDcHfWEUo1RcHxu"
    );

    public TwitterApiClientGalicia() {
        super();
        init(credentials);
    }

}
