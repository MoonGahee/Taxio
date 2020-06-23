package com.example.taxio;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.akshaykale.swipetimeline.TimelineFragment;
import com.akshaykale.swipetimeline.TimelineGroupType;
import com.akshaykale.swipetimeline.TimelineObject;
import com.akshaykale.swipetimeline.TimelineObjectClickListener;

import java.util.ArrayList;

public class CheckSchedule extends AppCompatActivity implements TimelineObjectClickListener {

    Button edit_btn, taxi_btn, recommend, trip_fin;
    Toolbar toolbar;
    TextView title_text;
    TimelineFragment mFragment = new TimelineFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_schdule);

        toolbar = (Toolbar)findViewById(R.id.abar); // 툴바를 액티비티의 앱바로 지정
        setSupportActionBar(toolbar); //툴바를 현재 액션바로 설정
        ActionBar actionBar = getSupportActionBar(); //현재 액션바를 가져옴
        actionBar.setDisplayShowTitleEnabled(false); //액션바의 타이틀 삭제
        actionBar.setDisplayHomeAsUpEnabled(true); //홈으로 가기 버튼 활성화

        mFragment.setData(loadData(), TimelineGroupType.DAY);
        mFragment.addOnClickListener(this);

        mFragment.setTimelineHeaderSize(0);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.trip1, mFragment);
        transaction.replace(R.id.trip1, mFragment);
        transaction.commit();

        title_text = findViewById(R.id.title_text);
        title_text.setClickable(true);

        title_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckSchedule.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        edit_btn = findViewById(R.id.trip_edit1);
        taxi_btn = findViewById(R.id.taxi_btn1);
        recommend = findViewById(R.id.recommend1);
        trip_fin = findViewById(R.id.trip_fin);

        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckSchedule.this, UpdateSchedule.class);
                startActivity(i);
            }
        });

        taxi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckSchedule.this, select_taxiActivity.class);
                startActivity(i);
            }
        });

        recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckSchedule.this, RecommendTrip.class);
                startActivity(i);
            }
        });

        trip_fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckSchedule.this, RecruitDriver.class);
                startActivity(i);
            }
        });
    }

    private ArrayList<TimelineObject> loadData() {
        ArrayList<TimelineObject> obj = new ArrayList<>();

        obj.add(new TestO(Long.parseLong("1483196400000"), "제주공항", "url"));
        obj.add(new TestO(Long.parseLong("1484146800000"), "용두암", "url"));
        obj.add(new TestO(Long.parseLong("1485961200000"), "성산일출봉", "url"));
        obj.add(new TestO(Long.parseLong("1487084400000"), "동문시장", "url"));
        obj.add(new TestO(Long.parseLong("1489244400000"), "하얏트호텔", "url"));

        return obj;
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

    @Override
    public void onTimelineObjectClicked(TimelineObject timelineObject) {

    }

    @Override
    public void onTimelineObjectLongClicked(TimelineObject timelineObject) {

    }
}