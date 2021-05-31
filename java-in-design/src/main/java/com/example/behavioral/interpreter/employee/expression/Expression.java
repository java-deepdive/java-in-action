package com.example.behavioral.interpreter.employee.expression;

import com.example.behavioral.interpreter.employee.domain.Employee;

public interface Expression {

    boolean interpret(Employee context);

}
