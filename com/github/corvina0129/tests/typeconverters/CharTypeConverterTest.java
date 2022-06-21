package com.github.corvina0129.tests.typeconverters;

import com.github.corvina0129.main.typeconverters.charconverter.CharTypeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CharTypeConverterTest {

    public static final CharTypeConverter charTypeConverter = new CharTypeConverter();

    @ParameterizedTest
    @MethodSource("provideParameters")
    void convert(char expected, char actual) {
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("a", charTypeConverter.convert("a")),
                Arguments.of("&", charTypeConverter.convert("&")),
                Arguments.of(",", charTypeConverter.convert(","))
        );
    }
}