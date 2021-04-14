package com.example.smartcare2.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dueeeke.videoplayer.player.VideoView;
import com.dueeeke.videocontroller.StandardVideoController;

import com.example.smartcare2.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MonitorFragment extends Fragment {

    private MonitorViewModel mViewModel;

    private VideoView videoView;

    private TextView time;

    public static MonitorFragment newInstance() {
        return new MonitorFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_monitor, container, false);
        //初始化视频播放器
        init_videoView(root);
        //显示当前时刻
//        time = (TextView) root.findViewById(R.id.curr_time);
//        Log.d("setCurr_time返回值", setCurr_time());
//        time.setText("这里出现问题");
        return root;
    }


    //初始化播放器
    protected void init_videoView(View view) {
        videoView = (VideoView) view.findViewById(R.id.player);
        videoView.setUrl("http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8");
        //设置播放器的控制器
        StandardVideoController controller = new StandardVideoController(getContext());
        controller.addDefaultControlComponent("直播测试", false);
        //将该控制器与播放器关联
        videoView.setVideoController(controller);
        videoView.start();
    }

    //显示当前时刻
    protected String setCurr_time() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
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