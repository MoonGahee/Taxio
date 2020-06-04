package com.example.taxio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CheckSchedule extends AppCompatActivity {

    Button edit_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_schdule);

        edit_btn = findViewById(R.id.trip_edit1);

        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckSchedule.this, UpdateSchedule.class);
                startActivity(intent);
            }
        });
    }
}
