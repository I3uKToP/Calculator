package com.aleksey.java.calc.calculator;

import com.aleksey.java.calc.EquationOperator;

public class CalculatorArabic extends Calculator {

    private int result;

    public CalculatorArabic(Integer value1, Integer value2, EquationOperator operator) {
        super(value1, value2, operator);
    }

    @Override
    public Calculator calculate() {
        switch (getOperator()) {
            case ADD:
                result = getValue1().intValue() + getValue2().intValue();
                break;
            case SUBTRACT:
                result = getValue1().intValue() - getValue2().intValue();
                break;
            case MULTIPLY:
                result = getValue1().intValue() * getValue2().intValue();
                break;
            case DIVIDE:
                result = getValue1().intValue() / getValue2().intValue();
                break;
            default:
                throw new IllegalStateException("Operator '" + getOperator().getSign() + "' not implemented.");
        }

        return this;
    }

    @Override
    public String getResult() {
        return Integer.toString(result);
    }

}
