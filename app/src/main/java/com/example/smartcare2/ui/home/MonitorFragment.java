package com.example.smartcare2.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dueeeke.videoplayer.player.VideoView;
import com.dueeeke.videocontroller.StandardVideoController;

import com.example.smartcare2.R;

public class MonitorFragment extends Fragment {

    private MonitorViewModel mViewModel;

    private VideoView videoView;

    public static MonitorFragment newInstance() {
        return new MonitorFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_monitor, container, false);
        //初始化视频播放器
        init_videoView(root);

        return root;
    }


    //初始化播放器
    protected void init_videoView(View view) {
        videoView = (VideoView) view.findViewById(R.id.player);
        videoView.setUrl("rtmp://58.200.131.2:1935/livetv/hunantv");
        //设置播放器的控制器
        StandardVideoController controller = new StandardVideoController(getContext());
        controller.addDefaultControlComponent("RTMP测试——湖南电视台直播", false);
        //将该控制器与播放器关联
        videoView.setVideoController(controller);
        videoView.start();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MonitorViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        videoView.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        videoView.release();
    }

    //onBackPressed()的问题可能会出现
}