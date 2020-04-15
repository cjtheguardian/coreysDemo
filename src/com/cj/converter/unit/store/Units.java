package com.cj.converter.unit.store;

import com.cj.converter.unit.DistanceUnit;
import com.cj.converter.unit.TimeUnit;
import com.cj.converter.unit.Unit;
import com.cj.converter.unit.complex.AccelerationUnit;
import com.cj.converter.unit.complex.VelocityUnit;

import java.util.HashMap;
import java.util.Map;

public class Units {

    private static Map<String, Unit> unitsBySymbol = new HashMap<>();

    static {
        // TODO gotta be a better way to do this
        // need to initialize all the unit classes so they populated in this Map
        new VelocityUnit(null, DistanceUnit.METERS, TimeUnit.HOURS);
        new AccelerationUnit(null, DistanceUnit.METERS, TimeUnit.HOURS);

    }

    public static void addUnit(String symbol, Unit unit) {
        if(unitsBySymbol.containsKey(symbol)) {
            throw new RuntimeException("Symbol already mapped: " + symbol);
        }
        unitsBySymbol.put(symbol, unit);
    }

    public static Unit getUnitForSymbol(String symbol) {
        return unitsBySymbol.get(symbol);
    }

}
