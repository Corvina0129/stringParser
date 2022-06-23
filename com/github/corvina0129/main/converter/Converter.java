package com.github.corvina0129.main.converter;

import com.github.corvina0129.main.typeconverters.*;
import com.github.corvina0129.main.typedefiners.*;
import com.github.corvina0129.main.utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Converter {
    List<Object> convert(String[] strings);

    class Base implements Converter {

        private final List<Pair<TypeDefiner, TypeConverter>> pairsList;

        public Base(List<Pair<TypeDefiner, TypeConverter>> pairsList) {
            this.pairsList = pairsList;
        }

        @Override
        final public List<Object> convert(String[] strings) {
            List<Object> result = new ArrayList<>();

            for (String string : strings) {
                for (Pair<TypeDefiner, TypeConverter> pair : pairsList) {
                    if (pair.first().isType(string)) {
                        result.add(pair.second().convert(string));
                        break;
                    }
                }
            }
            return result;
        }
    }

    final class PreparedConverter extends Base {

        public PreparedConverter() {
            super(Arrays.asList(
                    Pair.of(new NumberTypeDefiner(), new NumberTypeConverter()),
                    Pair.of(new StringTypeDefiner(), new StringTypeConverter()),
                    Pair.of(new CharTypeDefiner(), new CharTypeConverter()),
                    Pair.of(new BooleanTypeDefiner(), new BooleanTypeConverter())
            ));
        }
    }
}
