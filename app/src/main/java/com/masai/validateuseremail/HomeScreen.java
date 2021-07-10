package com.masai.validateuseremail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {
    private TextView getEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getEmail =findViewById(R.id.getText);

        Intent inten = getIntent();
        String data = inten.getStringExtra("email");
        getEmail.setText(data);


    }
}