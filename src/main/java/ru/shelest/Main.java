package ru.shelest;

import ru.shelest.calculator.Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);

        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(final String input) throws Exception {
        final Calculator calculator = new Calculator();

        return calculator.calculate(input);
    }
}