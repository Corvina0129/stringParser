package com.github.corvina0129.tests.typeconverters;

import com.github.corvina0129.main.typeconverters.numberconverter.NumberTypeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberTypeConverterTest {

    public static final NumberTypeConverter converter = new NumberTypeConverter();

    @ParameterizedTest
    @MethodSource("provideParameters")
    void convert(double expected, double actual) {
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(112, converter.convert("112")),
                Arguments.of(-23428.88, converter.convert("-23428.88")),
                Arguments.of(-9, converter.convert("-9")),
                Arguments.of(0, converter.convert("0"))
        );
    }
}