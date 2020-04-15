package com.cj.converter.unit;

public final class DistanceUnit extends SimpleUnit<DistanceUnit> {

    private Double conversionRateToMeters;

    public DistanceUnit(String symbol, Double conversionRateToMeters) {
        super(symbol);
        this.conversionRateToMeters = conversionRateToMeters;
    }


    public static DistanceUnit FEET = new DistanceUnit("ft",0.3048) ;
    public static DistanceUnit INCHES = new DistanceUnit("in",0.3048/12.0);
    public static DistanceUnit METERS = new DistanceUnit("m", 1.0);
    public static DistanceUnit MILES = new DistanceUnit("mi", 1609.344);

    @Override
    public final Double getConversionRateToBaseType() {
        return conversionRateToMeters;
    }

}
