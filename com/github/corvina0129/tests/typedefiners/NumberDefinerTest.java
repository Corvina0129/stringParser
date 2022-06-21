package com.github.corvina0129.tests.typedefiners;

import com.github.corvina0129.main.typedefiners.numberdefiner.NumberDefiner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberDefinerTest {

    private final NumberDefiner numberDefiner = new NumberDefiner();

    @ParameterizedTest
    @ValueSource(strings = {"-1", "234982374", "23.002", "0.0", "-9802999.89283"})
    void isType_positive(String string) {
        assertTrue(numberDefiner.isType(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3.4.5", "sdf", "1f", "", "-234-3630"})
    void isType_negative(String string) {
        assertFalse(numberDefiner.isType(string));
    }
}