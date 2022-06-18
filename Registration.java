package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Registration extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText namee, phone_numberr, deptt, emaiil, passwordd;
    Button btn;
    DatabaseReference reff;
    Member member;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        namee = findViewById(R.id.Entername);
        phone_numberr = findViewById(R.id.editTextPhone);
        deptt = findViewById(R.id.department);
        emaiil = findViewById(R.id.EnterEmail);
        passwordd = findViewById(R.id.Enterpassword);
        btn = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);
        member = new Member();

        fAuth = FirebaseAuth.getInstance();
//        reff = FirebaseDatabase.getInstance().getReference().child("GSMP Polytechnic");

        btn.setOnClickListener(view -> {
            createUser();
        });
    }

    private void createUser() {
        String email = emaiil.getText().toString().trim();
        String password = passwordd.getText().toString().trim();
        String name = namee.getText().toString().trim();
        long phone = Long.parseLong(phone_numberr.getText().toString().trim());
        String department = deptt.getText().toString().trim();

        if (name.isEmpty()) {
            namee.requestFocus();
            Toast.makeText(Registration.this, "Please Enter your name", Toast.LENGTH_SHORT).show();
        } else if (email.isEmpty()) {
            emaiil.requestFocus();
            Toast.makeText(Registration.this, "Please Enter your Email address", Toast.LENGTH_SHORT).show();

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emaiil.setError("please provide a valid email");
            emaiil.requestFocus();

        } else if (password.length() < 6) {
            passwordd.setError("minimum length of the password is 6");
            passwordd.requestFocus();

        } else if (phone < 10) {
            phone_numberr.requestFocus();
            Toast.makeText(Registration.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();

        } else if (department.isEmpty()) {
            deptt.requestFocus();
            Toast.makeText(Registration.this, "Please Enter your department", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Registration.this, MainActivity.class));
                    } else {
                        Toast.makeText(Registration.this, "Registration failed ! Please try again" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}