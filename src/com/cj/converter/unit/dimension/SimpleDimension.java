package com.cj.converter.unit.dimension;

public abstract class SimpleDimension implements Dimension {

    @Override
    public final boolean matches(Dimension other) {
        return this.getClass().equals(other.getClass());
    }

}
