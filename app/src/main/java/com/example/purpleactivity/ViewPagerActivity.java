package com.example.purpleactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ViewPagerActivity extends AppCompatActivity {
    NonSwipeableViewPager pager;
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);


    }
}