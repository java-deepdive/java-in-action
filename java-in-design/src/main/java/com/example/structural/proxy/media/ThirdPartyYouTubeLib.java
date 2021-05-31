package com.example.structural.proxy.media;

import com.example.structural.proxy.domain.Video;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();
    Video getVideo(String videoId);
}
