package com.example.structural.bridge.remote;

import com.example.structural.bridge.device.Tv;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdvancedRemoteControlTest {


    @DisplayName("응용된 리모컨")
    @Test
    void testCase1() {
        AdvancedRemoteControl advancedRemoteControl = new AdvancedRemoteControl(new Tv());
        advancedRemoteControl.mute();
        advancedRemoteControl.togglePower();
        advancedRemoteControl.channelDown();
    }
}
