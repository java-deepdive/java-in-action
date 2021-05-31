package com.example.behavioral.interpreter.employee.expression.terminal;

import com.example.behavioral.interpreter.employee.domain.Employee;

public class DepartmentExpression extends TerminalExpression {

    protected String department;

    public DepartmentExpression(String department) {
        super();
        this.department = department;
    }

    @Override
    public boolean interpret(Employee context) {
        return context.getDepartment().name().equalsIgnoreCase(department);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DepartmentExpression [department=").append(department).append("]");
        return builder.toString();
    }
}
