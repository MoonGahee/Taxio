package com.example.taxio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RecruitDriver extends AppCompatActivity {

    RadioGroup rg1, rg2, rg3;
    RadioButton noGender, manDriver, womanDriver, allTrunk, yesTrunk, noTrunk, under4, under6, over6;
    Button searchBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruit_driver);

        noGender = (RadioButton)findViewById(R.id.noGender);
        manDriver = findViewById(R.id.manDriver);
        womanDriver = findViewById(R.id.womanDriver);
        allTrunk = findViewById(R.id.allTrunk);
        yesTrunk = findViewById(R.id.yesTrunk);
        noTrunk = findViewById(R.id.noTrunk);
        under4 = findViewById(R.id.under4);
        under6 = findViewById(R.id.under6);
        over6 = findViewById(R.id.over6);
        searchBtn = findViewById(R.id.search_btn);

        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


}
