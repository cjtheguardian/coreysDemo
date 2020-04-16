package com.cj.converter.unit;

import com.cj.converter.unit.dimension.Dimension;
import com.cj.converter.unit.dimension.Distance;
import com.cj.converter.unit.transformer.FactoredTransformer;

public final class DistanceUnit extends SimpleUnit {

    public DistanceUnit(String symbol, Double conversionRateToMeters) {
        super(symbol, Dimension.DISTANCE, new FactoredTransformer(conversionRateToMeters));
    }

    public static DistanceUnit FEET = new DistanceUnit("ft",0.3048) ;
    public static DistanceUnit INCHES = new DistanceUnit("in",0.3048/12.0);
    public static DistanceUnit METERS = new DistanceUnit("m", 1.0);
    public static DistanceUnit MILES = new DistanceUnit("mi", 1609.344);

}
