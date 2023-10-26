package ru.shelest.operator;

import ru.shelest.operand.Operand;

import java.util.function.IntBinaryOperator;

public class MultiplicationOperator implements Operator {

    private final IntBinaryOperator operator;

    public MultiplicationOperator() {
        this.operator = (a, b) -> a * b;
    }

    @Override
    public int accept(Operand operand1, Operand operand2) {
        return this.operator.applyAsInt(operand1.value(), operand2.value());
    }
}
