package com.pablopb3.tiempoemojis.emoji.domain.service;

import com.pablopb3.tiempoemojis.emoji.domain.model.LunarPhase;
import org.shredzone.commons.suncalc.MoonPhase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;

@Service
public class LunarPhasesService {

    private static Logger log = LoggerFactory.getLogger(LunarPhasesService.class);

    //todo: cache this function
    //todo: add ilumination % from MoonIlumination class
    public LunarPhase getCurrentMoonPhase() {
        Map<MoonPhase.Phase, Date> nextMoonPhasesTimes = getNextMoonPhasesTimes();
        Map.Entry<MoonPhase.Phase, Date> previousMoonPhaseWithTime = getThePrevious(nextMoonPhasesTimes);
        Map.Entry<MoonPhase.Phase, Date> followingMoonPhaseWithTime = getTheFollowing(nextMoonPhasesTimes);
        long secondsFromPrevious = Math.abs(new Date().getTime() - previousMoonPhaseWithTime.getValue().getTime())/1000;
        long secondsToFollowing = Math.abs(new Date().getTime() - followingMoonPhaseWithTime.getValue().getTime())/1000;
        long secondsInRange = secondsFromPrevious + secondsToFollowing;
        RangePosition position = getRangePosition(secondsFromPrevious, secondsInRange);

        LunarPhase currentLunarPhase = LunarPhase.getLunarPhase(previousMoonPhaseWithTime.getKey(), position.getIndex());

        log.debug("previous phase: " + previousMoonPhaseWithTime.getKey());
        log.debug("following phase : " + followingMoonPhaseWithTime.getKey());
        log.debug("previous : " + secondsFromPrevious);
        log.debug("following : " + secondsToFollowing);
        log.debug("position: " + position);
        log.debug("current moon phase!: " + currentLunarPhase);

        return currentLunarPhase;
    }

    private RangePosition getRangePosition(long secondsFromPrevious, long secondsInRange) {
        if(((double) secondsFromPrevious/secondsInRange) <= 0.25) {
            return RangePosition.BEGINNING;
        }
        if(((double) secondsFromPrevious/secondsInRange) >= 0.75) {
            return RangePosition.END;
        }
        return RangePosition.CENTER;
    }

    private Map<MoonPhase.Phase, Date> getNextMoonPhasesTimes() {
        Map<MoonPhase.Phase, Date> moonPhasesTimes = new HashMap<>();
        moonPhasesTimes.put(MoonPhase.Phase.NEW_MOON, getNextZonedDateTimeForLunarPhase(MoonPhase.Phase.NEW_MOON));
        moonPhasesTimes.put(MoonPhase.Phase.FIRST_QUARTER, getNextZonedDateTimeForLunarPhase(MoonPhase.Phase.FIRST_QUARTER));
        moonPhasesTimes.put(MoonPhase.Phase.FULL_MOON, getNextZonedDateTimeForLunarPhase(MoonPhase.Phase.FULL_MOON));
        moonPhasesTimes.put(MoonPhase.Phase.LAST_QUARTER, getNextZonedDateTimeForLunarPhase(MoonPhase.Phase.LAST_QUARTER));
        return moonPhasesTimes;
    }

    private Date getNextZonedDateTimeForLunarPhase(MoonPhase.Phase phase) {
        return getNextZonedDateTimeForLunarPhase(phase, LocalDate.now());
    }

    private Date getNextZonedDateTimeForLunarPhase(MoonPhase.Phase phase, LocalDate date) {
        ZonedDateTime time = MoonPhase.compute()
                .phase(phase)
                .on(date)
                .timezone(ZoneId.of("Europe/Madrid"))
                .execute().getTime();
        return Date.from(time.toInstant());
    }

    private MoonPhase.Phase getThePreviousPhase(Map<MoonPhase.Phase, Date> moonPhasesTimes) {
        return moonPhasesTimes.entrySet().stream().sorted(comparingByValue(Comparator.reverseOrder())).findFirst().get().getKey();
    }

    private Map.Entry<MoonPhase.Phase, Date> getTheFollowing(Map<MoonPhase.Phase, Date> moonPhasesTimes) {
        return moonPhasesTimes.entrySet().stream().sorted(comparingByValue()).findFirst().get();
    }

    private Map.Entry<MoonPhase.Phase, Date> getThePrevious(Map<MoonPhase.Phase, Date> moonPhasesTimes) {
        MoonPhase.Phase previousPhase = getThePreviousPhase(moonPhasesTimes);
        return new AbstractMap.SimpleEntry<>(previousPhase, getNextZonedDateTimeForLunarPhase(previousPhase, LocalDate.now().minusDays(28)));
    }

}

enum RangePosition {
    BEGINNING(0),
    CENTER(1),
    END(2);

    private Integer index;

    RangePosition(Integer index) {
        this.index = index;
    }

    Integer getIndex() {
        return this.index;
    }
}
