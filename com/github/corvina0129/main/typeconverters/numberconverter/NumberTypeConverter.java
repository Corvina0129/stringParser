package com.github.corvina0129.main.typeconverters.numberconverter;

import org.jetbrains.annotations.NotNull;

public final class NumberTypeConverter extends AbstractNumberTypeConverter {
    @Override
    public Number convert(@NotNull String string) {

        Double result = .0;
        Double beforeDecimal = .0;
        Double afterDecimal = .0;
        Double afterDecimalCount = .0;
        int isNegative = 1;
        boolean flag = false;

        int count = string.length();

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
        // todo если afterDecimalCount больше 1, то трансформатор один, если нет, то другой
    }
}
