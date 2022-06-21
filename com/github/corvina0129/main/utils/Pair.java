package com.github.corvina0129.main.utils;

import java.util.Objects;

public class Pair<T, U> {

    private final T first;
    private final U second;


    private Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> Pair<T, U> of(T first, U second) {
        return new Pair<>(first, second);
    }

    public T first() { return first; }
    public U second() { return second; }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Pair<?, ?> otherPair = (Pair<?, ?>) other;
        return first.equals(otherPair.first) && second.equals(otherPair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
