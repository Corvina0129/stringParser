package com.github.corvina0129.main.typedefiners.chardefiner;

import org.jetbrains.annotations.NotNull;

public final class CharTypeDefiner extends AbstractCharTypeDefiner{

    @Override
    public boolean isType(@NotNull String input) {
        boolean result = true;

        if (input.length() == 1) {
            for (byte b : input.getBytes()) {
                if ((b >= 48 && b <= 57)) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }

        return result;
    }
}
