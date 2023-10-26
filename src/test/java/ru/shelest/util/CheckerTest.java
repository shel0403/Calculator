package ru.shelest.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test()
    void shouldThrowRuntimeExceptionTest() {
        assertThrows(RuntimeException.class, () -> Checker.require(false, RuntimeException::new));
    }

    @Test
    void shouldNotThrowAnyExceptionTest() {
        assertDoesNotThrow(() -> Checker.require(true, RuntimeException::new));
    }
}