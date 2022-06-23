package com.github.corvina0129.tests.splitter;

import com.github.corvina0129.main.splitter.Splitter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseSplitterTest {

    private final Splitter<String> baseSplitter = new Splitter.Base();

    @Test
    void split_nextline() {
        String data = "987\nabc\nd\n1.234\nApple\n0";
        String separator = "\n";
        String[] expected = {"987", "abc", "d", "1.234", "Apple", "0"};
        String[] actual = baseSplitter.split(data, separator);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void split_comma() {
        String data = "987,abc,d,1.234,Apple,0";
        String separator = ",";
        String[] expected = {"987", "abc", "d", "1.234", "Apple", "0"};
        String[] actual = baseSplitter.split(data, separator);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}