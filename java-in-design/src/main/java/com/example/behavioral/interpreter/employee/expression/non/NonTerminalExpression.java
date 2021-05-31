package com.example.behavioral.interpreter.employee.expression.non;

import com.example.behavioral.interpreter.employee.expression.Expression;

public abstract class NonTerminalExpression implements Expression {

    protected Expression expression;

    protected NonTerminalExpression() {
        super();
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
