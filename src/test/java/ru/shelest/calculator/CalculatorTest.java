package ru.shelest.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void shouldReturnCorrectResult() throws Exception {
        assertEquals("III", calculator.calculate("I + II"));
        assertEquals("10", calculator.calculate("5 * 2"));
        assertEquals("X", calculator.calculate("V + V"));
        assertEquals("2", calculator.calculate("10 / 5"));
    }

    @Test
    void shouldThrowExceptionForInvalidInput() {
        assertThrows(Exception.class, () -> calculator.calculate(null));
        assertThrows(Exception.class, () -> calculator.calculate("X + 10"));
        assertThrows(Exception.class, () -> calculator.calculate("5 % 2"));
        assertThrows(Exception.class, () -> calculator.calculate("Hello"));
    }

    @Test
    void shouldThrowExceptionForNegativeResult() {
        assertThrows(Exception.class, () -> calculator.calculate("I - II"));
        assertThrows(Exception.class, () -> calculator.calculate("V - X"));
    }
}