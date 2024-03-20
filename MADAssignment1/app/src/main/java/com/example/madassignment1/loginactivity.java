package com.example.madassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {
    EditText emailEditText,passwordEditText;
    Button login_btn;
    int counter=2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        emailEditText=(EditText)findViewById(R.id.editTextTextEmailAddress2);
        passwordEditText=(EditText)findViewById(R.id.editTextTextPassword2);
        login_btn=(Button)findViewById(R.id.button2);
        String registeredEmail = getIntent().getStringExtra("email");
        String registeredPassword= getIntent().getStringExtra("password");
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(registeredEmail.equals(email) && registeredPassword.equals(password))
                {
                    Intent intent= new Intent(loginactivity.this,successful_login.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(loginactivity.this, "Invalid Email Id or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}