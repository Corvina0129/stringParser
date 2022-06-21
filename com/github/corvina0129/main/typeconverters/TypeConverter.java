package com.github.corvina0129.main.typeconverters;

import org.jetbrains.annotations.NotNull;

public interface TypeConverter<T> {
    T convert(@NotNull String string);
}
