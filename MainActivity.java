package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity  {
    FirebaseAuth mAuth;
    EditText emaill,passwordd;
    Button btn;
    TextView register,movingtxt,forget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        emaill = findViewById(R.id.phone);
        passwordd = findViewById(R.id.enter_password_sign_in_activity);
        btn = findViewById(R.id.btnLogin);
        forget = findViewById(R.id.forgetTxt);
        register = findViewById(R.id.gotoRegister);
        movingtxt = findViewById(R.id.movingText);
        mAuth = FirebaseAuth.getInstance();
        movingtxt.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        movingtxt.setSelected(true);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Registration.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

    }
        @Override
        protected void onStart() {
            super.onStart();
            FirebaseUser user = mAuth.getCurrentUser();
            if(user == null){
                startActivity(new Intent(this,MainActivity.class));
            }
        }

        private void loginUser(){
          String email = emaill.getText().toString().trim();
          String password = passwordd.getText().toString().trim();

          if(TextUtils.isEmpty(email)){
              emaill.setError("Please enter your email");
              emaill.requestFocus();
          }else if(TextUtils.isEmpty(password)){
              passwordd.setError("Please enter your password");
              passwordd.requestFocus();
          }else{
              mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          startActivity(new Intent(MainActivity.this,FirstPage.class));
                      }else{
                          Toast.makeText(MainActivity.this, "Log in failed", Toast.LENGTH_SHORT).show();
                      }
                  }
              });
          }
        }
}
