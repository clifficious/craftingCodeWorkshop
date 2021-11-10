package com.pereira.workshop.craftingcode.exericise_02_roman_numbers;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumbersConverter {

    private final LinkedHashMap<Integer, String> conversionMap = new LinkedHashMap<>();

    public RomanNumbersConverter() {
        conversionMap.put(1000, "M");
        conversionMap.put(900, "CM");
        conversionMap.put(500, "D");
        conversionMap.put(400, "CD");
        conversionMap.put(100, "C");
        conversionMap.put(90, "XC");
        conversionMap.put(50, "L");
        conversionMap.put(40, "XL");
        conversionMap.put(10, "X");
        conversionMap.put(9, "IX");
        conversionMap.put(5, "V");
        conversionMap.put(4, "IV");
        conversionMap.put(1, "I");
    }

    public String toRomanNumeral(int number) {
        StringBuilder numeral = new StringBuilder();
        for (Map.Entry<Integer, String> conversion : conversionMap.entrySet()) {
            while (number >= conversion.getKey()) {
                numeral.append(conversion.getValue());
                number -= conversion.getKey();
            }
        }
        return numeral.toString();
    }
}
