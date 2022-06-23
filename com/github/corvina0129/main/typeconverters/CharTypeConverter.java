package com.github.corvina0129.main.typeconverters;

import org.jetbrains.annotations.NotNull;

public final class CharTypeConverter implements TypeConverter<Character> {
    @Override
    public Character convert(@NotNull String string) {
        return string.charAt(0);
    }
}
