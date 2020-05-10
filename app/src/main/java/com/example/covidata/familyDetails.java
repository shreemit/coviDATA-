package com.example.covidata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class familyDetails extends AppCompatActivity {
    EditText noOfMembers;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_details);
        linearLayout = findViewById(R.id.mainLayout);
        noOfMembers = findViewById(R.id.noPPL);
        int num = Integer.parseInt(noOfMembers.getText().toString().trim());
        linearLayout = findViewById(R.id.dynamicLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        addLineSeperator();
       /* for (int i = 0; i < num; i++) {
          //  addMember(i);
            addTextViews("Member " + i + "Details");
            addLineSeperator();
            addTextViews("Name");
            addEditTexts();
            addTextViews("Age");
            addEditTexts();
        }*/
    }

    public void addMember(int i) {
        /*addTextViews("Member " + i + "Details");
        addLineSeperator();
        addTextViews("Name");
        addEditTexts();
        addTextViews("Age");
        addEditTexts();*/
    }


    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
    }

    private void addRadioButtons() {

        //RadioButtons are always added inside a RadioGroup
        RadioGroup radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.addView(radioGroup);
        for (int i = 1; i <= 3; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText("Option " + String.valueOf(i));
            radioGroup.addView(radioButton);
            setRadioButtonAttributes(radioButton);
        }
        addLineSeperator();
    }


    private void setRadioButtonAttributes(RadioButton radioButton) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(convertDpToPixel(16),
                convertDpToPixel(16),
                0, 0
        );

        radioButton.setLayoutParams(params);
    }

    private void addEditTexts() {

        LinearLayout editTextLayout = new LinearLayout(this);
        editTextLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(editTextLayout);

        EditText editText = new EditText(this);
        setEditTextAttributes(editText);
        editTextLayout.addView(editText);
    }

    private void setEditTextAttributes(EditText editText) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(convertDpToPixel(16),
                convertDpToPixel(16),
                convertDpToPixel(16),
                0
        );

        editText.setLayoutParams(params);
    }

    private void addTextViews(String sentData) {
        //Adding a LinearLayout with HORIZONTAL orientation
        LinearLayout textLinearLayout = new LinearLayout(this);
        textLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        linearLayout.addView(textLinearLayout);

        TextView textView = new TextView(this);
        textView.setText(sentData);
        setTextViewAttributes(textView);
        textLinearLayout.addView(textView);
    }

    private void setTextViewAttributes(TextView textView) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(convertDpToPixel(16),
                convertDpToPixel(16),
                0, 0
        );

        textView.setTextColor(Color.BLACK);
        textView.setLayoutParams(params);
    }

    private int convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    private void addLineSeperator() {
        LinearLayout lineLayout = new LinearLayout(this);
        lineLayout.setBackgroundColor(Color.GRAY);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2);
        params.setMargins(0, convertDpToPixel(10), 0, convertDpToPixel(10));
        lineLayout.setLayoutParams(params);
        linearLayout.addView(lineLayout);
    }


}
