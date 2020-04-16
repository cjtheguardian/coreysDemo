package com.cj.converter.unit.complex;

import com.cj.converter.unit.SimpleUnit;
import com.cj.converter.unit.Unit;
import com.cj.converter.unit.dimension.Dimension;
import com.cj.converter.unit.dimension.SimpleDimension;
import com.cj.converter.unit.dimension.complex.ComplexDimension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexUnit extends Unit {

    protected List<SimpleUnit> top;
    protected List<SimpleUnit> bottom;

    public ComplexUnit(String symbol, List<SimpleUnit> top, List<SimpleUnit> bottom) {
        super(symbol, toDimension(top, bottom));
        if(top == null) {
            top = new ArrayList<>();
        }
        if(bottom == null) {
            bottom = new ArrayList<>();
        }
        this.top = top;
        this.bottom = bottom;
    }

    private static Dimension toDimension(List<SimpleUnit> top, List<SimpleUnit> bottom) {
        // these are called lambdas, if you havent gotten to them yet and are confused here. i can expand this code out to be more readable
        List<SimpleDimension> topDimensions = top.stream().map(SimpleUnit::getDimension).collect(Collectors.toList());
        List<SimpleDimension> bottomDimensions = bottom.stream().map(SimpleUnit::getDimension).collect(Collectors.toList());
        return new ComplexDimension(topDimensions, bottomDimensions);

    }

    @Override
    public final Double convert(Unit type, Double input) {
        if(!(type instanceof ComplexUnit)) {
            throw new IllegalArgumentException("Cannot convert from a ComplexUnit to a non ComplexUnit");
        }
        ComplexUnit convertToUnit = (ComplexUnit) type;
        List<SimpleUnit> thisUnitTop = copyList(top);
        List<SimpleUnit> toTypeTop = copyList(convertToUnit.top);
        Double convertedTopPart = convert(thisUnitTop, toTypeTop, input);

        List<SimpleUnit> thisUnitBottom = copyList(bottom);
        List<SimpleUnit> toTypeBottom = copyList(convertToUnit.bottom);
        Double convertedBottomPart = convert(thisUnitBottom, toTypeBottom, 1.0);
        return convertedTopPart / convertedBottomPart;
    }

    private Double convert(List<SimpleUnit> thisUnitTop, List<SimpleUnit> toTypeTop, Double input) {
        if(thisUnitTop.size() != toTypeTop.size()) {
            // TODO make exception more user friendly
            throw new IllegalArgumentException("Invalid conversion for complex type!");
        }
        for(SimpleUnit fromSimpleUnit : thisUnitTop) {
            SimpleUnit toSimpleUnit = findAndRemoveMatchingUnit(fromSimpleUnit.getClass(), toTypeTop);
            if(toSimpleUnit == null) {
                // TODO make exception more user friendly
                throw new IllegalArgumentException("Invalid conversion for complex type!");
            }
            input = fromSimpleUnit.to(toSimpleUnit, input);
        }
        return input;
    }

    private SimpleUnit findAndRemoveMatchingUnit(Class<? extends SimpleUnit> fromSimpleUnitClass, List<SimpleUnit> toTypeTop) {
        Iterator<SimpleUnit> iterator = toTypeTop.iterator();
        while(iterator.hasNext()) {
            SimpleUnit next = iterator.next();
            if(next.getClass().equals(fromSimpleUnitClass)) {
                iterator.remove();
                return next;
            }
        }
        return null;

    }

    private List<SimpleUnit> copyList(List<SimpleUnit> top) {
        List<SimpleUnit> copy = new ArrayList<>();
        top.stream().forEach(u -> copy.add(u));
        return copy;
    }

}
