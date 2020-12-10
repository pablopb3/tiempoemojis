package com.pablopb3.tiempoemojis.weather.infrastructure.io.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TemplateReaderTest {

    private static Logger log = LoggerFactory.getLogger(TemplateReaderTest.class);

    private TemplateReader templateReader;

    @BeforeEach
    void setup() {
        this.templateReader = new TemplateReader();
    }

    @Test
    public void read() throws Exception {
        log.info(templateReader.readTemplate());
    }

}