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

import java.util.Arrays;
import java.util.List;

public class TripSchedule extends AppCompatActivity {
    private RecyclerTripSchedule adapter;
    TextView title_text;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //AppBar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_schedule);

        toolbar = (Toolbar) findViewById(R.id.appbar); // 툴바를 액티비티의 앱바로 지정
        setSupportActionBar(toolbar); //툴바를 현재 액션바로 설정
        ActionBar actionBar = getSupportActionBar(); //현재 액션바를 가져옴
        //actionBar.setDisplayShowTitleEnabled(false); //액션바의 타이틀 삭제
        //actionBar.setDisplayHomeAsUpEnabled(true); //홈으로 가기 버튼 활성화에서 왜 null에러?
        // AppBar
        init();
        getData();

    }

    public void init() { //리사이클러뷰 출력
        RecyclerView tripRecycler = findViewById(R.id.tripRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        tripRecycler.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerTripSchedule();
        tripRecycler.setAdapter(adapter);
    }

    private void getData() { //임시 데이터
        List<String> listTripSchedule = Arrays.asList("여행 날짜 : 20.05.22 ~ 20.05.24\n5월 22일 : 제주공항 - 용문사 - 오설록 - 신라호텔", "여행 날짜 : 20.05.22 ~ 20.05.24\n5월 22일 : 제주공항 - 용문사 - 오설록 - 신라호텔", "여행 날짜 : 20.05.22 ~ 20.05.24\n5월 22일 : 제주공항 - 용문사 - 오설록 - 신라호텔");

        List<String> listTripPosition = Arrays.asList("여행중", "모집 중", "여행 준비");

        for (int i = 0; i < listTripSchedule.size(); i++) {
            TripData data = new TripData();
            data.setTripSchedule(listTripSchedule.get(i));
            data.setTripPosition(listTripPosition.get(i));

            adapter.addItem(data);
        }

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
