package com.example.covidata;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class sC3 extends AppCompatActivity {
    TextView tv, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_c3);


        tv = findViewById(R.id.tvres);
        tv2 = findViewById(R.id.tvres2);
        tv3 = findViewById(R.id.tvres3);
        // btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuilder sb = new StringBuilder();
        if((symptomCheck.correct1+sC2.correct2)>=5)
            sb.append("LOWER RISK OF COVID-19 : ").append("YES").append("\n");
        else
            sb.append("LOWER RISK OF COVID-19 : ").append("N0").append("\n");
        StringBuilder sb2 = new StringBuilder();


        if((symptomCheck.wrong1+sC2.wrong2)>=6)
            sb2.append("HIGHER RISK OF COVID-19 : ").append("YES").append("\n");
        else
            sb2.append("HIGHER RISK OF COVID-19 : ").append("N0").append("\n");
        StringBuilder sb3 = new StringBuilder();
        if(((symptomCheck.correct1+sC2.correct2)>=5))
            sb3.append("STAY HOME , BE SAFE");
        else
            sb3.append("CONSULT DOCTOR");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);


    }

}

