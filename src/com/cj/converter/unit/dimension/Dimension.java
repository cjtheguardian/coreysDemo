package com.cj.converter.unit.dimension;

public interface Dimension {

    public static final SimpleDimension TIME = new Time();
    public static final SimpleDimension DISTANCE = new Distance();


    boolean matches(Dimension other);

}
