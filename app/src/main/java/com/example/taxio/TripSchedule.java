package com.example.taxio;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TripSchedule extends AppCompatActivity {

    TextView title_text;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.abar); // 툴바를 액티비티의 앱바로 지정
        setSupportActionBar(toolbar); //툴바를 현재 액션바로 설정
        ActionBar actionBar = getSupportActionBar(); //현재 액션바를 가져옴
        actionBar.setDisplayShowTitleEnabled(false); //액션바의 타이틀 삭제
        actionBar.setDisplayHomeAsUpEnabled(true); //홈으로 가기 버튼 활성화

        ArrayList<String> list = new ArrayList<>();
        RecyclerView recyclerView1 = findViewById(R.id.tripRecycler);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        RecyclerTripSchedule adapter = new RecyclerTripSchedule(list);
        recyclerView1.setAdapter(adapter);

        adapter.addTrip("여행 날짜 : 20.05.22 ~ 20.05.24\n5월 22일 : 제주\n 공항 - 용문사 - 오설록 ...\n\n(홍길동 기사님)\n5월 23일 : 신라호텔 우도선착장 - 애월...");
        adapter.addTrip("여행 날짜 : 20.05.23 ~ 20.05.24\n5월 23일 : 제주\n 공항 - 용문사 - 오설록 ...\n\n(홍길동 기사님)\n5월 23일 : 신라호텔 우도선착장 - 애월...");
        adapter.addDetail("모집 중");
        adapter.addDetail("여행 중");
        adapter.notifyDataSetChanged();
    }

    public void goMain(ImageView logo) {//로고버튼 클릭시
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TripSchedule.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {//toolbar의 back키 눌렀을 시
        switch (item.getItemId()) {
            case android.R.id.home: {//이전 화면으로 돌아감
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
