package com.example.structural.bridge.remote;

import com.example.structural.bridge.device.Device;

// 동작
public class RemoteControl {
    // 도메인
    protected final Device device;

    // 인터페이스를 파라미터로 받는다.
    public RemoteControl(Device device) {
        this.device = device;
    }

    // TV -> , Video ->
    public void togglePower() {
        if (device.isEnabled()) {
            device.disabled();
        } else {
            device.enabled();
        }
    }

    void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }

    void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }
}
