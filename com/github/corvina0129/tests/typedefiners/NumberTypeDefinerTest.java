package com.github.corvina0129.tests.typedefiners;

import com.github.corvina0129.main.typedefiners.numberdefiner.NumberTypeDefiner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberTypeDefinerTest {

    private final NumberTypeDefiner numberDefiner = new NumberTypeDefiner();

    @ParameterizedTest
    @ValueSource(strings = {"-1", "234982374", "23.002", "0.0", "-9802999.89283", "234.0", "-34"})
    void isType_positive(String string) {
        assertTrue(numberDefiner.isType(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3.4.5", "sdf", "1f", "", "-234-3630", "123-456"})
    void isType_negative(String string) {
        assertFalse(numberDefiner.isType(string));
    }
}