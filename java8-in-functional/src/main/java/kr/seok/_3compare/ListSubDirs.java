/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._3compare;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ListSubDirs {
    public static void listTheHardWay() {
        List<File> files = new ArrayList<>();

        // 폴더 내 리스트를 가져옴
        File[] filesInCurrentDir = new File(".")
                .listFiles();

//        Arrays.stream(filesInCurrentDir)
//                .map(file -> file.getName())
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        for (File file : filesInCurrentDir) {
            // 리스트를 가져옴
            File[] filesInSubDir = file.listFiles();
            if (filesInSubDir != null) {
                files.addAll(Arrays.asList(filesInSubDir));
            } else {
                files.add(file);
            }
        }

        System.out.println("Count: " + files.size());
    }

    public static void betterWay() {
        List<File> files =
                Stream.of(new File(".").listFiles())
                        .flatMap(file ->
                                // 파일 리스트 없다.
                                file.listFiles() == null
                                        // 서브 디렉터리 자체를 추가
                                        ? Stream.of(file)
                                        // 파일 리스트 있으면 리스트 반환
                                        : Stream.of(file.listFiles())
                        ).collect(toList());
        System.out.println("Count: " + files.size());
    }

    public static void main(String[] args) {
        System.out.println("START:HARDWAY_OUTPUT");
        listTheHardWay();
        System.out.println("END:HARDWAY_OUTPUT");
        betterWay();
    }
}
