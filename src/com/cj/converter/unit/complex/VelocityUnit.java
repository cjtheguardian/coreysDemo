package com.cj.converter.unit.complex;

import com.cj.converter.unit.DistanceUnit;
import com.cj.converter.unit.TimeUnit;

import java.util.Arrays;

public final class VelocityUnit extends ComplexUnit {

    public static final VelocityUnit METERS_PER_SECOND = new VelocityUnit("m/s", DistanceUnit.METERS, TimeUnit.SECONDS);
    public static final VelocityUnit MILES_PER_HOUR = new VelocityUnit("mph", DistanceUnit.MILES, TimeUnit.HOURS);

    public VelocityUnit(String symbol, DistanceUnit distanceUnit, TimeUnit timeUnit) {
        super(symbol, Arrays.asList(distanceUnit), Arrays.asList(timeUnit));
    }

}
