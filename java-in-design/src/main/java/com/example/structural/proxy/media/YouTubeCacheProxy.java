package com.example.structural.proxy.media;

import com.example.structural.proxy.domain.Video;

import java.util.HashMap;

// Wrapper 클래스
public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {

    private final ThirdPartyYouTubeLib youtubeService;
    private final HashMap<String, Video> cacheAll = new HashMap<>();
    private HashMap<String, Video> cachePopular = new HashMap<>();

    public YouTubeCacheProxy() {
        this.youtubeService = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }

}
