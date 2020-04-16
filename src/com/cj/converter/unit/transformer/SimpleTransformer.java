package com.cj.converter.unit.transformer;

/**
 * allows transforming of a value to and from that dimensions "base" unit
 *
 */
public interface SimpleTransformer {

    Double toBaseUnitType(Double input);
    
    Double fromBaseUnitType(Double input);


}
