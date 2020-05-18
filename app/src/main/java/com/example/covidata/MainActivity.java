package com.example.covidata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        Toast.makeText(MainActivity.this, "Firebase connection successful", Toast.LENGTH_LONG).show();
        logoutButton=findViewById(R.id.buttonLog);
    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(),login.class));
        finish();
    }

    public void SymptonCheck(View view) {
        startActivity(new Intent(getApplicationContext(),symptomCheck.class));
        finish();
    }

    }



