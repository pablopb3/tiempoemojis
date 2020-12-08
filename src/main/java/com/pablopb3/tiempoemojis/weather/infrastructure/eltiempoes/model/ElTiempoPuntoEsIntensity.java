package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model;

import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ElTiempoPuntoEsIntensity {

    NONE('0', Intensity.NONE),
    LOW('1', Intensity.LOW),
    MEDIUM('2', Intensity.MEDIUM),
    HIGH('3', Intensity.HIGH),
    VERY_HIGH('4', Intensity.VERY_HIGH);

    protected final char level;
    protected final Intensity intensity;
    private static Logger log = LoggerFactory.getLogger(ElTiempoPuntoEsIntensity.class);

    ElTiempoPuntoEsIntensity(char level, Intensity intensity) {
        this.level = level;
        this.intensity = intensity;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public static Intensity getIntensityByLevel(char level) {
        for (ElTiempoPuntoEsIntensity e : values()) {
            if (e.level == level) {
                return e.getIntensity();
            }
        }
        log.error("Couldn't find a valid intensity for level " + level);
        return null;
    }
}

