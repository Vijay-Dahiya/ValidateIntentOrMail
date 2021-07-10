package com.masai.validateuseremail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity {
    private TextView mbtnEmail;
    private TextView mbtnPswrd;
    private Button mbtnLogin;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        Intent intent = getIntent();
        mbtnEmail = findViewById(R.id.btnEmail);
        mbtnPswrd = findViewById(R.id.btnPswrd);
        mbtnLogin = findViewById(R.id.btnLogin);
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isPasswordValid = isPasswordValid();
                boolean isEmailValid = isEmailValid();
                if (isEmailValid && isPasswordValid) {
                    Intent inten = new Intent(LoginScreen.this, HomeScreen.class);
                    inten.putExtra("email", "Your Email id : "+ mbtnEmail.getText().toString());
                    startActivity(inten);
                    Log.d("STo", "after startactivity");
                }
            }

        });
    }
    private boolean isEmailValid() {
        if (mbtnEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mbtnEmail.setError("Invalid email");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (mbtnPswrd.getText().toString().length() >= 6) {
            return true;
        } else {
            mbtnPswrd.setError("Password length is less than 6 characters");
            return false;
        }
    }
}