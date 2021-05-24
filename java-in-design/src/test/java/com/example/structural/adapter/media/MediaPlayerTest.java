package com.example.structural.adapter.media;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MediaPlayerTest {

    @DisplayName("오디오 플레이어 테스트")
    @Test
    void testCase1() {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");

    }
}
