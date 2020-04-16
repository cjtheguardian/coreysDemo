package com.cj.converter.unit;

import com.cj.converter.unit.dimension.Dimension;
import com.cj.converter.unit.dimension.SimpleDimension;
import com.cj.converter.unit.store.Units;

public abstract class Unit {

    private Dimension dimension;

    public Unit(String symbol, Dimension dimension) {
        this.dimension = dimension;
        if (symbol != null) {
            Units.addUnit(symbol, this);
        }
    }

    public final Double to(Unit type, Double input) {
        validateDimensions(dimension, type.dimension);
        return convert(type, input);
    }

    protected abstract Double convert(Unit type, Double input);

    private void validateDimensions(Dimension dimension, Dimension other) {
        if(!dimension.matches(other)) {
            throw new IllegalArgumentException("Dimensions of units don't match!");
        }
    }

    public Dimension getDimension() {
        return dimension;
    }

}
