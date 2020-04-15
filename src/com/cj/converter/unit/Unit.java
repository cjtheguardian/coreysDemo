package com.cj.converter.unit;

import com.cj.converter.unit.store.Units;

public abstract class Unit<T extends Unit<T>> {

    public Unit(String symbol) {
        if (symbol != null) {
            Units.addUnit(symbol, this);
        }
    }

    public abstract Double to(T type, Double input);

}
