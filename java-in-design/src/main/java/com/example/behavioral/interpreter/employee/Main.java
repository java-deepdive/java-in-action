package com.example.behavioral.interpreter.employee;

import com.example.behavioral.interpreter.employee.domain.Department;
import com.example.behavioral.interpreter.employee.domain.Engineer;
import com.example.behavioral.interpreter.employee.domain.Manager;
import com.example.behavioral.interpreter.employee.expression.Expression;
import com.example.behavioral.interpreter.employee.parser.ExpressionParser;

public class Main {

    public static void main(String[] args) {
        Engineer ajay = new Engineer(1001l, "Ajay", "Developer", Department.ENG, 75000);
        Engineer vijay = new Engineer(1002l, "Vijay", "Sr. Developer", Department.ENG, 90000);
        Engineer jay = new Engineer(1003l, "Jay", "Lead", Department.ENG, 100000);
        Engineer martin = new Engineer(1004l, "Martin", "QA", Department.ENG, 70000);

        Manager kim = new Manager(1005l, "Kim", "Manager", Department.ENG, 110000);
        Engineer andersen = new Engineer(1006l, "Andersen", "Developer", Department.ENG, 95000);

        Manager niels = new Manager(1007l, "Niels", "Sr. Manager", Department.ENG, 140000);
        Engineer robert = new Engineer(1008l, "Robert", "Developer", Department.ENG, 85000);

        Manager rachelle = new Manager(1009l, "Rachelle", "Product Manager", Department.ENG, 150000);
        Engineer shailesh = new Engineer(1010l, "Shailesh", "Engineer", Department.ENG, 80000);

        kim.manages(ajay);
        kim.manages(martin);
        kim.manages(vijay);

        niels.manages(jay);
        niels.manages(andersen);
        niels.manages(shailesh);

        rachelle.manages(kim);
        rachelle.manages(robert);
        rachelle.manages(niels);

        String contextString = "Desig:manager, Deptt:eng, Manages:martin, salary:110000";
        Expression expression = ExpressionParser.parseExpression(contextString);
        System.out.println("contextString= " + contextString);
        System.out.println();
        System.out.println(kim);
        System.out.printf("For '%s', %s: %s.\n", kim.getEmployeeName(), expression, expression.interpret(kim));

        System.out.println("=======================================================================\n");
        contextString = "Desig:developer, Deptt:eng, salary:<85000";
        expression = ExpressionParser.parseExpression(contextString);
        System.out.println("contextString= " + contextString);
        System.out.println();
        System.out.println(ajay);
        System.out.printf("For '%s', %s: %s.\n", ajay.getEmployeeName(), expression, expression.interpret(ajay));
        System.out.println();
        System.out.println(andersen);
        System.out.printf("For '%s', %s: %s.\n", andersen.getEmployeeName(), expression, expression.interpret(andersen));
    }
}
