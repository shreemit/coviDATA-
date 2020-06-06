package com.example.covidata;


import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class familyDetails extends AppCompatActivity {
    LinearLayout linearLayout;
    EditText editT;
    Button btn;
    TextView tt;
    LinearLayout member;
    int btn_flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editT = findViewById(R.id.editTT);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_flag=1;
                linearLayout = findViewById(R.id.linear_layout);
                tt = new TextView(familyDetails.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                float bb = 10;
                final int noMem = Integer.parseInt(editT.getText().toString());
                final String check = editT.getText().toString().trim();

                if (check.length() >= 2 && TextUtils.isEmpty(check)) {
                    editT.setError("Incorrect");
                    return;
                }

                String temp = Integer.toString(noMem);
                for (int i = 0; i < noMem; i++) {
                    getfamilyd();
                    addLineSeperator();
                }
                linearLayout.addView(tt, layoutParams);

                btn.setEnabled(false);

            }
        });


    }


    private void addRadioButtons() {

        String[] gender = {"Male", "Female", "Other"};
        //RadioButtons are always added inside a RadioGroup
        RadioGroup radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        member.addView(radioGroup);
        if (radioGroup.getCheckedRadioButtonId() == -1)
            Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();


        for (int i = 1; i <= 3; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(gender[i - 1]);
            radioGroup.addView(radioButton);
            setRadioButtonAttributes(radioButton);
        }
    }

    private void addTextViews() {
        //Adding a LinearLayout with HORIZONTAL orientation
        LinearLayout textLinearLayout = new LinearLayout(this);
        textLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.addView(textLinearLayout);
        TextView textView = new TextView(this);
        textView.setText("TextView ");
        setTextViewAttributes(textView);
        textLinearLayout.addView(textView);
        addLineSeperator();
    }


    private void addCheckBoxes() {

        LinearLayout checkBoxLayout = new LinearLayout(this);
        checkBoxLayout.setOrientation(LinearLayout.VERTICAL);

        member.addView(checkBoxLayout);

        for (int i = 1; i <= 3; i++) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText("CheckBox " + String.valueOf(i));
            setCheckBoxAttributes(checkBox);
            checkBoxLayout.addView(checkBox);
        }
        addLineSeperator();
    }

    private void addEditTexts() {

        LinearLayout editTextLayout = new LinearLayout(this);
        editTextLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(editTextLayout);

        for (int i = 1; i <= 3; i++) {
            EditText editText = new EditText(this);
            editText.setHint("EditText " + String.valueOf(i));
            setEditTextAttributes(editText);
            editTextLayout.addView(editText);
        }
        addLineSeperator();
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

    private void setCheckBoxAttributes(CheckBox checkBox) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        params.setMargins(convertDpToPixel(16),
                convertDpToPixel(16),
                convertDpToPixel(16),
                0
        );

        checkBox.setLayoutParams(params);

        //This is used to place the checkbox on the right side of the textview
        //By default, the checkbox is placed at the left side
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.listChoiceIndicatorMultiple,
                typedValue, true);

        checkBox.setButtonDrawable(null);
        checkBox.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                typedValue.resourceId, 0);
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

    //This function to convert DPs to pixels
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

    private void getfamilyd() {
        member = new LinearLayout(this);
        member.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(member);

        TextView tx1 = new TextView(this);
        setTextViewAttributes(tx1);
        tx1.setText(("Enter your name"));
        member.addView(tx1);

        EditText et1 = new EditText(this);
        setEditTextAttributes(et1);
        et1.setHint("Full name");
        et1.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        final String name = et1.getText().toString().trim();
        member.addView(et1);

        TextView tx2 = new TextView(this);
        setTextViewAttributes(tx2);
        tx2.setText("Gender");
        member.addView(tx2);
        addRadioButtons();

        TextView tx3 = new TextView(this);
        setTextViewAttributes(tx3);
        tx3.setText("Age");
        member.addView(tx3);

        EditText et2 = new EditText(this);
        setEditTextAttributes(et2);
        et2.setHint("Age");
        et2.setInputType(InputType.TYPE_CLASS_PHONE);
        final String age = et1.getText().toString().trim();
        member.addView(et2);


        if (TextUtils.isEmpty(name)) {
            et1.setError("Name is required");
            return;
        }
        if (TextUtils.isEmpty(age) && age.length() >= 2) {
            et2.setError("Age is incorrect");
            return;
        }

    }
}

