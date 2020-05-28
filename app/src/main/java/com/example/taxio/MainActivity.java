package com.example.taxio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar bar = findViewById(R.id.bar);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

    }
}
