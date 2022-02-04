package com.example.purpleactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabActivity extends AppCompatActivity {
    ViewPager2 pager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        String [] tabTtiles={"Home","Chat","Notification","Account","iuyijk"};
        pager= findViewById(R.id.pager);
        tabLayout= findViewById(R.id.tablayout);


        Drawable[] tabicon = new Drawable[5];
        tabicon[0] = getResources().getDrawable(R.drawable.cart);
        tabicon[1] = getResources().getDrawable(R.drawable.smile);
        tabicon[2] = getResources().getDrawable(R.drawable.cart);
        tabicon[3] = getResources().getDrawable(R.drawable.smile);
        tabicon[4] = getResources().getDrawable(R.drawable.cart);

        int[] List = new int[5];
        List[0]= (R.drawable.s1);
        List[1]= (R.drawable.s2);
        List[2]= (R.drawable.s3);
        List[3]= (R.drawable.s5);
        List[4]= (R.drawable.s6);
        pager.setAdapter(new SliderAdapter(List));
        new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setIcon(tabicon[position]);
            }
        }).attach();

    }
}