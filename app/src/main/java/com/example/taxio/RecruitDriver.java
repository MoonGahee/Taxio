package com.example.taxio;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class RecruitDriver extends AppCompatActivity {

    private RecyclerRecruitDriver adapter;
    RadioGroup rg1, rg2, rg3;
    RadioButton noGender, manDriver, womanDriver, allTrunk, yesTrunk, noTrunk, under4, under6, over6;
    Button searchBtn;
    TextView title_text;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruit_driver);

        toolbar = (Toolbar)findViewById(R.id.abar); // 툴바를 액티비티의 앱바로 지정
        setSupportActionBar(toolbar); //툴바를 현재 액션바로 설정
        ActionBar actionBar = getSupportActionBar(); //현재 액션바를 가져옴
        actionBar.setDisplayShowTitleEnabled(false); //액션바의 타이틀 삭제
        actionBar.setDisplayHomeAsUpEnabled(true); //홈으로 가기 버튼 활성화

        title_text = findViewById(R.id.title_text);
        title_text.setClickable(true);

        title_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecruitDriver.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        //객체 선언
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

        //RadioButton 활용

        //RecyclerView 사용
        init();
        getData();

    }

    public void init(){ //LayoutManager와 Adapter를 활용하여 (?) RecyclerView에 연결을 해주는 기능
        RecyclerView recyclerView_driver = findViewById(R.id.recyclerView_driver);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_driver.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerRecruitDriver();
        recyclerView_driver.setAdapter(adapter);
    }

    public void getData(){ //임시 데이터값 추가
        List<String> listDriverName = Arrays.asList("1", "2", "3");

        List<String> listDriverInfo = Arrays.asList("ㄱ", "ㄴ", "ㄷ");

        List<String> listDriverPrice = Arrays.asList("가", "나", "다");

        List<Integer> listDriverPhoto = Arrays.asList(R.drawable.taxi, R.drawable.taxi, R.drawable.taxi);

        for(int i = 0; i < listDriverName.size(); i++){  //DriverData Class 객체에 set
            DriverData data = new DriverData();
            data.setDriverName(listDriverName.get(i));
            data.setDriverInfo(listDriverInfo.get(i));
            data.setDirverPrice(listDriverPrice.get(i));
            data.setDriverPhoto(listDriverPhoto.get(i));

            adapter.addData(data); //RecyclerRecruitDriver.java의 addData로 값을 전달함
        }

        adapter.notifyDataSetChanged(); //adapter값이 변경되었음
    }


    // 툴바 버튼 클릭 이벤트
    public void goMain(ImageView logo){//로고버튼 클릭시
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecruitDriver.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {//toolbar의 back키 눌렀을 시
        switch (item.getItemId()){
            case android.R.id.home:{//이전 화면으로 돌아감
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
