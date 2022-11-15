package com.ellisanthi.myappointment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button login,signup;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.button);
        signup=findViewById(R.id.button2);
        auth=FirebaseAuth.getInstance();


    }

    public void open(View view){

        Intent intent = new Intent(this, signupform.class);
        startActivity(intent);

    }

    public void login(View view){
        String email1 = email.getText().toString();
        String password1 = password.getText().toString();
        auth.signInWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    showMessage("Success","User signed in successfully!");
                    showMessage("UID",auth.getUid());
                }else {
                    showMessage("Error",task.getException().getLocalizedMessage());
                }
            }
        });
            }

    void showMessage(String title, String message){
        new AlertDialog.Builder(this).setTitle(title).setMessage(message).setCancelable(true).show();
    }
        }
