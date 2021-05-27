package com.dhruvdevapp.onestop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailTextView, passwordTextView;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        // initialising all views through id defined above
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.passwd);
        Button regBtn = findViewById(R.id.btnregister);
        progressbar = findViewById(R.id.progressbar);
        TextView loginActivity = findViewById(R.id.activity_login);

        // Set on Click Listener on Registration button
        regBtn.setOnClickListener(v -> registerNewUser());
        loginActivity.setOnClickListener(v -> startActivity(new Intent(RegistrationActivity.this, LoginActivity.class)));

    }

    private void registerNewUser() {
        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        // Take the value of two edit texts in Strings
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();

        // Validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_LONG).show();
            emailTextView.requestFocus();   //  Takes cursor to email edit text
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!!", Toast.LENGTH_LONG).show();
            passwordTextView.requestFocus();
            return;
        }
        // create new user or register new user
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> { ProgressBar progressBar = findViewById(R.id.progressbar);
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_LONG).show();

                        // hide the progress bar
                        progressBar.setVisibility(View.GONE);
                        // if the user created intent to login activity
                        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);startActivity(intent);

                    } else {
                        // Registration failed
                        Toast.makeText(getApplicationContext(), "Registration failed\nPlease try again later", Toast.LENGTH_LONG).show();
                        // hide the progress bar
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }
}