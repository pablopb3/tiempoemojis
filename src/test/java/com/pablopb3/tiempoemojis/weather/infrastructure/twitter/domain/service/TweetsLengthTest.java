package com.pablopb3.tiempoemojis.weather.infrastructure.twitter.domain.service;

import com.pablopb3.tiempoemojis.emoji.domain.model.WeatherEmoji;
import com.pablopb3.tiempoemojis.weather.infrastructure.io.service.TemplateReader;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.TwitterException;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

class TweetsLengthTest {

    private Logger log = LoggerFactory.getLogger(TwitterApiClientTesting.class);

    private TemplateReader templateReader;
    private TwitterApiClient twitterApiClient;


    @BeforeEach
    void setup() {
        this.templateReader = new TemplateReader();
        this.twitterApiClient = new TwitterApiClientTesting();

    }

    @Test
    void tweetTest() throws TwitterException, IOException {

        String symbol = WeatherEmoji.GREY_CLOUDS.getEmojiCode();

        String galicianMap = templateReader.readGaliciaTemplate();

        List<String> lines = Arrays.asList(galicianMap.split(System.getProperty("line.separator")));
        for(int i=0; i< lines.size()-1; i++) {
            long villageNumbers = lines.get(i).chars().filter(c -> c == ';').count();
            for(int j=0; j<villageNumbers; j++) {
                String v = "";
                if(j == villageNumbers-1) {
                    v = StringUtils.substringBetween(galicianMap, ";", "\n");
                } else {
                    v = StringUtils.substringBetween(galicianMap, ";", ";");
                }
                galicianMap = galicianMap.replace(";" + v, symbol);
            }
        }
        galicianMap = galicianMap.replace("      ;a guarda           ;lobios;baltar;verín;riós", "      "+symbol+"           "+
                symbol+symbol+symbol+symbol);
        log.info("chars: " + String.valueOf(galicianMap.length()));
        log.info("chars: " + galicianMap.chars().summaryStatistics().toString());
        log.info("chars encoded: " + String.valueOf(URLEncoder.encode(galicianMap).length()));
        log.info("bytes: " + String.valueOf(galicianMap.getBytes()).length());
        log.info("bytes encoded: " + String.valueOf(URLEncoder.encode(galicianMap).getBytes()).length());
        log.info(galicianMap);

        twitterApiClient.tweet(galicianMap);
    }


}