package com.example.taxio;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.akshaykale.swipetimeline.TimelineFragment;
import com.akshaykale.swipetimeline.TimelineGroupType;
import com.akshaykale.swipetimeline.TimelineObject;
import com.akshaykale.swipetimeline.TimelineObjectClickListener;

import java.util.ArrayList;


public class FindSchedule_Activity extends AppCompatActivity implements TimelineObjectClickListener {

    net.daum.mf.map.api.MapView map;
    AutoCompleteTextView search;
    String jeju[] = {"용두암", "용머리해안", "성산일출봉", "한라산"};
    TextView title_text;
    TimelineFragment mFragment = new TimelineFragment();
    Button finish;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        setToolbar();
        AutoCompleteTextView search = findViewById(R.id.search);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,jeju);
        search.setAdapter(adapter);

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
                Intent i = new Intent(FindSchedule_Activity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        finish = findViewById(R.id.finish);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FindSchedule_Activity.this, CheckSchedule.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void setToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.abar); // 툴바를 액티비티의 앱바로 지정
        setSupportActionBar(toolbar); //툴바를 현재 액션바로 설정
        ActionBar actionBar = getSupportActionBar(); //현재 액션바를 가져옴
        actionBar.setDisplayShowTitleEnabled(false); //액션바의 타이틀 삭제
        actionBar.setDisplayHomeAsUpEnabled(true); //홈으로 가기 버튼 활성화
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

    @Override
    public void onTimelineObjectClicked(TimelineObject timelineObject) {

    }

    @Override
    public void onTimelineObjectLongClicked(TimelineObject timelineObject) {

    }
}