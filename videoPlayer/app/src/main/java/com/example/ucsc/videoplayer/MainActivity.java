package com.example.ucsc.videoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView ishkVideoView = (VideoView)findViewById(R.id.ishkVideoView);
        ishkVideoView.setVideoPath("https://www.thenewboston.com/forum/project_files/006_testVideo.mp4");

        //player controls (play, pause, stop, etc...)
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(ishkVideoView);
        ishkVideoView.setMediaController(mediaController);

        ishkVideoView.start();



    }


}
