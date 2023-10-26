package ru.shelest.util;

import java.util.function.Supplier;

public final class Checker {

    private Checker() {
    }

    public static void require(boolean statement, Supplier<Exception> exceptionSupplier) throws Exception {
        if (!statement) {
            throw exceptionSupplier.get();
        }
    }
}
