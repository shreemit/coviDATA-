package com.example.covidata;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class sC2 extends AppCompatActivity {
    public static int marks2, correct2, wrong2;
    public static int marks, correct, wrong;
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2;
    String[] questions = {
            "Have you  or  someone  in  your family recently Interacted/Stayed/ Came  in  close  contact  with  a  Laboratory / Hospital confirmed COVID-19 patient in the past few Days/Months?",
            "Have you or someone in your family Staying with you attended a 'large Gathering / Migration Centre' in the past few Days/Months?",
            "Are  you  currently  working  for Essential   Services   in   public  exposed places (like  Hospitals , Retail outlets , Delivery Services)?",
            "Are u a healthcare worker and examined a COVID-19 patient without protective gear?",
            "Is someone in your family Staying with  you  currently  working  for Essential   Services    in    public  exposed places (like  Hospitals  , Retail outlets , Delivery Services)?",
            "Have you recently Traveled anywhere Nationally/Internationally in past few Days/Months?"

    };
    String[] answers = {"NO", "NO", "NO", "NO", "NO", "NO"};
    String[] opt = {"YES", "NO",
            "YES", "NO",
            "YES", "NO",
            "YES", "NO",
            "YES", "NO",
            "YES", "NO",
    };
    int flag = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_c2);


        TextView textView = findViewById(R.id.DispName);
        final Intent intent = getIntent();

        textView.setText("SYMPTOM CHECKER");

        submitbutton = findViewById(R.id.button3);

        tv = findViewById(R.id.tvque);

        radio_g = findViewById(R.id.answersgrp);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    correct2++;
                    Toast.makeText(getApplicationContext(), "Safe", Toast.LENGTH_SHORT).show();
                } else {
                    wrong2++;
                    Toast.makeText(getApplicationContext(), "Next", Toast.LENGTH_SHORT).show();
                }

                flag++;

                //if (score != null)
                // score.setText(""+correct2);

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 2]);
                    rb2.setText(opt[(flag * 2) + 1]);

                } else {
                    marks2 = correct2;
                    Intent intent = new Intent(getApplicationContext(), sC3.class);
                    startActivity(intent);
                }

                radio_g.clearCheck();
            }
        });


    }
}
