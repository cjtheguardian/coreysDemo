package com.cj.converter.unit;

import com.cj.converter.unit.dimension.SimpleDimension;
import com.cj.converter.unit.transformer.SimpleTransformer;

public abstract class SimpleUnit extends Unit {

    private SimpleTransformer transformer;

    public SimpleUnit(String symbol, SimpleDimension dimension, SimpleTransformer transformer) {
        super(symbol, dimension);
        this.transformer = transformer;
    }


    protected Double convert(Unit toUnit, Double input) {
        // from the validation method in Unit class, we know the toUnit is a SimpleUnit
        SimpleUnit unitToConvertTo = (SimpleUnit) toUnit;
        Double thisAsBaseType = transformer.toBaseUnitType(input);
        return unitToConvertTo.transformer.fromBaseUnitType(thisAsBaseType);
    }

    @Override
    public SimpleDimension getDimension() {
        return (SimpleDimension) super.getDimension();
    }

}
