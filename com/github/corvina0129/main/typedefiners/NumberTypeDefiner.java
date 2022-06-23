package com.github.corvina0129.main.typedefiners;

import org.jetbrains.annotations.NotNull;

public final class NumberTypeDefiner implements TypeDefiner {

    @Override
    public boolean isType(@NotNull String input) {
        boolean result = true;
        int amountOfPoints = 0;
        int amountOfMinuses = 0;

        if (input.isEmpty()) {
            result = false;
        } else {
            for (byte b : input.getBytes()) {
                if (amountOfPoints > 1 || amountOfMinuses > 1){
                    result = false;
                    break;
                }
                if (!(b >= 48 && b <= 57)) {
                    if (b == 46) {
                        amountOfPoints += 1;
                    } else if (b == 45) {
                        if (input.charAt(0) != '-') {
                            // for "123-456"
                            result = false;
                            break;
                        } else {
                            amountOfMinuses += 1;
                        }
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
