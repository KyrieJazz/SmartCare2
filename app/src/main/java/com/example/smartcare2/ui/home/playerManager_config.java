package com.example.smartcare2.ui.home;

import android.app.Application;

import com.dueeeke.videoplayer.ijk.IjkPlayerFactory;
import com.dueeeke.videoplayer.player.VideoViewConfig;
import com.dueeeke.videoplayer.player.VideoViewManager;
import com.example.smartcare2.BuildConfig;

public class playerManager_config extends Application{
    private static playerManager_config instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //对播放器核心进行全局配置
        VideoViewManager.setConfig(VideoViewConfig.newBuilder()
                .setLogEnabled(BuildConfig.DEBUG)
                .setPlayerFactory(IjkPlayerFactory.create())
                .build());
    }

    public static playerManager_config getInstance()
    {
        return instance;
    }
}
