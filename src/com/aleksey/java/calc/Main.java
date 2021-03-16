package com.aleksey.java.calc;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String equation = scanner.nextLine();
//        String equation = "5 + 6";

        System.out.println(EquationParser.getCalculator(equation)
                .calculate()
                .getResult());
    }
}
