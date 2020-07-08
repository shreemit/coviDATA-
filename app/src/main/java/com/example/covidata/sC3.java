package com.example.covidata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class sC3 extends AppCompatActivity {
    VideoView tv;
    TextView sb3;
    Button exit;
    int flag3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_c3);

        exit=findViewById(R.id.exit);
        sb3 = findViewById(R.id.bottom_text);

        VideoView videoView=findViewById(R.id.video_view);
        videoView.setVisibility(View.INVISIBLE);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.yoga_video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

//        tv2 = (TextView)findViewById(R.id.tvres2);
//        tv3 = (TextView)findViewById(R.id.tvres3);
        // btnRestart = (Button) findViewById(R.id.btnRestart);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


        if(((symptomCheck.correct1+sC2.correct2)>=5))
        {
            sb3.setText("STAY HOME , BE SAFE \n PRACTICE YOGA");
            videoView.setVisibility(View.VISIBLE);
        }

        else {

            videoView.setVisibility(View.INVISIBLE);
            sb3.setText("CONSULT DOCTOR \n");
        }




//        tv.setText(sb);
//        tv2.setText(sb2);
//        tv3.setText(sb3);


    }

}

