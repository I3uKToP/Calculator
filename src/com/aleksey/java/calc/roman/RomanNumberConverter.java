package com.aleksey.java.calc.roman;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class RomanNumberConverter {

    private final static TreeMap<Integer, String> mapToRomans = new TreeMap<>();
    private final static HashMap<String, Integer> mapToInteger = new HashMap<>();

    // Solution maximum value = 100
    static {
        mapToRomans.put(100, "C");
        mapToRomans.put(90, "XC");
        mapToRomans.put(50, "L");
        mapToRomans.put(40, "XL");
        mapToRomans.put(10, "X");
        mapToRomans.put(9, "IX");
        mapToRomans.put(5, "V");
        mapToRomans.put(4, "IV");
        mapToRomans.put(1, "I");

        for (Map.Entry<Integer, String> entry : mapToRomans.entrySet()) {
            mapToInteger.put(entry.getValue(), entry.getKey());
        }
    }

    public static String toRoman(int value) {
        isValidInteger(value);

        return convertToRoman(value);
    }

    public static int toInteger(String romanValue) {
        isValidRoman(romanValue);

        return convertToInteger(romanValue);
    }

    public static void isValidRoman(String romanValue) {
        if (romanValue.isEmpty()) {
            throw new IllegalArgumentException("Roman value can't be empty.");
        }

        for (char ch : romanValue.toCharArray()) {
            if (!mapToInteger.containsKey(Character.toString(ch)))
                throw new IllegalArgumentException("Roman value contains illegal character: '" + ch + "'.");
        }

        int value = convertToInteger(romanValue);
        if (!romanValue.equals(convertToRoman(value))) {
            throw new IllegalArgumentException("No such roman value.");
        }

        isValidInteger(value);
    }

    private static void isValidInteger(int value) {
        if (value < 1 || value > 100) {
            throw new IllegalArgumentException("Integer value must be between 1 and 100.");
        }
    }

    // https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java/12968022
    private static String convertToRoman(int value) {
        int key = mapToRomans.floorKey(value);
        if (value == key) {
            return mapToRomans.get(value);
        }
        return mapToRomans.get(key) + convertToRoman(value - key);
    }

    private static int convertToInteger(String romanValue) {
        if (romanValue.length() == 0) {
            return 0;
        }

        Integer value;
        if (romanValue.length() >= 2) {
            value = mapToInteger.get(romanValue.substring(0, 2));

            if (value != null) {
                return value + convertToInteger(romanValue.substring(2));
            }
        }

        value = mapToInteger.get(romanValue.substring(0, 1));
        return value + convertToInteger(romanValue.substring(1));
    }

}
