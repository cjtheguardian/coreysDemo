package com.cj.converter.unit.complex;

import com.cj.converter.unit.SimpleUnit;
import com.cj.converter.unit.Unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComplexUnit<T extends ComplexUnit<T>> extends Unit<T> {

    protected List<SimpleUnit> top;
    protected List<SimpleUnit> bottom;

    public ComplexUnit(String symbol, List<SimpleUnit> top, List<SimpleUnit> bottom) {
        super(symbol);
        if(top == null) {
            top = new ArrayList<>();
        }
        if(bottom == null) {
            bottom = new ArrayList<>();
        }
        this.top = top;
        this.bottom = bottom;
    }

    public ComplexUnit(List<SimpleUnit> top, List<SimpleUnit> bottom) {
        this(null, top, bottom);
    }

    @Override
    public final Double to(T type, Double input) {
        List<SimpleUnit> thisUnitTop = copyList(top);
        List<SimpleUnit> toTypeTop = copyList(type.top);
        Double convertedTopPart = convert(thisUnitTop, toTypeTop, input);

        List<SimpleUnit> thisUnitBottom = copyList(bottom);
        List<SimpleUnit> toTypeBottom = copyList(type.bottom);
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
