package com.github.corvina0129.main.typedefiners;

import org.jetbrains.annotations.NotNull;

public final class BooleanTypeDefiner implements TypeDefiner {
    @Override
    public boolean isType(@NotNull String input) {
        return "true".equals(input) || "false".equals(input);
    }
}
