package com.github.corvina0129.main.parser;

import java.util.List;

public interface Parser<T> {
    List<T> parse(String input);
}
