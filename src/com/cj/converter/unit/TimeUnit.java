package com.cj.converter.unit;

import com.cj.converter.unit.dimension.Dimension;
import com.cj.converter.unit.dimension.Time;
import com.cj.converter.unit.transformer.FactoredTransformer;

public final class TimeUnit extends SimpleUnit {

    public TimeUnit(String symbol, Double conversionRateToSeconds) {
        super(symbol, Dimension.TIME, new FactoredTransformer(conversionRateToSeconds));
    }


    public static TimeUnit MILLISECONDS = new TimeUnit("ms", 1.0/1000.0) ;
    public static TimeUnit SECONDS = new TimeUnit("s", 1.0);
    public static TimeUnit MINUTES = new TimeUnit("min",60.0);
    public static TimeUnit HOURS = new TimeUnit("h", 3600.0);

}
