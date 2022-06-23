package com.github.corvina0129.main.splitter;

public interface Splitter<T> {
    T[] split(String string, String separator);
}
