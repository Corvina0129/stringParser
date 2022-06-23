package com.github.corvina0129.tests.typedefiners;

import com.github.corvina0129.main.typedefiners.StringTypeDefiner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringTypeDefinerTest {

    private final StringTypeDefiner stringTypeDefiner = new StringTypeDefiner();

    @ParameterizedTest
    @ValueSource(strings = {"Apple", "a2", "&&", "123-123"})
    void isType_positive(String string) {
        assertTrue(stringTypeDefiner.isType(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"234.0", "0.0", "-34", "-3.145", "3", "m", ".", "&"})
    void isType_negative(String string) {
        boolean t =  stringTypeDefiner.isType(string);
        assertFalse(t);
    }
}