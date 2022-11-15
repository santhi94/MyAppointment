package com.ellisanthi.myappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class patient extends AppCompatActivity {
    EditText editext1,editext2,editext3,editext4,editext5;
    String text,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        editext1=findViewById(R.id.editTextTextPersonName);
        editext2=findViewById(R.id.editTextTextPersonName2);
        editext3=findViewById(R.id.editTextTextEmailAddress);
        editext4=findViewById(R.id.editTextTextPassword);
        editext5=findViewById(R.id.editTextTextPassword2);


    }

    public void submit (View view){
        text =editext4.getText().toString();
        text2 =editext5.getText().toString();
        if (TextUtils.isEmpty(editext1.getText().toString())) {
            editext1.setError("Please enter your Full name");
        } else if (TextUtils.isEmpty(editext2.getText().toString())) {
            editext2.setError("Please enter your username");
        }else if (TextUtils.isEmpty(editext3.getText().toString())) {
            editext2.setError("Please confirm your email");
        }else if (TextUtils.isEmpty(editext4.getText().toString())) {
            editext4.setError("Please enter your password");
        } else if(!text.equals(text2)){
            editext5.setError("Your password doesn't match!");

        }else{
            Toast.makeText(this, "You have signed up successfully", Toast.LENGTH_SHORT).show();
        }

    }
}