package com.example.structural.bridge.device;

public interface Device {
    boolean isEnabled();

    boolean enabled();

    boolean disabled();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);
}
