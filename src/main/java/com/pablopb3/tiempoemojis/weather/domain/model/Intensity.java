package com.pablopb3.tiempoemojis.weather.domain.model;

public enum Intensity {
    NONE, LOW, MEDIUM, HIGH, VERY_HIGH;

    public boolean isLow() {
        return this.equals(LOW);
    }

    public boolean isMedium() {
        return this.equals(MEDIUM);
    }

    public boolean isHigh() {
        return this.equals(HIGH);
    }

    public boolean isVeryHigh() {
        return this.equals(VERY_HIGH);
    }

    public boolean isNoneOrLow() {
        return this.equals(NONE) || this.equals(LOW);
    }

    public boolean isMediumOrHigher() {
        return this.equals(MEDIUM) || this.equals(HIGH) || this.equals(VERY_HIGH);
    }
}
