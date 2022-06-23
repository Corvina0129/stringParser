package com.github.corvina0129.main.typeconverters;

import org.jetbrains.annotations.NotNull;

public final class StringTypeConverter implements TypeConverter<String> {

    @Override
    public String convert(@NotNull String string) {
        return string;
    }
}
