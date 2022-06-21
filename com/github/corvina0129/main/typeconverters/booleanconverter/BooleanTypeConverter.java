package com.github.corvina0129.main.typeconverters.booleanconverter;

import org.jetbrains.annotations.NotNull;

public final class BooleanTypeConverter extends AbstractBooleanTypeConverter {
    @Override
    public Boolean convert(@NotNull String string) {
        return "true".equals(string);
    }
}
