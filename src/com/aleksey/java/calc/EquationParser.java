package com.aleksey.java.calc;

import com.aleksey.java.calc.calculator.Calculator;
import com.aleksey.java.calc.calculator.CalculatorArabic;
import com.aleksey.java.calc.calculator.CalculatorRoman;
import com.aleksey.java.calc.roman.RomanNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationParser {

    private final static String patternArabic = "([0-9]+)\\s?([+\\-/*])\\s?([0-9]+)";
    private final static String patternRoman = "([IVX]+)\\s?([+\\-/*])\\s?([IVX]+)";

    public static Calculator getCalculator(String equation) {
        if (equation.matches(patternArabic)) {
            return getCalculatorArabic(equation);
        } else if (equation.matches(patternRoman)) {
            return getCalculatorRoman(equation);
        }

        throw new IllegalArgumentException("Equation does not match available patterns.");
    }

    private static CalculatorArabic getCalculatorArabic(String equation) {
        Pattern pattern = Pattern.compile(patternArabic);
        Matcher matcher = pattern.matcher(equation);

        matcher.find(); // No need to check

        int value1 = Integer.parseInt(matcher.group(1));
        int value2 = Integer.parseInt(matcher.group(3));
        EquationOperator operator = EquationOperator.getOperator(matcher.group(2).charAt(0));

        return new CalculatorArabic(value1, value2, operator);
    }

    private static CalculatorRoman getCalculatorRoman(String equation) {
        Pattern pattern = Pattern.compile(patternRoman);
        Matcher matcher = pattern.matcher(equation);

        matcher.find(); // No need to check

        RomanNumber value1 = RomanNumber.valueOf(matcher.group(1));
        RomanNumber value2 = RomanNumber.valueOf(matcher.group(3));
        EquationOperator operator = EquationOperator.getOperator(matcher.group(2).charAt(0));

        return new CalculatorRoman(value1, value2, operator);
    }

}
