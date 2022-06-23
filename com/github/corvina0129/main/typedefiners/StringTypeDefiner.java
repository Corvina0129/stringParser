package com.github.corvina0129.main.typedefiners;

import org.jetbrains.annotations.NotNull;

public final class StringTypeDefiner implements TypeDefiner {

    @Override
    public boolean isType(@NotNull String input) {
        boolean result = true;

        if ("true".equals(input) || "false".equals(input) || input.length() < 2) {
            result = false;
        } else {
            int amountOfNumbers = 0;
            int amountOfPoints = 0;
            int amountOfMinuses = 0;

            for (byte b : input.getBytes()) {
                if ((b >= 48 && b <= 57)) {
                    amountOfNumbers += 1;
                } else if (b == 46) {
                    amountOfPoints += 1;
                } else if (b == 45) {
                    amountOfMinuses += 1;
                }
            }
            if (amountOfMinuses != 0) {
                if (amountOfPoints <= 1
                        && amountOfMinuses <= 1
                        && amountOfNumbers == input.length() - amountOfMinuses - amountOfPoints
                        && input.charAt(0) == '-') {
                    result = false;
                }
            } else {
                if (amountOfPoints <= 1
                        && amountOfNumbers == input.length() - amountOfPoints) {
                    result = false;
                }
            }
        }
        return result;
    }
}
