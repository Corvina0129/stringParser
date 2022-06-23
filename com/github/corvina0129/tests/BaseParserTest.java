package com.github.corvina0129.tests;

import com.github.corvina0129.main.converter.BaseConverter;
import com.github.corvina0129.main.parser.BaseParser;
import com.github.corvina0129.main.typeconverters.BooleanTypeConverter;
import com.github.corvina0129.main.typeconverters.CharTypeConverter;
import com.github.corvina0129.main.typeconverters.NumberTypeConverter;
import com.github.corvina0129.main.typeconverters.StringTypeConverter;
import com.github.corvina0129.main.typedefiners.BooleanTypeDefiner;
import com.github.corvina0129.main.typedefiners.CharTypeDefiner;
import com.github.corvina0129.main.typedefiners.NumberTypeDefiner;
import com.github.corvina0129.main.typedefiners.StringTypeDefiner;
import com.github.corvina0129.main.utils.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseParserTest {

    private final BaseConverter converter = new BaseConverter(Arrays.asList(
            Pair.of(new NumberTypeDefiner(), new NumberTypeConverter()),
            Pair.of(new StringTypeDefiner(), new StringTypeConverter()),
            Pair.of(new CharTypeDefiner(), new CharTypeConverter()),
            Pair.of(new BooleanTypeDefiner(), new BooleanTypeConverter())
    ));

    @Test
    void parse_nextline() {
        final BaseParser parser = new BaseParser("\n", converter);
        String string = "123\ntrue\napple\nm\n-54\n1.55\n32000\n-1000000\n3000000000000000.0\n-340282346638528859811704183484516925445.1";
        List<Object> expected = new ArrayList<>(Arrays.asList(
                123.0, true, "apple", 'm', -54.0, 1.55, 32000.0,
                -1000000.0, 3000000000000000.0, -340282346638528859811704183484516925445.1
        ));
        List<Object> actual = parser.parse(string);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    void parse_semicolon() {
        final BaseParser parser = new BaseParser(";", converter);
        String string = "123;true;apple;m;-54;1.55;32000;-1000000;3000000000000000.0;-340282346638528859811704183484516925445.1";
        List<Object> expected = new ArrayList<>(Arrays.asList(
                123.0, true, "apple", 'm', -54.0, 1.55, 32000.0,
                -1000000.0, 3000000000000000.0, -340282346638528859811704183484516925445.1
        ));
        List<Object> actual = parser.parse(string);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    void parse_whitespace() {
        final BaseParser parser = new BaseParser(" ", converter);
        String string = "123 true apple m -54 1.55 32000 -1000000 3000000000000000.0 -340282346638528859811704183484516925445.1";
        List<Object> expected = new ArrayList<>(Arrays.asList(
                123.0, true, "apple", 'm', -54.0, 1.55, 32000.0,
                -1000000.0, 3000000000000000.0, -340282346638528859811704183484516925445.1
        ));
        List<Object> actual = parser.parse(string);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
