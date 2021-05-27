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

public class LoginActivity extends AppCompatActivity {
    private EditText emailTextView, passwordTextView;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        // initialising all views through id defined above
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login);
        progressbar = findViewById(R.id.progressBar);
        TextView registerActivity = findViewById(R.id.activity_register);

        // Set on Click Listener on Sign-in button
        loginButton.setOnClickListener(v -> loginUserAccount());

        registerActivity.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegistrationActivity.class)));

    }

    private void loginUserAccount() {
        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        // Take the value of two edit texts in Strings
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();

        // validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Email cannot be empty", Toast.LENGTH_LONG).show();
            emailTextView.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Password cannot be empty", Toast.LENGTH_LONG).show();
            passwordTextView.requestFocus();
            return;
        }

        // sign in existing user
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();

                // hide the progress bar
                ProgressBar progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.GONE);

                // if sign-in is successful
                // intent to HomeScreen activity
                Intent intent = new Intent(LoginActivity.this, HomeScreen.class);
                startActivity(intent);
            } else {

                // sign-in failed
                Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_LONG).show();

                // hide the progress bar
                progressbar.setVisibility(View.GONE);
            }
        });
    }

}