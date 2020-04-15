package com.cj.converter.unit;

public abstract class SimpleUnit<T extends SimpleUnit<T>> extends Unit<T> {

    public SimpleUnit(String symbol) {
        super(symbol);
    }

    public final Double to(T type, Double input) {
        // due to type erasures (generics), we should validate that the from and to types are compatible
        if(!this.getClass().equals(type.getClass())) {
            throw new IllegalArgumentException("Cannot convert units of incompatible types "+this.getClass().getSimpleName() + " and " + type.getClass().getSimpleName());
        }
        Double inputAsBaseType = toBaseType(input);
        Double inputAsWantedType = type.fromBaseType(inputAsBaseType);
        return inputAsWantedType;
    }

    protected Double toBaseType(Double input) {
        Double conversionRate = getConversionRateToBaseType();
        return input * conversionRate;
    }

    protected Double fromBaseType(Double input) {
        Double conversionRate = getConversionRateToBaseType();
        return input / conversionRate;
    }

    protected abstract Double getConversionRateToBaseType();

}
