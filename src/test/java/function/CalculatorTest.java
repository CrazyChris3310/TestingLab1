package function;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.PI;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("sinArgsProvider")
    void testSinPositiveArgs(double x, double expected) {
        assertEquals(expected, Calculator.sin(x), Calculator.PRECISION);
    }

    @ParameterizedTest
    @MethodSource("sinArgsProvider")
    void testSinNegativeArgs(double x, double expected) {
        assertEquals(-expected, Calculator.sin(-x), Calculator.PRECISION);
    }

    static Stream<Arguments> sinArgsProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(PI, 0),
                Arguments.of(PI/2, 1),
                Arguments.of(PI/3, sqrt(3)/2),
                Arguments.of(PI/4, sqrt(2)/2),
                Arguments.of(PI/6, 0.5),
                Arguments.of(2*PI/3, sqrt(3)/2),
                Arguments.of(3*PI/4, sqrt(2)/2),
                Arguments.of(5*PI/6, 0.5),
                Arguments.of(2*PI, 0),
                Arguments.of(3*PI, 0),
                Arguments.of(3*PI/2, -1),
                Arguments.of(16*PI/3, -sqrt(3)/2)
        );
    }

}