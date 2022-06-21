package com.github.corvina0129.main.typedefiners.booleandefiner;

public final class BooleanTypeDefiner extends AbstractBooleanTypeDefiner {
    @Override
    public boolean isType(String input) {
        return "true".equals(input) || "false".equals(input);
    }
}
