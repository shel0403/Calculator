package ru.shelest.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArabicRomanNumberConverterTest {

    @Test
    void romanToArabicShouldThrowExceptionIfIncorrectInput() {
        assertThrows(Exception.class, () -> ArabicRomanNumberConverter.romanToArabic(""));
        assertThrows(Exception.class, () -> ArabicRomanNumberConverter.romanToArabic("764"));
        assertThrows(Exception.class, () -> ArabicRomanNumberConverter.romanToArabic("A"));
    }

    @Test
    void arabicToRomanShouldThrowExceptionIfIncorrectInput() {
        assertThrows(Exception.class, () -> ArabicRomanNumberConverter.arabicToRoman(0));
        assertThrows(Exception.class, () -> ArabicRomanNumberConverter.arabicToRoman(-1));
    }

    @Test
    void romanToArabicShouldReturnCorrectValue() throws Exception {
        assertEquals(1, ArabicRomanNumberConverter.romanToArabic("I"));
        assertEquals(2, ArabicRomanNumberConverter.romanToArabic("II"));
        assertEquals(3, ArabicRomanNumberConverter.romanToArabic("III"));
        assertEquals(4, ArabicRomanNumberConverter.romanToArabic("IV"));
        assertEquals(5, ArabicRomanNumberConverter.romanToArabic("V"));
        assertEquals(6, ArabicRomanNumberConverter.romanToArabic("VI"));
        assertEquals(7, ArabicRomanNumberConverter.romanToArabic("VII"));
        assertEquals(8, ArabicRomanNumberConverter.romanToArabic("VIII"));
        assertEquals(9, ArabicRomanNumberConverter.romanToArabic("IX"));
        assertEquals(10, ArabicRomanNumberConverter.romanToArabic("X"));
    }

    @Test
    void arabicToRomanShouldReturnCorrectValue() throws Exception {
        assertEquals("I", ArabicRomanNumberConverter.arabicToRoman(1));
        assertEquals("IV", ArabicRomanNumberConverter.arabicToRoman(4));
        assertEquals("IX", ArabicRomanNumberConverter.arabicToRoman(9));
        assertEquals("X", ArabicRomanNumberConverter.arabicToRoman(10));
        assertEquals("L", ArabicRomanNumberConverter.arabicToRoman(50));
        assertEquals("LXXII", ArabicRomanNumberConverter.arabicToRoman(72));
        assertEquals("C", ArabicRomanNumberConverter.arabicToRoman(100));
    }
}