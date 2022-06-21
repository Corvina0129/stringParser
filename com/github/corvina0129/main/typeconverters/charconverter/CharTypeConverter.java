package com.github.corvina0129.main.typeconverters.charconverter;

import org.jetbrains.annotations.NotNull;

public final class CharTypeConverter extends AbstractCharTypeConverter {
    @Override
    public Character convert(@NotNull String string) {
        return string.charAt(0);
    }
}
