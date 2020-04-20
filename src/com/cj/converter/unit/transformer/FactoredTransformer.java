package com.cj.converter.unit.transformer;

public class FactoredTransformer implements SimpleTransformer{

    private double factor;

    public FactoredTransformer(double factor) {
        this.factor = factor;
    }

    @Override
    public Double toBaseUnitType(Double input) {
        return input * factor;
    }

    @Override
    public Double fromBaseUnitType(Double input) {
        return input / factor;
    }
}
