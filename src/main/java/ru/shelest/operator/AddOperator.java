package ru.shelest.operator;

import ru.shelest.operand.Operand;

import java.util.function.IntBinaryOperator;

public class AddOperator implements Operator {

    private final IntBinaryOperator operator;

    public AddOperator() {
        this.operator = Integer::sum;
    }

    @Override
    public int accept(Operand operand1, Operand operand2) {
        return this.operator.applyAsInt(operand1.value(), operand2.value());
    }
}
