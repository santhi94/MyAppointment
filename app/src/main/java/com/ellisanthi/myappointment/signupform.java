package com.ellisanthi.myappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signupform extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupform);
    }

    public void patient(View view){
        Intent intent = new Intent(this, patient.class);
        startActivity(intent);

    }
    public void doctor(View view){
        Intent intent = new Intent(this, doctor.class);
        startActivity(intent);

    }
}