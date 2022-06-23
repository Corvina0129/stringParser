package com.github.corvina0129.main;

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

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        final BaseConverter converter = new BaseConverter(Arrays.asList(
                Pair.of(new NumberTypeDefiner(), new NumberTypeConverter()),
                Pair.of(new StringTypeDefiner(), new StringTypeConverter()),
                Pair.of(new CharTypeDefiner(), new CharTypeConverter()),
                Pair.of(new BooleanTypeDefiner(), new BooleanTypeConverter())
        ));

        final BaseParser nextlineParser = new BaseParser("\n", converter);
        final BaseParser semicolonParser = new BaseParser(";", converter);

        String first = "username\nuser01\nage\n16\ncity\npekin";
        String second = "id;author;hemingway;book;for whom the bell tolls;sales;9097397.0;pricePerBook;889.50";

        List<Object> parsedFirst = nextlineParser.parse(first);
        List<Object> parsedSecond = semicolonParser.parse(second);
    }
}
