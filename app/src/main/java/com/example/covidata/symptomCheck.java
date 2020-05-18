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

public class symptomCheck extends AppCompatActivity {
    public static int marks1, correct1, wrong1;
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    String[] questions = {

            "Are u experiencing any of these following Symptoms?",
            "Have u ever had any of these following health Conditions?",
            "Do you currently have any of these following Symptoms?",
            "Did you have any of these following health Conditions Before?",

    };
    String[] answers = {"None of the Above*", "None of the Above", "None of the Above", "None of the Above"};
    String[] opt = {
            "Dry Cough", "High Fever", "Difficulty in Breathing", "All of the Above", "None of the Above",
            "Diabetes", "Hypertension", "Lung Disease", "All of the Above", "None of the Above",
            "Headache", "Running Nose", "Sore Throat", "All of the Above", "None of the Above",
            "Asthma", "Cancer", "Heart Disease", "All of the Above", "None of the Above"

    };
    int flag = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.DispName);
        final Intent intent = getIntent();

        textView.setText("SYMPTOM CHECKER");

        submitbutton = findViewById(R.id.button3);
        tv = findViewById(R.id.tvque);

        radio_g = findViewById(R.id.answersgrp);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        rb5 = findViewById(R.id.radioButton5);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        rb5.setText(opt[4]);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    correct1++;
                    Toast.makeText(getApplicationContext(), "Safe", Toast.LENGTH_SHORT).show();
                } else {
                    wrong1++;
                    Toast.makeText(getApplicationContext(), "Next", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 5]);
                    rb2.setText(opt[(flag * 5) + 1]);
                    rb3.setText(opt[(flag * 5) + 2]);
                    rb4.setText(opt[(flag * 5) + 3]);
                    rb5.setText(opt[(flag * 5) + 4]);
                }
                else
                {
                    marks1 = correct1;
                    Intent intent = new Intent(getApplicationContext(), sC2.class);
                    startActivity(intent);
                }
                radio_g.clearCheck();
            }
        });
    }
}

