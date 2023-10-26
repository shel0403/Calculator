package ru.shelest.calculator;

import ru.shelest.operand.Operand;
import ru.shelest.operation.Operation;
import ru.shelest.operation.OperationType;
import ru.shelest.operator.Operator;
import ru.shelest.parser.ArabicRomanNumberConverter;
import ru.shelest.parser.ExpressionParser;

import static ru.shelest.util.Checker.require;

public class Calculator {

    public String calculate(final String input) throws Exception {
        final Operation operation = ExpressionParser.parse(input);
        final Operand operand1 = operation.getOperand1();
        final Operand operand2 = operation.getOperand2();
        final Operator operator = operation.getOperator();
        final int result = operator.accept(operand1, operand2);

        if (operation.getType().equals(OperationType.ROMAN)) {
            require(result > 0, IllegalArgumentException::new);

            return ArabicRomanNumberConverter.arabicToRoman(result);
        }

        return String.valueOf(result);
    }
}
