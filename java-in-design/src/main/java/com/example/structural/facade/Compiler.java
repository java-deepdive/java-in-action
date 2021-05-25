package com.example.structural.facade;

import com.example.structural.facade.node.Node;

import java.util.List;

// Facade
public class Compiler {

    // 클라이언트가 원하는 메서드 (기능)
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
