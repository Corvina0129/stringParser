package com.github.corvina0129.main.typeconverters;

import org.jetbrains.annotations.NotNull;

public final class BooleanTypeConverter implements TypeConverter<Boolean> {
    @Override
    public Boolean convert(@NotNull String string) {
        return "true".equals(string);
    }
}
