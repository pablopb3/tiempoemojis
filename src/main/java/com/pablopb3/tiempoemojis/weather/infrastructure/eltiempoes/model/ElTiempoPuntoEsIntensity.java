package com.pablopb3.tiempoemojis.weather.infrastructure.eltiempoes.model;

import com.pablopb3.tiempoemojis.weather.domain.model.Intensity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ElTiempoPuntoEsIntensity {

    NONE(0, Intensity.NONE),
    LOW(1, Intensity.LOW),
    MEDIUM(2, Intensity.MEDIUM),
    HIGH(3, Intensity.HIGH),
    VERY_HIGH(4, Intensity.VERY_HIGH);

    protected final Integer level;
    protected final Intensity intensity;
    private static Logger log = LoggerFactory.getLogger(ElTiempoPuntoEsIntensity.class);

    ElTiempoPuntoEsIntensity(Integer level, Intensity intensity) {
        this.level = level;
        this.intensity = intensity;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public static Intensity getIntensityByLevel(Integer level) {
        for (ElTiempoPuntoEsIntensity e : values()) {
            if (e.level == level) {
                return e.getIntensity();
            }
        }
        log.error("Couldn't find a valid intensity for level " + level);
        return null;
    }

    public static Intensity getCloudsIntensityForMunicipality(Integer level) {
        if(level.equals(1)) { return Intensity.NONE; }
        if(level.equals(2) || level.equals(3) || level.equals(7)) { return Intensity.LOW; }
        if(level.equals(4)) { return Intensity.MEDIUM; }
        if(level.equals(5)) { return Intensity.HIGH; }
        if(level.equals(6)) { return Intensity.VERY_HIGH; }
        log.error("Couldn't find a valid cloud intensity for level " + level);
        return null;
    }

    public static Intensity getRainIntensityForMunicipality(Integer level) {
        if(level.equals(1)) { return Intensity.NONE; }
        if(level.equals(4)) { return Intensity.LOW; }
        if(level.equals(2)) { return Intensity.MEDIUM; }
        if(level.equals(6)) { return Intensity.HIGH; }
        if(level.equals(5)) { return Intensity.VERY_HIGH; }
        log.error("Couldn't find a valid rain intensity for level " + level);
        return null;
    }

    public static Intensity getSnowIntensityForMunicipality(Integer level) {
        if(level.equals(7)) { return Intensity.LOW; }
        if(level.equals(3)) { return Intensity.MEDIUM; }
        return Intensity.NONE;
    }

}

