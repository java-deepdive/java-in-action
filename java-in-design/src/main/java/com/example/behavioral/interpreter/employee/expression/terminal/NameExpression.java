package com.example.behavioral.interpreter.employee.expression.terminal;

import com.example.behavioral.interpreter.employee.domain.Employee;

public class NameExpression extends TerminalExpression {

    protected String name;

    public NameExpression(String name) {
        this.name = name;
    }

    @Override
    public boolean interpret(Employee context) {
        return context.getEmployeeName().equalsIgnoreCase(name);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("NameExpression [name=").append(name).append("]");
        return builder.toString();
    }
}
