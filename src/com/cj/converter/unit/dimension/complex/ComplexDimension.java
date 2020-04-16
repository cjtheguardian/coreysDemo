package com.cj.converter.unit.dimension.complex;

import com.cj.converter.unit.SimpleUnit;
import com.cj.converter.unit.dimension.Dimension;
import com.cj.converter.unit.dimension.SimpleDimension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComplexDimension implements Dimension {

    private List<SimpleDimension> top;
    private List<SimpleDimension> bottom;

    public ComplexDimension(List<SimpleDimension> top, List<SimpleDimension> bottom) {
        this.top = top;
        this.bottom = bottom;
    }


    @Override
    public boolean matches(Dimension otherDimension) {
        if(!(otherDimension instanceof ComplexDimension)) {
            return false;
        }
        ComplexDimension other = (ComplexDimension) otherDimension;
        List<SimpleDimension> thisTop = copyList(top);
        List<SimpleDimension> otherTop = copyList(other.top);

        List<SimpleDimension> thisBottom = copyList(bottom);
        List<SimpleDimension> otherBottom = copyList(other.bottom);

        return matches(thisTop, otherTop) && matches(thisBottom, otherBottom);

    }

    private boolean matches(List<SimpleDimension> thisList, List<SimpleDimension> otherList) {
        if(thisList.size() != otherList.size()) {
            return false;
        }
        for(SimpleDimension thisDimension : thisList) {
            SimpleDimension otherDimension = findAndRemoveMatchingDimension(thisDimension, otherList);
            if(otherDimension == null) {
                return false;
            }
        }
        return true;
    }

    private SimpleDimension findAndRemoveMatchingDimension(SimpleDimension thisDimension, List<SimpleDimension> otherDimensions) {
        Iterator<SimpleDimension> iterator = otherDimensions.iterator();
        while(iterator.hasNext()) {
            SimpleDimension next = iterator.next();
            if(thisDimension.matches(next)) {
                iterator.remove();
                return next;
            }
        }
        return null;

    }

    private List<SimpleDimension> copyList(List<SimpleDimension> top) {
        List<SimpleDimension> copy = new ArrayList<>();
        top.stream().forEach(u -> copy.add(u));
        return copy;
    }
}
