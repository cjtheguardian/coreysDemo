package com.cj.converter.unit.complex;

import com.cj.converter.unit.DistanceUnit;
import com.cj.converter.unit.SimpleUnit;
import com.cj.converter.unit.TimeUnit;

import java.util.Arrays;
import java.util.List;

public final class AccelerationUnit extends ComplexUnit<AccelerationUnit> {


    public static final AccelerationUnit METERS_PER_SECOND_SQUARED = new AccelerationUnit("m/s2", DistanceUnit.METERS, TimeUnit.SECONDS);
    public static final AccelerationUnit MILES_PER_HOUR_SQUARED = new AccelerationUnit("mph2", DistanceUnit.MILES, TimeUnit.HOURS);

    public AccelerationUnit(String symbol, DistanceUnit distanceUnit, TimeUnit timeUnit) {
        super(symbol, Arrays.asList(distanceUnit), Arrays.asList(timeUnit, timeUnit));
    }
}
