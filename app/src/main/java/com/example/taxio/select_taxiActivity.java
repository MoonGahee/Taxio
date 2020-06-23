package com.example.taxio;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class select_taxiActivity extends AppCompatActivity  {
    Button start_btn, ok;
    Spinner rent_spin;
    TextView taxi_day;
    String time, startTime;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_taxi);
        setToolbar();
        start_btn = findViewById(R.id.start_btn);
        ok = findViewById(R.id.ok);
        rent_spin = findViewById(R.id.rent_spin);
        taxi_day = findViewById(R.id.taxi_day);
        Intent intent = new Intent();
        String date = intent.getStringExtra("date");




        rent_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                time = String.valueOf(rent_spin.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePick(v);
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(select_taxiActivity.this, FindSchedule_Activity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void timePick(View v){
        TimePickerDialog d= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                startTime = hourOfDay+"시 "+minute+"분";
            }
        }, 0,0,false);
        d.setMessage("출발 시간");
        d.show();

    }



    public void setToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.abar); // 툴바를 액티비티의 앱바로 지정
        setSupportActionBar(toolbar); //툴바를 현재 액션바로 설정
        ActionBar actionBar = getSupportActionBar(); //현재 액션바를 가져옴
        actionBar.setDisplayShowTitleEnabled(false); //액션바의 타이틀 삭제
        actionBar.setDisplayHomeAsUpEnabled(true); //홈으로 가기 버튼 활성화

    }
}