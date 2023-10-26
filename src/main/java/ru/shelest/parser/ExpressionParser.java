package ru.shelest.parser;

import ru.shelest.operand.Operand;
import ru.shelest.operand.OperandType;
import ru.shelest.operation.ArabicNumbersOperation;
import ru.shelest.operation.Operation;
import ru.shelest.operation.RomanNumbersOperation;
import ru.shelest.operator.*;
import ru.shelest.util.Pair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.shelest.util.Checker.require;

public final class ExpressionParser {

    private ExpressionParser() {}

    private static final String ROMAN_NUMBER = "(X|IX|IV|V?I{0,3})";
    private static final String ARABIC_NUMBER = "([1-9]0?)";
    private static final String OPERATOR = "([+\\-*/])";
    private static final String OPERATION = String.format(
            "\\s*(%s|%s)\\s*%s\\s*(%s|%s)\\s*",
            ROMAN_NUMBER,
            ARABIC_NUMBER,
            OPERATOR,
            ROMAN_NUMBER,
            ARABIC_NUMBER
    );

    public static Operation parse(final String input) throws Exception {
        require(input != null, Exception::new);
        require(input.matches(OPERATION), Exception::new);

        final Operator operator = parseOperator(input);
        final Pair<Operand, Operand> operands = parseOperands(input);
        final Operand operand1 = operands.first();
        final Operand operand2 = operands.second();
        final OperandType operand1Type = operand1.type();
        final OperandType operand2Type = operand2.type();

        require(
                operand1Type.equals(operand2Type),
                Exception::new
        );

        return switch (operand1Type) {
            case ARABIC -> new ArabicNumbersOperation(operand1, operand2, operator);
            case ROMAN -> new RomanNumbersOperation(operand1, operand2, operator);
        };
    }

    private static Operator parseOperator(final String input) throws Exception {
        final Pattern operatorPattern = Pattern.compile(OPERATOR);
        final Matcher operatorMatcher = operatorPattern.matcher(input);

        require(operatorMatcher.find(), Exception::new);

        final String inputOperator = operatorMatcher.group();

        return getOperator(inputOperator);
    }

    private static Pair<Operand, Operand> parseOperands(final String input) throws Exception {
        final Pair<String, String> inputOperands = splitOperands(input);
        final Operand operand1 = parseOperand(inputOperands.first());
        final Operand operand2 = parseOperand(inputOperands.second());

        return new Pair<>(operand1, operand2);
    }

    private static Pair<String, String> splitOperands(final String input) {
        final String[] tokens = input
                .trim()
                .replaceAll("\\s+", "")
                .split(OPERATOR);

        return new Pair<>(tokens[0], tokens[1]);
    }

    private static Operand parseOperand(final String input) throws Exception {
        if (input.matches(ARABIC_NUMBER)) {
            return new Operand(Integer.parseInt(input), OperandType.ARABIC);
        }

        if (input.matches(ROMAN_NUMBER)) {
            return new Operand(ArabicRomanNumberConverter.romanToArabic(input), OperandType.ROMAN);
        }

        throw new Exception();
    }

    private static Operator getOperator(final String input) throws Exception {
        return switch (input) {
            case "+" -> new AddOperator();
            case "-" -> new SubtractionOperator();
            case "*" -> new MultiplicationOperator();
            case "/" -> new DivisionOperator();
            default -> throw new Exception();
        };
    }
}
