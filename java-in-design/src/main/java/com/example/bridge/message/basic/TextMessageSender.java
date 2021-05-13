package com.example.bridge.message.basic;

public class TextMessageSender extends TextMessage {
    @Override
    public void send() {
        System.out.println("텍스트 메시지 전송");
    }
}
