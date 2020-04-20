package com.cj.converter.unit;

import com.cj.converter.unit.dimension.Dimension;
import com.cj.converter.unit.transformer.LinearTransformer;

public final class TemperatureUnit extends SimpleUnit {

    public TemperatureUnit(String symbol, Double slopeToCelsius, Double interceptToCelsius){
        super(symbol, Dimension.TEMPERATURE, new LinearTransformer(slopeToCelsius, interceptToCelsius));
    }

    public static TemperatureUnit CELSIUS = new TemperatureUnit("degC", 1.0, 0.0);
    public static TemperatureUnit FAHRENHEIT = new TemperatureUnit("degF", 0.5556, -17.7778);
    public static TemperatureUnit KELVIN = new TemperatureUnit("degK", 1.0, -273.15);

}
