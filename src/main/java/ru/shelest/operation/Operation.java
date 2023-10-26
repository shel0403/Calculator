package ru.shelest.operation;

import ru.shelest.operand.Operand;
import ru.shelest.operator.Operator;

public interface Operation {

    Operand getOperand1();
    Operand getOperand2();
    Operator getOperator();
    OperationType getType();
}
