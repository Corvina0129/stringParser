package com.github.corvina0129.main.parser;

import com.github.corvina0129.main.converter.Converter;

import java.util.List;

public class BaseParser implements Parser {

    private final String separator;
    private final Converter converter;

    public BaseParser(String separator, Converter converter) {
        this.separator = separator;
        this.converter = converter;
    }

    @Override
    public List<Object> parse(String inputString) {
        String[] strings = inputString.split(separator);
        List<Object> result = converter.convert(strings);

        return result;
    }
}
