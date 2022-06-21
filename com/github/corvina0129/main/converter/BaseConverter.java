package com.github.corvina0129.main.converter;

import com.github.corvina0129.main.typeconverters.TypeConverter;
import com.github.corvina0129.main.typedefiners.TypeDefiner;
import com.github.corvina0129.main.utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class BaseConverter implements Converter {

    private final TypeDefiner isNumber;
    private final List<Pair<TypeDefiner, TypeConverter>> pairsForNumbers;
    private final List<Pair<TypeDefiner, TypeConverter>> pairsNotForNumber;

    public BaseConverter(TypeDefiner numberDefiner, List<Pair<TypeDefiner, TypeConverter>> pairsForNumbers, List<Pair<TypeDefiner, TypeConverter>> pairsNotForNumber) {
        this.isNumber = numberDefiner;
        this.pairsForNumbers = pairsForNumbers;
        this.pairsNotForNumber = pairsNotForNumber;
    }

    @Override
    public List<Object> convert(String[] strings) {
        List<Object> result = new ArrayList<>();

        for (String string : strings) {
            if (isNumber.isType(string)) {
                for (Pair<TypeDefiner, TypeConverter> pair : pairsForNumbers) {
                    if (pair.first().isType(string)) {
                        result.add(pair.second().convert(string));
                        break;
                    }
                }
            } else {
                for (Pair<TypeDefiner, TypeConverter> pair : pairsNotForNumber) {
                    if (pair.first().isType(string)) {
                        result.add(pair.second().convert(string));
                        break;
                    }
                }
            }
        }
        return result;
    }
}
