package com.github.corvina0129.main.typeconverters;

import org.jetbrains.annotations.NotNull;

public final class NumberTypeConverter implements TypeConverter<Double> {

    @Override
    public Double convert(@NotNull String string) {

        double result;
        double beforeDecimal = .0;
        double afterDecimal = .0;
        double afterDecimalCount = .0;
        int isNegative = 1;
        boolean flag = false;

        if (string.charAt(0) == '-') {
            isNegative = -1;
            flag = true;
        }
        else if (string.charAt(0) == '+') {
            flag = true;
        }
        for (int i = 0; i < string.length(); i++) {
            if (flag && i == 0) {
                continue;
            }
            if (afterDecimalCount == 0) {
                if (string.charAt(i) - '.' == 0) {
                    afterDecimalCount++;
                }
                else {
                    beforeDecimal = beforeDecimal * 10 + (string.charAt(i) - '0');
                }
            }
            else {
                afterDecimal = afterDecimal * 10 + string.charAt(i) - ('0');
                afterDecimalCount = afterDecimalCount * 10;
            }
        }
        if (afterDecimalCount != 0) {
            afterDecimal = afterDecimal / afterDecimalCount;
            result = beforeDecimal + afterDecimal;
        }
        else {
            result = beforeDecimal;
        }

        return result * isNegative;
    }
}
