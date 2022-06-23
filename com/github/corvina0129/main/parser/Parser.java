package com.github.corvina0129.main.parser;

import com.github.corvina0129.main.converter.Converter;
import com.github.corvina0129.main.splitter.Splitter;

import java.util.List;

public interface Parser<T> {
    List<T> parse(String input);

    class Base implements Parser<Object> {

        private final String separator;
        private final Splitter<String> splitter;
        private final Converter converter;

        public Base(String separator, Splitter<String> splitter, Converter converter) {
            this.separator = separator;
            this.splitter = splitter;
            this.converter = converter;
        }

        @Override
        final public List<Object> parse(String input) {
            String[] strings = splitter.split(input, separator);
            List<Object> result = converter.convert(strings);

            return result;
        }
    }

    final class PreparedParser extends Base {

        public PreparedParser(String separator) {
            super(
                    separator,
                    new Splitter.Base(),
                    new Converter.PreparedConverter()
            );
        }
    }
}
