package com.example.structural.bridge.device;

import com.example.structural.bridge.remote.AdvancedRemoteControl;
import com.example.structural.bridge.remote.RemoteControl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeviceTest {

    @DisplayName("티비 클라이언트 코드 테스트")
    @Test
    void testCase1() {
        Device device = new Tv();
        RemoteControl remoteControl = new RemoteControl(device);

        remoteControl.togglePower();
    }

    @DisplayName("라디오 클라이언트 코드 테스트")
    @Test
    void testCase2() {
        Device device = new Radio();
        RemoteControl remoteControl = new AdvancedRemoteControl(device);

        remoteControl.togglePower();
    }
}
