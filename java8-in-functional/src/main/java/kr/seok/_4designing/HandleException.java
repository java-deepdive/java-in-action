/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._4designing;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class HandleException {
    public static void main(String[] args) throws IOException {
        Stream.of("/usr", "/tmp")
                .map(path -> {
                    // 적절한 위치에서 예외처리를 하는 방식
                    try {
                        // 경로의 이름의 리스트를 얻어와 canonical 패스를 요청하는 명령어
                        return new File(path).getCanonicalPath();
                    } catch (IOException ex) {
                        return ex.getMessage();
                    }
                })
                .forEach(System.out::println);
    }
}
