package com.github.corvina0129.tests.utils;

import com.github.corvina0129.main.utils.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    public void testEquals_positive() {
        final Pair<Integer, String> firstPair = Pair.of(1, "first");
        final Pair<Integer, String> secondPair = Pair.of(1, "first");
        assertTrue(firstPair.equals(secondPair));
    }

    @Test
    public void testEquals_negative() {
        final Pair<Double, Boolean> firstPair = Pair.of(0.345, true);
        final Pair<Integer, String> secondPair = Pair.of(1, "first");
        assertFalse(firstPair.equals(secondPair));
    }

    @Test
    public void testFetchFirst() {
        final Pair<Integer, String> firstPair = Pair.of(1, "first");
        int expected = 1;
        int actual = firstPair.first();
        assertEquals(expected, actual);
    }

    @Test
    public void testFetchSecond() {
        final Pair<Integer, String> firstPair = Pair.of(1, "first");
        String expected = "first";
        String actual = firstPair.second();
        assertEquals(expected, actual);
    }
}
