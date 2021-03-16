package com.aleksey.java.calc.calculator;

import com.aleksey.java.calc.EquationOperator;

import java.util.Objects;

public abstract class Calculator {

    private Number value1;
    private Number value2;
    private final EquationOperator operator;

    public Calculator(Number value1, Number value2, EquationOperator operator) {
        setValue1(value1);
        setValue2(value2);
        this.operator = Objects.requireNonNull(operator, "Operator can't be null");
    }

    public Number getValue1() {
        return value1;
    }

    public Number getValue2() {
        return value2;
    }

    public EquationOperator getOperator() {
        return operator;
    }

    private void setValue1(Number value1) {
        if (value1.intValue() < 0 || value1.intValue() > 10) {
            throw new IllegalArgumentException("Value1 must be 0 to 10");
        }

        this.value1 = value1;
    }

    private void setValue2(Number value2) {
        if (value2.intValue() < 0 || value2.intValue() > 10) {
            throw new IllegalArgumentException("Value2 must be 0 to 10");
        }

        this.value2 = value2;
    }

    public abstract Calculator calculate();

    public abstract String getResult();
}
