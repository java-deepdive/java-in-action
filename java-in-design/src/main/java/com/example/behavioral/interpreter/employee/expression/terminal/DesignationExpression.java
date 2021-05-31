package com.example.behavioral.interpreter.employee.expression.terminal;

import com.example.behavioral.interpreter.employee.domain.Employee;

public class DesignationExpression extends TerminalExpression {

    protected String designation;

    public DesignationExpression(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean interpret(Employee context) {
        return context.getDesignation().equalsIgnoreCase(designation);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DesignationExpression [designation=").append(designation).append("]");
        return builder.toString();
    }
}
