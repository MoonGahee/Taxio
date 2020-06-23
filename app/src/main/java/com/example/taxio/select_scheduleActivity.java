package com.example.taxio;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;
import java.util.Date;

public class select_scheduleActivity extends AppCompatActivity {
    Button ok;
    CalendarView cal;
    Calendar myCal;
    String date;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_schdule);
        setToolbar();

        ok = findViewById(R.id.ok);
        cal = findViewById(R.id.cal);
        myCal = Calendar.getInstance();
        int y = myCal.get(myCal.YEAR);
        int m = myCal.get(myCal.MONTH);
        int d = myCal.get(myCal.DAY_OF_MONTH);




        //cal.setMinDate(myCal.getTimeInMillis());//최소선택날은 오늘
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(select_scheduleActivity.this);
                dlg.setTitle("일정 확인");
                dlg.setMessage(date+"이 선택한 일정이 맞습니까?");
                dlg.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(select_scheduleActivity.this, select_taxiActivity.class);
                        i.putExtra("date", date);
                        startActivity(i);
                        finish();
                    }
                });
                dlg.setNegativeButton("아니오", null);
                dlg.show();

            }
        });//확인 버튼 눌렀을 때 다이얼로그

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = year + "년 " + (month + 1) + "월 " + dayOfMonth + "일";
            }
        });//달력 날짜 선택

    }



    public void setToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.abar); // 툴바를 액티비티의 앱바로 지정
        setSupportActionBar(toolbar); //툴바를 현재 액션바로 설정
        ActionBar actionBar = getSupportActionBar(); //현재 액션바를 가져옴
        actionBar.setDisplayShowTitleEnabled(false); //액션바의 타이틀 삭제
        actionBar.setDisplayHomeAsUpEnabled(true); //홈으로 가기 버튼 활성화
    }

}