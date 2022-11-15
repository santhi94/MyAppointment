package com.ellisanthi.myappointment;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class doctor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText editext1,editext2,editext3,editext4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.specs,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        editext1=findViewById(R.id.editTextTextPersonName);
        editext3=findViewById(R.id.editTextNumber);
        editext2=findViewById(R.id.editTextTextEmailAddress);
        editext4=findViewById(R.id.editTextTextPassword);
    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Please select a spec", Toast.LENGTH_SHORT).show();


    }

    public void submit(View view){
        if (TextUtils.isEmpty(editext1.getText().toString())) {
            editext1.setError("Please enter your Full name");
        } else if (TextUtils.isEmpty(editext2.getText().toString())) {
            editext2.setError("Please enter your email");
        }else if (TextUtils.isEmpty(editext3.getText().toString())) {
            editext2.setError("Please confirm your phone");
        }else if (TextUtils.isEmpty(editext4.getText().toString())) {
            editext4.setError("Please enter your password");
        }else{
            Toast.makeText(this, "You have signed up successfully", Toast.LENGTH_SHORT).show();
        }
    }
}