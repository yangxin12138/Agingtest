package com.twd.agingtest;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        //设置视频路径
        String videoPath = "android.resource://" + getPackageName() + "/"+R.raw.saye;
        videoView.setVideoURI(Uri.parse(videoPath));

        //准备视频
        videoView.setOnPreparedListener(mediaPlayer -> {
            mediaPlayer.setLooping(true);//设置循环播放
        });

        videoView.start();//开始播放
    }
}