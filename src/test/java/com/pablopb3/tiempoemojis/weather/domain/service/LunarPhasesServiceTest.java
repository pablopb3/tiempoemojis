package com.pablopb3.tiempoemojis.weather.domain.service;

import com.pablopb3.tiempoemojis.emoji.domain.service.LunarPhasesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.shredzone.commons.suncalc.MoonIllumination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LunarPhasesServiceTest {

    private Logger log = LoggerFactory.getLogger(LunarPhasesServiceTest.class);

    private LunarPhasesService lunarPhasesService;

    @BeforeEach
    public void setup() {
        this.lunarPhasesService = new LunarPhasesService();
    }

    @Test
    void getCurrentMoonPhase() {
        lunarPhasesService.getCurrentMoonPhase();
    }

    @Test
    void getCurrentAngle() {
        log.info(MoonIllumination.compute().execute().toString());
    }

}