package ru.shelest.operation;

import ru.shelest.operand.Operand;
import ru.shelest.operator.Operator;

public class RomanNumbersOperation implements Operation {

    private final Operand operand1;
    private final Operand operand2;
    private final Operator operator;
    private final OperationType type;

    public RomanNumbersOperation(Operand operand1, Operand operand2, Operator operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.type = OperationType.ROMAN;
    }

    @Override
    public Operand getOperand1() {
        return operand1;
    }

    @Override
    public Operand getOperand2() {
        return operand2;
    }

    @Override
    public Operator getOperator() {
        return operator;
    }

    @Override
    public OperationType getType() {
        return type;
    }
}
