package com.github.corvina0129.main.splitter;

public final class BaseSplitter implements Splitter<String> {
    @Override
    public String[] split(String string, String separator) {
        return string.split(separator);
    }
}
