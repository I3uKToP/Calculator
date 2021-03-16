package com.aleksey.java.calc;

public enum EquationOperator {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char sign;

    EquationOperator(char sign) {
        this.sign = sign;
    }

    public static EquationOperator getOperator(char sign) {
        for (EquationOperator operator : EquationOperator.values()) {
            if (operator.getSign() == sign) {
                return operator;
            }
        }

        throw new IllegalStateException("Illegal operator: '" + sign + "'.");
    }

    public char getSign() {
        return sign;
    }
}
