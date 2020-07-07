package com.example.covidata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;

import static android.util.Log.d;


public class MainActivity extends AppCompatActivity {
    String TAG = "main Activity";
    Button logoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Toolbar for Logout Button
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VideoView videoView=findViewById(R.id.video_view);
        videoView.setVisibility(View.VISIBLE);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.sample_video2;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        Toast.makeText(MainActivity.this, "Firebase connection successful", Toast.LENGTH_LONG).show();
        logoutButton=findViewById(R.id.buttonLog);

    }

    //Function to logout firebase account
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(),login.class));
        finish();
    }


    //Function to go to the symptom checker page
    public void SymptonCheck(View view) {

        startActivity(new Intent(getApplicationContext(),symptomCheck.class));
        finish();
    }

    }



