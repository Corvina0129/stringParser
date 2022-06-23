package com.github.corvina0129.tests.typedefiners;

import com.github.corvina0129.main.typedefiners.CharTypeDefiner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CharTypeDefinerTest {

    private final CharTypeDefiner charTypeDefiner = new CharTypeDefiner();

    @ParameterizedTest
    @ValueSource(strings = {"\\", "a", "R", "?", ",", "&"})
    void isType_positive(String string) {
        assertTrue(charTypeDefiner.isType(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"wer", "1", ""})
    void isType_negative(String string) {
        assertFalse(charTypeDefiner.isType(string));
    }
}