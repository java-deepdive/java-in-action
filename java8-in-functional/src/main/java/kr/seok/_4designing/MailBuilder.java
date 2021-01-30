/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._4designing;

public class MailBuilder {

    /*
        리턴된 객체를 사용하여 순차적인 호출에 대한 연결을 만들도록 한다.
     */
    public MailBuilder from(final String address) { /*... */ return this; }
    public MailBuilder to(final String address) { /*... */ return this; }
    public MailBuilder subject(final String line) { /*... */ return this; }
    public MailBuilder body(final String message) { /*... */ return this; }
    public void send() { System.out.println("sending..."); }


    /*
        메서드 연결을 통해 하나의 호출에서부터 종단 메서드인 send()의 처리 과정으로 마무리 한다.

        단점으로는 new 키워드로 인하여 API의 다양성과 가독성을 떨어뜨린다.
        그리고 아직 두 번째 문제인 객체 라이프 타임 문제가 남아 있다.

        객체 라이프 타임이란
            - from 과 같은 메서드가 정확하게 한 번만 호출 되어있다는 것을 보장하는 것이다.

     */
    public static void main(final String[] args) {
        new MailBuilder()
                .from("build@agiledeveloper.com")
                .to("venkats@agiledeveloper.com")
                .subject("build notification")
                .body("...it sucks less...")
                .send();
    }
}
