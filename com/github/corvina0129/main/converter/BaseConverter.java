package com.github.corvina0129.main.converter;

import com.github.corvina0129.main.typeconverters.TypeConverter;
import com.github.corvina0129.main.typedefiners.TypeDefiner;
import com.github.corvina0129.main.utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class BaseConverter implements Converter {

    private final List<Pair<TypeDefiner, TypeConverter>> pairsList;

    public BaseConverter(List<Pair<TypeDefiner, TypeConverter>> pairsList) {
        this.pairsList = pairsList;
    }

    @Override
    public List<Object> convert(String[] strings) {
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
