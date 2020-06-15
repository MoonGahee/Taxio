package com.example.taxio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;
import java.util.Date;

public class select_scheduleActivity extends AppCompatActivity {
    Button ok;
    CalendarView cal;
    Calendar myCal, start, finish;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        ok = findViewById(R.id.ok);
        cal = findViewById(R.id.cal);
        myCal = Calendar.getInstance();

        cal.setOnDateChangeListener((CalendarView.OnDateChangeListener) this);
        
        cal.setMinDate(myCal.getTimeInMillis());//최소선택날은 오늘
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(select_scheduleActivity.this, select_taxiActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void onDateSelected(MaterialCalendarView c, CalendarDay d, boolean s){

    }

    public void onMonthChanged(MaterialCalendarView c, CalendarDay d){}

    public void setToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.abar); // 툴바를 액티비티의 앱바로 지정
        setSupportActionBar(toolbar); //툴바를 현재 액션바로 설정
        ActionBar actionBar = getSupportActionBar(); //현재 액션바를 가져옴
        actionBar.setDisplayShowTitleEnabled(false); //액션바의 타이틀 삭제
        actionBar.setDisplayHomeAsUpEnabled(true); //홈으로 가기 버튼 활성화
    }

}
