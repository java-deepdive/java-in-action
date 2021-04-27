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
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class WatchFileChange {
    public static void main(String[] args) throws Exception {
        new Thread(() -> watchFileChange()).start();
        final File file = new File("sample.txt");

        file.createNewFile();

        Thread.sleep(5000);
        file.setLastModified(System.currentTimeMillis());
    }

    public static void watchFileChange() {
        try {
            // 경로 설정
            final Path path = Paths.get(".");

            final WatchService watchService =
                    path.getFileSystem()
                            .newWatchService();

            path.register(
                    // watch service 등록
                    watchService,
                    // 수정 이벤트 발생시 변경 사항 출력
                    StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("Report any file changed within next 1 minute...");

            final WatchKey watchKey = watchService
                    .poll(1, TimeUnit.MINUTES);

            if (watchKey != null) {
                watchKey.pollEvents()
                        .stream()
                        .forEach(event ->
                                System.out.println(event.context()));
            }
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex);
        }
    }
}
