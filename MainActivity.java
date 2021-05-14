package com.example.houseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {


    private ViewPager2 sliderViewPager;
    private LinearLayout layoutIndicator;
    private ListView listView;

    private String[] images = ImageFile.getImage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {        //생성함수
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         //레이어 표시

        listView = findViewById(R.id.listView);
        sliderViewPager = findViewById(R.id.sliderViewPager);
        layoutIndicator = findViewById(R.id.layoutIndicators);      //id추출


        sliderViewPager.setOffscreenPageLimit(1);
        sliderViewPager.setAdapter(new ImageSliderAdapter(this, images));       //슬라이더뷰(화면)랑 이미지뷰 연결
        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {        //콜백함수
            @Override
            public void onPageSelected(int position) {              //화면 이동마다 position값 변경
                super.onPageSelected(position);
                setCurrentIndicator(position);                  //현재 포지션 설정(콜백마다)
            }
        });
        setupIndicators(images.length);         //indicator설정



    }

    void setupIndicators(int count) {                   //포지션 넣기
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);      //포지션 이미지 크기

        params.setMargins(16, 8, 16, 8);        //이미지 크기 설정

        for (int i = 0; i < indicators.length; i++) {                   //반복하면서 indicater 추가(inactivation으로)
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this,
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
        setCurrentIndicator(0);                 //현재 indicator 위치 초기화
    }

    void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();               //추가된 오브젝트 갯수
        for (int i = 0; i < childCount; i++) {                          //반복하면서 position과 현재 index체크
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this,
                        R.drawable.bg_indicator_active
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this,
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }

}