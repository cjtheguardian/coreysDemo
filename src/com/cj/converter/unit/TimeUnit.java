package com.cj.converter.unit;

public final class TimeUnit extends SimpleUnit<TimeUnit> {

    private Double conversionRateToSeconds;

    public TimeUnit(String symbol, Double conversionRateToSeconds) {
        super(symbol);
        this.conversionRateToSeconds = conversionRateToSeconds;
    }


    public static TimeUnit MILLISECONDS = new TimeUnit("ms", 1.0/1000.0) ;
    public static TimeUnit SECONDS = new TimeUnit("s", 1.0);
    public static TimeUnit MINUTES = new TimeUnit("min",60.0);
    public static TimeUnit HOURS = new TimeUnit("h", 3600.0);

    @Override
    public final Double getConversionRateToBaseType() {
        return conversionRateToSeconds;
    }
}
