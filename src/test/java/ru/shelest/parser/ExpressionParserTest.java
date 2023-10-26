package ru.shelest.parser;

import org.junit.jupiter.api.Test;
import ru.shelest.operand.Operand;
import ru.shelest.operand.OperandType;
import ru.shelest.operation.ArabicNumbersOperation;
import ru.shelest.operation.Operation;
import ru.shelest.operation.RomanNumbersOperation;
import ru.shelest.operator.AddOperator;
import ru.shelest.operator.DivisionOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionParserTest {

    @Test
    void shouldReturnCorrectOperation() throws Exception {
        final Operation operation = ExpressionParser.parse("I + II");
        final Operation expectedOperation = new RomanNumbersOperation(
                new Operand(1, OperandType.ROMAN),
                new Operand(2, OperandType.ROMAN),
                new AddOperator()
        );

        assertEquals(expectedOperation.getOperand1(), operation.getOperand1());
        assertEquals(expectedOperation.getOperand2(), operation.getOperand2());
    }

    @Test
    void shouldThrowExceptionForInvalidInput() {
        assertThrows(Exception.class, () -> ExpressionParser.parse(null));
        assertThrows(Exception.class, () -> ExpressionParser.parse("X + 10"));
        assertThrows(Exception.class, () -> ExpressionParser.parse("5 % 2"));
        assertThrows(Exception.class, () -> ExpressionParser.parse("Hello"));
    }
}