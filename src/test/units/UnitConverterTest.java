package test.units;

import com.cj.converter.unit.DistanceUnit;
import com.cj.converter.unit.Unit;
import com.cj.converter.unit.UnitConverter;
import com.cj.converter.unit.complex.ComplexUnit;
import com.cj.converter.unit.complex.VelocityUnit;
import com.cj.converter.unit.store.Units;

import java.sql.SQLOutput;

public class UnitConverterTest {

    public static void main(String[] args) {
        Units.initializeUnitsRepo();
        System.out.println();
        // NOTE. THIS IS NOT HOW YOU WOULD NORMALLY TEST!!!
        // but because we are not using maven, i dont feel like pulling the junit jar manually and adding as a dependency

        // postiive tests
        testVelocityConversion();
        testTemperatureConversion();

        // negative tests
        testExceptionWithIncompatibleSimpleUnits();
        testExceptionWithIncompatibleComplexUnits();
        testExceptionWithComplexThenSimpleUnit();
        testExceptionWithSimpleThenComplexUnit();
    }


    private static void testVelocityConversion() {
        System.out.println();
        System.out.println("Testing velocity conversion....");
        Double mph = UnitConverter.convert(10.0, "m/s", "mph");
        System.out.println("10 meters per second is " + mph+ " mph");
    }

    private static void testTemperatureConversion() {
        System.out.println();
        System.out.println("Testing temperature conversion...");
        Double degCelsius = UnitConverter.convert(100.0, "degF", "degC");
        System.out.println("100 degrees Farhienheit is " + degCelsius + " degrees Celsius");
    }

    private static void testExceptionWithIncompatibleSimpleUnits() {
        System.out.println();
        System.out.println("Testing incompatible simple units....");
        try{
            Double seconds = UnitConverter.convert(10.0,"ft","h");
            System.out.println("NOT GOOD!!! - calculate 10 meters as " + seconds + " seconds.... uh oh");
        } catch(Exception e) {
            System.err.println("Caught exception as expected! " + e.getMessage());
        }
    }

    private static void testExceptionWithIncompatibleComplexUnits() {
        System.out.println();
        System.out.println("Testing incompatible complex units....");
        try{
            Double acc = UnitConverter.convert(10.0,"m/s","m/s2");
            System.out.println("NOT GOOD!!! - calculate 10 m/s as " + acc + " m/s.... uh oh");
        } catch(Exception e) {
            System.err.println("Caught exception as expected! " + e.getMessage());
        }
    }

    private static void testExceptionWithComplexThenSimpleUnit() {
        System.out.println();
        System.out.println("Testing complex to simple unit conversion....");
        try{
            Double acc = UnitConverter.convert(10.0,"m/s","m");
            System.out.println("NOT GOOD!!! - calculate 10 m/s as " + acc + " meters.... uh oh");
        } catch(Exception e) {
            System.err.println("Caught exception as expected! " + e.getMessage());
        }
    }


    private static void testExceptionWithSimpleThenComplexUnit() {
        System.out.println();
        System.out.println("Testing simple to complex unit conversion....");
        try{
            Double acc = UnitConverter.convert(10.0,"m","m/s");
            System.out.println("NOT GOOD!!! - calculate 10 meters as " + acc + " m/s.... uh oh");
        } catch(Exception e) {
            System.err.println("Caught exception as expected! " + e.getMessage());
        }
    }


}
