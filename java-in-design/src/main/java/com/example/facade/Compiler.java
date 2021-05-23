package com.example.facade;

import com.example.facade.node.Node;

import java.util.List;

public class Compiler {

    public static int compile(String input) {

        Parser parser = new Parser();
        List<String> tokens = Tokenizer.tokenize(input);

        Node expression = parser.parse(tokens);
        int generate;

        try {
            generate = Generator.generate(expression);
            return generate;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
