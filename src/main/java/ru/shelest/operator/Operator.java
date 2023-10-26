package ru.shelest.operator;

import ru.shelest.operand.Operand;

public interface Operator {

    int accept(Operand operand1, Operand operand2);
}
