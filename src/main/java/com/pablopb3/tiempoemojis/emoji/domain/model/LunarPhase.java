package com.pablopb3.tiempoemojis.emoji.domain.model;

import org.shredzone.commons.suncalc.MoonPhase;

public enum LunarPhase {

    NEW_MOON(0, MoonPhase.Phase.NEW_MOON),
    WAXING_CRESCENT_MOON(1),
    FIRST_QUARTER_MOON(2, MoonPhase.Phase.FIRST_QUARTER),
    WAXING_GIBBOUS_MOON(3),
    FULL_MOON(4, MoonPhase.Phase.FULL_MOON),
    WANING_GIBBOUS_MOUN(5),
    LAST_QUARTER_MOON(6, MoonPhase.Phase.LAST_QUARTER),
    WANING_CRESCENT_MOON(7);

    private Integer position;
    private MoonPhase.Phase phase;

    LunarPhase(Integer position) {
        this.position = position;
    }

    LunarPhase(Integer position, MoonPhase.Phase phase) {
        this.position = position;
        this.phase = phase;
    }

    private Integer getPosition() {
        return this.position;
    }

    private MoonPhase.Phase getPhase() {
        return this.phase;
    }

    public static LunarPhase getLunarPhase(MoonPhase.Phase phase, Integer sumToPosition) {
        for(LunarPhase value: values()) {
            if(phase.equals(value.getPhase())) {
                Integer position = (value.getPosition() + sumToPosition) % 8;
                return getPhaseByPosition(position);
            }
        }
        throw new RuntimeException("Couldn't find a lunar phase for :" + phase);
    }

    private static LunarPhase getPhaseByPosition(Integer position) {
        for(LunarPhase value: values()) {
            if(position.equals(value.getPosition())) {
                return value;
            }
        }
        throw new RuntimeException("Couldn't find a lunar phase for position :" + position);
    }

}


