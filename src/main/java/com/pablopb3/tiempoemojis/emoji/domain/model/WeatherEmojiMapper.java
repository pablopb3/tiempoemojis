package com.pablopb3.tiempoemojis.emoji.domain.model;

import com.pablopb3.tiempoemojis.emoji.domain.service.LunarPhasesService;
import com.pablopb3.tiempoemojis.weather.domain.model.WeatherDescription;
import org.springframework.stereotype.Service;

import static com.pablopb3.tiempoemojis.emoji.domain.model.WeatherEmoji.SUN_WITH_BIG_CLOUD_AND_RAIN;

@Service
public class WeatherEmojiMapper {

    private LunarPhasesService lunarPhasesService;

    public WeatherEmojiMapper(LunarPhasesService lunarPhasesService) {
        this.lunarPhasesService = lunarPhasesService;
    }

    public boolean isSun(WeatherDescription w) {
        return w.isItDay() && !w.isTherePrecipitations() && w.isSkyClear();
    }

    public boolean isSunWithSmallCloud(WeatherDescription w) {
        return w.isItDay() && !w.isTherePrecipitations() && w.getCloudsLevel().isLow();
    }

    public boolean isSunWithMediumCloud(WeatherDescription w) {
        return w.isItDay() && !w.isTherePrecipitations() && w.getCloudsLevel().isMedium();
    }

    public boolean isSunWithBigCloud(WeatherDescription w) {
        return w.isItDay() && !w.isTherePrecipitations() && w.getCloudsLevel().isHigh();
    }

    public boolean isSunWithBigCloudAndRain(WeatherDescription w) {
        return w.isItDay() && w.isItRainy() && w.getCloudsLevel().isLow() && !w.isStorming() && !w.isSnowing();
    }

    public boolean isGreyClouds(WeatherDescription w) {
        return !w.isTherePrecipitations() && (
                (w.isItNight() && w.getCloudsLevel().isMediumOrHigher()) ||
                        (w.isItDay() && w.getCloudsLevel().isVeryHigh())
        );
    }

    public boolean isRainyCloud(WeatherDescription w) {
        return w.isItRainy() && !SUN_WITH_BIG_CLOUD_AND_RAIN.isEmojiForWeather(w) &&
                !w.isStorming() && !w.isSnowing();
    }

    public boolean isStormCloud(WeatherDescription w) {
        return w.isStorming() && !w.isSnowing();
    }

    public boolean isSnowCloud(WeatherDescription w) {
        return w.isSnowing();
    }

    public boolean isMoon(WeatherDescription w) {
        return w.isItNight() && !w.isTherePrecipitations() && w.getCloudsLevel().isNoneOrLow();
    }

    public boolean isThisMoon(WeatherDescription w, LunarPhase phase) {
        return isMoon(w) && phase.equals(lunarPhasesService.getCurrentMoonPhase());
    }
}
