package com.pereira.workshop.craftingcode.exercise_02_roman_numbers;

import com.pereira.workshop.craftingcode.exericise_02_roman_numbers.RomanNumbersConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumbersConverterShould {

    @DisplayName("Convert number to roman numeral")
    @ParameterizedTest
    @CsvSource({
            "1,         I",
            "2,        II",
            "3,       III",
            "5,         V",
            "6,        VI",
            "10,        X",
            "11,       XI",
            "16,      XVI",
            "20,       XX",
            "50,        L",
            "100,       C",
            "500,       D",
            "1000,      M",
            "2368, MMCCCLXVIII",
            "4,        IV",
            "9,        IX",
            "2499,  MMCDXCIX",
            "76,    LXXVI",
            "493, CDXCIII",
            "3999, MMMCMXCIX"
    })
    void convert_number_to_roman_numeral(int number, String numeral) {
        RomanNumbersConverter romanNumbersConverter = new RomanNumbersConverter();
        assertThat(romanNumbersConverter.toRomanNumeral(number)).isEqualTo(numeral);
    }
}
