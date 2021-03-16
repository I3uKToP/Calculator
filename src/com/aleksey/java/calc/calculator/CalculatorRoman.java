package com.aleksey.java.calc.calculator;

import com.aleksey.java.calc.EquationOperator;
import com.aleksey.java.calc.roman.RomanNumber;

public class CalculatorRoman extends Calculator {

    private RomanNumber result;

    public CalculatorRoman(RomanNumber value1, RomanNumber value2, EquationOperator operator) {
        super(value1, value2, operator);
    }

    @Override
    public Calculator calculate() {
        int intResult;

        switch (getOperator()) {
            case ADD:
                intResult = getValue1().intValue() + getValue2().intValue();
                break;
            case SUBTRACT:
                intResult = getValue1().intValue() - getValue2().intValue();
                if (intResult < 1) {
                    throw new IllegalStateException("Integer value is less than 1.");
                }
                break;
            case MULTIPLY:
                intResult = getValue1().intValue() * getValue2().intValue();
                break;
            case DIVIDE:
                intResult = getValue1().intValue() / getValue2().intValue();
                if (intResult == 0) {
                    throw new IllegalStateException("Integer value is equal 0.");
                }
                break;
            default:
                throw new IllegalStateException("Operator '" + getOperator().getSign() + "' not implemented.");
        }

        result = new RomanNumber(intResult);

        return this;
    }

    @Override
    public String getResult() {
        return result.toString();
    }

}
