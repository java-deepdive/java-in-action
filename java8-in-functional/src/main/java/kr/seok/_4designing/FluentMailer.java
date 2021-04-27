/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._4designing;

import java.util.function.Consumer;

public class FluentMailer {
    private FluentMailer() {
    }

    public FluentMailer from(final String address) { /*... */
        return this;
    }

    public FluentMailer to(final String address) { /*... */
        return this;
    }

    public FluentMailer subject(final String line) { /*... */
        return this;
    }

    public FluentMailer body(final String message) { /*... */
        return this;
    }

    public static void send(final Consumer<FluentMailer> block) {
        final FluentMailer mailer = new FluentMailer();
        block.accept(mailer);
        System.out.println("sending...");
    }

    /*
        1. 비종단 메서드는 동일하게 인스턴스를 리턴
        2. 생성자는 private 메서드로 하여 직접 객체를 생성하는 것을 방지
        3. 종단 메서드 send()는 정적 메서드이며 파라미터로 Consumer 를 사용한다.
     */
    public static void main(final String[] args) {
        FluentMailer
                // send를 호출해서 코드 블록을 넘긴다.
                .send(
                        // send 메서드는 인스턴스를 생성하고 블록을 가져와 리턴한 후에 검증을 완료하고나면 마지막 send 오퍼레이션을 수행한다.
                        mailer ->
                                mailer.from("build@agiledeveloper.com")
                                        .to("venkats@agiledeveloper.com")
                                        .subject("build notification")
                                        .body("...much better..."));
    }
}
