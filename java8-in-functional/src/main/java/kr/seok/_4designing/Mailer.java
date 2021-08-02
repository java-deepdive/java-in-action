/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._4designing;

/**
 * 지루한 클래스
 */
public class Mailer {
    /**
     * 직관적인 설계가 필요
     * 문제점 두 가지
     * 1. 반복해서 사용하는 mailer 레퍼런스
     * - 컨텍스트 객체의 상태를 계속 유지하는 메서드 체인 또는 캐스케이드 메서드 패턴을 사용하는 것이 좋음
     * 2. 명확하지 않은 객체의 라이프타임
     */
    public static void main(final String[] args) {
        Mailer mailer = new Mailer();
        mailer.from("build@agiledeveloper.com");
        mailer.to("venkats@agiledeveloper.com");
        mailer.subject("build notification");
        mailer.body("...your code sucks...");
        mailer.send();
    }

    public void from(final String address) { /*... */ }

    public void to(final String address) { /*... */ }

    public void subject(final String line) { /*... */ }

    public void body(final String message) { /*... */ }

    public void send() {
        System.out.println("sending...");
    }
}
