package com.github.corvina0129.main.typedefiners;

import org.jetbrains.annotations.NotNull;

public final class CharTypeDefiner implements TypeDefiner {

    @Override
    public boolean isType(@NotNull String input) {
        boolean result = true;

        if (input.length() == 1) {
            char ch = input.charAt(0);
            if (ch >= 48 && ch <= 57) {
                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }
}
