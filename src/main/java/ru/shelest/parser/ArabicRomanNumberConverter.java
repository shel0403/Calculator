package ru.shelest.parser;

import static ru.shelest.util.Checker.require;

public final class ArabicRomanNumberConverter {

    private ArabicRomanNumberConverter() {}

    public static int romanToArabic(String value) throws Exception {
        return switch (value) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception();
        };
    }

    public static String arabicToRoman(int value) throws Exception {
        require(value > 0, Exception::new);

        final int absolutValue = Math.abs(value);
        final int tensNumber = absolutValue / 10;
        final int onesNumber = absolutValue % 10;

        final String result = switch (onesNumber) {
            case 0 -> "";
            case 1, 2, 3 -> "I".repeat(onesNumber);
            case 4 -> "IV";
            case 5 -> "V";
            case 6, 7, 8 -> String.format("V%s", "I".repeat(onesNumber - 5));
            case 9 -> "IX";
            default -> throw new Exception();
        };

        final var prefix = switch (tensNumber) {
            case 0 -> "";
            case 1, 2, 3 -> "X".repeat(tensNumber);
            case 4 -> "XL";
            case 5 -> "L";
            case 6, 7, 8 -> String.format("L%s", "X".repeat(tensNumber - 5));
            case 9 -> "XC";
            case 10 -> "C";
            default -> throw new Exception();
        };

        return prefix + result;
    }
}
