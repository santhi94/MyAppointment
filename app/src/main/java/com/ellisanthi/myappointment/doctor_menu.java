package com.ellisanthi.myappointment;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class doctor_first extends AppCompatActivity {
    Button myappointments;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_first);
        Intent intent = getIntent();
        String email1= intent.getStringExtra("email");
        username = findViewById(R.id.textView36);
        myappointments=findViewById(R.id.button13);
        FirebaseAuth fAuth = FirebaseAuth.getInstance();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("DoctorsInfo");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot datas : snapshot.getChildren()) {
                    String email2 = datas.child("d_email").getValue().toString();
                    if(email1.equals(email2)) {
                        String name = datas.child("doctorfullName").getValue().toString();
                        username.setText(name);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }

    public void go1(View view){
        String username1=username.getText().toString();
        Intent intent = new Intent(doctor_first.this, doctor_profile.class);
        intent.putExtra("username",username1);
        startActivity(intent);
    }

    public void go2(View view){
        String username2=username.getText().toString();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        try {
            mAuth.signOut();
            Toast.makeText(this, username2+"  You have been successfully signed out!", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,doctor_login.class);
            startActivity(intent);
        }catch (Exception e) {
            Log.e(TAG, "onClick: Exception "+e.getMessage(),e );
        }

    }
}