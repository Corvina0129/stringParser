package com.github.corvina0129.main.splitter;

public interface Splitter<T> {

    T[] split(String string, String separator);

    final class Base implements Splitter<String> {

        @Override
        public String[] split(String string, String separator) {
            return string.split(separator);
        }
    }
}
