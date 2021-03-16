package com.aleksey.java.calc.roman;

import java.util.Objects;

public class RomanNumber extends Number{
    private final int value;
    private final String romanValue;

    public RomanNumber(String romanValue) {
        this.romanValue = Objects.requireNonNull(romanValue, "Roman value can't be null");
        value = RomanNumberConverter.toInteger(romanValue);
    }

    public RomanNumber(int value) {
        romanValue = RomanNumberConverter.toRoman(value);
        this.value = value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public String toString() {
        return romanValue;
    }
}
