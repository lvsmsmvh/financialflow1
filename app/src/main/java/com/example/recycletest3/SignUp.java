package com.example.recycletest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText etName = findViewById(R.id.et_name_reg);
        final EditText etEmail = findViewById(R.id.et_email_reg);
        EditText etPass = findViewById(R.id.et_pass_reg);
        Button btnSignup = findViewById(R.id.btn_reg);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Registration completed! Login now.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), SignIn.class));
            }
        });
    }
}
