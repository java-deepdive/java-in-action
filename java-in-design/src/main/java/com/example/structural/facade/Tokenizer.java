package com.example.structural.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tokenizer {

    public static List<String> tokenize(String source) {

        List<String> tokens = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(source);

        while (stringTokenizer.hasMoreElements()) {
            tokens.add((String) stringTokenizer.nextElement());
        }
        return tokens;
    }
}
