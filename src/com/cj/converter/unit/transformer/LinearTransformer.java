package com.cj.converter.unit.transformer;

public class LinearTransformer implements SimpleTransformer {

    private Double slope;
    private Double intercept;

    public LinearTransformer(Double slope, Double intercept) {
        this.slope = slope;
        this.intercept = intercept;
    }

    @Override
    public Double toBaseUnitType(Double input) {
        return slope * input + intercept;
    }

    @Override
    public Double fromBaseUnitType(Double input) {
        return ( input - intercept ) / slope;
    }
}
