package com.cj.converter.unit.dimension;

public interface Dimension {

    public static final SimpleDimension TIME = new Time();
    public static final SimpleDimension DISTANCE = new Distance();
    public static final SimpleDimension TEMPERATURE = new Temperature();


    boolean matches(Dimension other);

}
