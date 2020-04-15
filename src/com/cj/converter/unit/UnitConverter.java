package com.cj.converter.unit;

import com.cj.converter.unit.store.Units;

public class UnitConverter {

    public static Double convert(Double input, String fromSymbol, String toSymbol) {
        Unit from = Units.getUnitForSymbol(fromSymbol);
        Unit to = Units.getUnitForSymbol(toSymbol);
        return from.to(to, input);
    }

}
